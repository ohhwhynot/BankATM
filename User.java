import java.util.*;
/**
 * @ClassName: User
 * @Author: Juan Guang
 * @Description: This class is the parent class of Admin and Client. It contains some coexisting fields
 *                  i.e. username password and accounts
 * @Date: Dec 2021
 */
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

        String str = userName + " " + password;
        return str;
    }



}