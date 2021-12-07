import java.io.*;
import java.util.*;

class UserManager {
    // private String filename;
    private List<User> users;

    public UserManager(String filename) {
        users = new ArrayList<User>();
        try {
            File file = new File(filename);
            InputStreamReader reader = new InputStreamReader(new FileInputStream(file));
            BufferedReader br = new BufferedReader(reader);
            String line = "";
            line = br.readLine();
            while (line != null) {
                String[] strs = line.split(" ");
                users.add(new User(strs[0], strs[1], strs[2]));
                line = br.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void printUsers() {
        for (User user : users) {
            System.out.println(user);
        }
    }

    public User createClient(String userName, String userId, String password) {
        return new Client(userName, userId, password);
    }

    // public void storeUser(User user) {
    public static void main(String[] args) throws IOException {
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
}