import java.io.*;
import java.util.*;

class UserManager {
    // private String filename;
    private List<User> users;

    public UserManager(String dirname) {
        users = new ArrayList<User>();
        File dir = new File(dirname);
        String[] userfiles = dir.list();
        if (userfiles == null) {
            System.err.println("not a dir!");
        }
        else {
            for (int i=0; i< userfiles.length; i++) {
                String filename = userfiles[i];
                System.out.println(filename);
                users.add(loadUser(dirname+"/"+filename));
            }
        }
    }

    public User loadUser(String filename) {
        User user = new User();
        try {
            File file = new File(filename);
            InputStreamReader reader = new InputStreamReader(new FileInputStream(file));
            BufferedReader br = new BufferedReader(reader);
            String line = "";
            line = br.readLine();
            if (line != null) {
                String[] strs = line.split(" ");
                user = new User(strs[0], strs[1], strs[2]);
                line = br.readLine();
                while (line != null) {
                    strs = line.split(" ");
                    if (strs[0].equalsIgnoreCase("#CHECKING")) {
                        int day = Integer.parseInt(strs[1]);
                        int usd = Integer.parseInt(strs[2]);
                        int eur = Integer.parseInt(strs[3]);
                        int cny = Integer.parseInt(strs[4]);
                        int jpy = Integer.parseInt(strs[5]);
                        int loan = Integer.parseInt(strs[6]);
                        int[] date = new int[strs.length - 7];
                        for(int i = 0; i < date.length; i++) {
                            date[i] = Integer.parseInt(strs[i + 7]);
                        }
                        CheckingAccount acc = new CheckingAccount(day, usd, eur, cny, jpy, loan, date);
                        user.addAccount(acc);
                    } else if (strs[0].equalsIgnoreCase("#SAVING")) {
                        int usd = Integer.parseInt(strs[1]);
                        int eur = Integer.parseInt(strs[2]);
                        int cny = Integer.parseInt(strs[3]);
                        int jpy = Integer.parseInt(strs[4]);
                        int[] date = new int[strs.length - 5];
                        for(int i = 0; i < date.length; i++) {
                            date[i] = Integer.parseInt(strs[i + 5]);
                        }
                        SavingAccount acc = new SavingAccount(usd, eur, cny, jpy, date);
                        user.addAccount(acc);
                    } else if (strs[0].equalsIgnoreCase("#STOCK")) {
                        int usd = Integer.parseInt(strs[1]);
                        int eur = Integer.parseInt(strs[2]);
                        int cny = Integer.parseInt(strs[3]);
                        int jpy = Integer.parseInt(strs[4]);
                        int[] date = new int[strs.length - 5];
                        for(int i = 0; i < date.length; i++) {
                            date[i] = Integer.parseInt(strs[i + 5]);
                        }
                        StockAccount acc = new StockAccount(usd, eur, cny, jpy, date);
                        user.addAccount(acc);
                    } else {
                        //
                    }
                    line = br.readLine();
                }
            }
            
            return user;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void addUser(User user) {
        this.users.add(user);
    }

    public void printUsers() {
        for (User user : users) {
            System.out.println(user);
            for(Account acc : user.getAccounts()) {
                System.out.println(acc);
            }
        }
    }

    // public User createClient(String userName, String userId, String password) {
    //     return new Client(userName, userId, password);
    // }

    public void storeUsers() {
        // String userInfo = user.toString() + "\r\n";
        User u1 = new User("John", "1", "123456");
        String userInfo = u1.toString() + "\r\n";

        try {
            File writename = new File("Users.txt");
            writename.createNewFile();
            BufferedWriter out = new BufferedWriter(new FileWriter(writename));
            out.write(userInfo);
            out.flush();
            out.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        UserManager um = new UserManager("./Users");
        um.printUsers();
    }
}
