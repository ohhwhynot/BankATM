import java.util.ArrayList;

public class AccountManager {
    private ArrayList<Account> accountList;
    private AccountFactory factory;
    // new admin

    public AccountManager() {
        this.accountList = new ArrayList<Account>();
        this.factory = new AccountFactory();
        // new admin
    }

    public void addAccount(Account account) {
        this.accountList.add(account);
    }

    public void removeAccount(Account account) {
        this.accountList.remove(account);
    }

    public void createAccount(String accountType, Money m) {
        this.accountList.add(this.factory.createAccount(accountType));
        this.accountList.get(-1).addMoney(m);
        float fee = calculateFee(m);
        m.setMoney(fee);
        this.accountList.get(-1).removeMoney(m);
        // admin action
    }

    public float calculateFee(Money m) {
        float fee = m.getMoneyAmount() * (float) 0.03;
        return fee;
    }

    public void transferMoney(Account outAcc, Account inAcc, Money m) {
        float fee = calculateFee(m);
        float transfer = m.getMoneyAmount() - fee;
        m.setMoney(transfer);
        outAcc.removeMoney(m);
        inAcc.addMoney(m);
        // admin action
    }

    public void withdraw(Account account, Money m) {
        for (Account a : this.accountList) {
            if (a.equals(account)) {
                float totalCharge = calculateFee(m) + m.getMoneyAmount();
                m.setMoney(totalCharge);
                a.removeMoney(m);
                // admin action
            } else {
                System.out.println("Account not found");
            }
        }
    }
}