import java.util.*;

class User {
    protected String userName;
    protected String password;
    protected ArrayList<Account> accounts;

    public User() {
        this.accounts = new ArrayList<Account>();
    }

    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
        this.accounts = new ArrayList<Account>();
    }

    public String getUserName() {
        return this.userName;
    }

    public String getPassword() {
        return this.password;
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

    public ArrayList<Account> getAccounts() {
        return this.accounts;
    }

    public void addAccount(Account account) {
        this.accounts.add(account);
    }

    public void removeAccount(Account account) {
        this.accounts.remove(account);
    }

    public String toString() {
        // version 1
        // String str = "Username: " + userName + "\nUser id: " + userId + "\nAccounts:
        // ";
        // for(Account acc : this.accounts) {
        // str = str + "\n" + acc.toString();
        // }

        // version 2
        String str = userName + " " + password;
        return str;
    }

    public static void main(String[] args) {
        User u1 = new User("John", "123456");
        User u2 = new User("Bob", "123456");
        User u3 = new User("Tom", "123456");

        System.out.println(u1);
        System.out.println(u2);
        System.out.println(u3);
    }

}