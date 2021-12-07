import java.util.*;

class User {
    protected String userName;
    protected String userId;
    protected String password;
    protected List<Account> accounts;

    public User(String userName, String userId, String password) {
        this.userName = userName;
        this.userId = userId;
        this.password = password;
        this.accounts = new ArrayList<Account>();
    }

    public boolean setPassword(String password) {
        if (password.contains(" ")) {
            return false;
        }
        this.password = password;
        return true;
    }

    public boolean matchPassword(String password) {
        return password.equalsIgnoreCase(this.password);
    }

    public String toString() {
        // version 1
        // String str = "Username: " + userName + "\nUser id: " + userId + "\nAccounts:
        // ";
        // for(Account acc : this.accounts) {
        // str = str + "\n" + acc.toString();
        // }

        // version 2
        String str = userName + " " + userId + " " + password;
        return str;
    }

    public static void main(String[] args) {
        User u1 = new User("John", "1", "123456");
        User u2 = new User("Bob", "2", "123456");
        User u3 = new User("Tom", "3", "123456");

        System.out.println(u1);
        System.out.println(u2);
        System.out.println(u3);
    }

}