import java.io.*;
import java.util.*;

class UserManager {
    // private String filename;
    private List<Client> clients;
    private StockController stockController;
    public UserManager(String dirname) {
        StockMarket market = BackupController.getInstance().loadUpStockMarket();
        this.stockController = new StockController(new StocksView(),market);

        clients = new ArrayList<Client>();
        File dir = new File(dirname);
        String[] userfiles = dir.list();
        if (userfiles == null) {
            System.err.println("not a dir!");
        }
        else {
            for (int i=0; i< userfiles.length; i++) {
                String filename = userfiles[i];
                System.out.println(filename);
                clients.add(loadClient(dirname+"/"+filename));
            }
        }
    }

    public StockController getStockController(){return  stockController;};

    public Client loadClient(String filename) {
        Admin admin = Admin.getInstance();
        
        try {
            File file = new File(filename);
            InputStreamReader reader = new InputStreamReader(new FileInputStream(file));
            BufferedReader br = new BufferedReader(reader);
            String line = "";
            line = br.readLine();
            if (line != null) {
                String[] strs = line.split(" ");
                Client client = new Client(strs[0], strs[1], admin);
                System.out.println(client.getUserName());
                line = br.readLine();
                while (line != null) {
                    strs = line.split(" ");
                    if (strs[0].equalsIgnoreCase("CHECKING")) {
                        String dateStr = strs[1];
                        String[] days = dateStr.split("/");

                        String time = strs[2];
                        String[] times = time.split(":");
                        int[] date = {Integer.parseInt(days[0]), Integer.parseInt(days[1]), Integer.parseInt(days[2]), Integer.parseInt(times[0])};

                        float usd = Float.parseFloat(strs[3]);
                        float eur = Float.parseFloat(strs[4]);
                        float cny = Float.parseFloat(strs[5]);
                        float jpy = Float.parseFloat(strs[6]);
                        float loan = Float.parseFloat(strs[7]);
                        
                        CheckingAccount acc = new CheckingAccount(0, usd, eur, cny, jpy, loan, date);
                        client.addAccount(acc);
                    } else if (strs[0].equalsIgnoreCase("SAVING")) {
                        String dateStr = strs[1];
                        String[] days = dateStr.split("/");

                        String time = strs[2];
                        String[] times = time.split(":");
                        int[] date = {Integer.parseInt(days[0]), Integer.parseInt(days[1]), Integer.parseInt(days[2]), Integer.parseInt(times[0])};

                        float usd = Float.parseFloat(strs[3]);
                        float eur = Float.parseFloat(strs[4]);
                        float cny = Float.parseFloat(strs[5]);
                        float jpy = Float.parseFloat(strs[6]);
                        SavingAccount acc = new SavingAccount(usd, eur, cny, jpy, date);
                        client.addAccount(acc);
                    } else if (strs[0].equalsIgnoreCase("STOCK")) {
                        String dateStr = strs[1];
                        String[] days = dateStr.split("/");

                        String time = strs[2];
                        String[] times = time.split(":");
                        int[] date = {Integer.parseInt(days[0]), Integer.parseInt(days[1]), Integer.parseInt(days[2]), Integer.parseInt(times[0])};

                        float usd = Float.parseFloat(strs[3]);
                        float eur = Float.parseFloat(strs[4]);
                        float cny = Float.parseFloat(strs[5]);
                        float jpy = Float.parseFloat(strs[6]);

                        StockAccount acc = new StockAccount(usd, eur, cny, jpy, date);
                        
                        for(int i = 7; i < strs.length; i++) {
                            
                            if(strs[i].length() > 1) {
                                String[] stockInfo = strs[i].split("\\|");
                                acc.addHeldStock(new HeldStock(getStockController().getStock(stockInfo[0]), 
                                                            Integer.parseInt(stockInfo[1]), 
                                                            Float.parseFloat(stockInfo[2])));
                            }
                        }

                        client.addAccount(acc);
                    } else {
                        //
                    }
                    line = br.readLine();
                }
                return client;
            }
            return null;
            
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void addUser(Client user) {
        this.clients.add(user);
    }

    public List<Client> getUsers() {
        return this.clients;
    }

    public void printUsers() {
        System.out.println("printing users...");
        for (User user : clients) {
            System.out.println(user);
            for(Account acc : user.getAccounts()) {
                System.out.println(acc);
            }
        }
        System.out.println("done.");
    }

    public float getTotalBalance() {
        float sum = 0;
        for (Client user : this.clients) {
            for (Account acc : user.getAccounts()) {
                sum += acc.getBalance();
            }
        }
        return (float) sum;
    }

    public void storeUsers() {
        for (User user : this.clients) {
            
            try {
                String username = user.getUserName();
                System.out.println(username);
                File writename = new File("./Users/" + username + ".txt");
                writename.createNewFile();
                BufferedWriter out = new BufferedWriter(new FileWriter(writename));
                String userInfo = user.toString() + "\n";
                out.write(userInfo);
                for (Account acc : user.getAccounts()) {
                    System.out.println(acc);
                    out.write(acc.toString() + "\n");
                }
                out.flush();
                out.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public boolean checkDuplicateName(String name) {
        for (User user : clients) {
            if (user.getUserName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public User getUserByName(String name) {
        for (Client user : clients) {
            if (user.getUserName().equals(name)) {
                return user;
            }
        }
        return null;
    }
    public static void main(String[] args) {
        // UserManager um = new UserManager("./Users");
        // User u1 = new User("John", "123456");
        // User u2 = new User("Bob", "123456");
        // User u3 = new User("Tom", "123456");

        // um.addUser(u1);
        // um.addUser(u2);
        // um.addUser(u3);
        // um.printUsers();
        // um.storeUsers();
    }
}
