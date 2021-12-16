/**
 * @ClassName: AccountManager
 * @Author: Junyang Li
 * @Description:
 * @Date: Dec 2021
 */
public class AccountManager {
    private AccountFactory factory;
    private Admin admin;

    public AccountManager(Admin admin) {
        this.factory = new AccountFactory();
        this.admin = admin;
    }

    public Account createAccount(String accountType) {
        Account a = this.factory.createAccount(accountType);
        Money m = new Money("USD", (float) 100);
        a.addMoney(m);
        float fee = calculateFee(m);
        m.setMoney(fee);
        a.removeMoney(m);
        Admin.getInstance().addMoney(new Money("USD", fee));
        return a;
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
        Admin.getInstance().addMoney(new Money("USD", fee));
    }

    public void withdraw(Account a, Money m) {
        float fee = calculateFee(m);
        float totalCharge = fee + m.getMoneyAmount();
        m.setMoney(totalCharge);
        a.removeMoney(m);
        Admin.getInstance().addMoney(new Money("USD", fee));
    }

    public void deposit(Account a, Money m) {
        float fee = calculateFee(m);
        float totalCharge = m.getMoneyAmount() - fee;
        m.setMoney(totalCharge);
        a.addMoney(m);
        Admin.getInstance().addMoney(new Money("USD", fee));
    }

    public void payInterest(SavingAccount a) {
        int datediff = TimeController.getDaysDifference(a.getDate(), TimeController.getCurDate());
        a.addMoney(new Money("USD", a.interestCalculation(datediff)));
        Admin.getInstance().removeMoney(new Money("USD", a.interestCalculation(datediff)));
    }

    public void applyLoan(CheckingAccount a, Money m) {
        float chargeFromAdmin = m.getMoneyAmount();
        a.loan(m);
        Admin.getInstance().removeMoney(new Money("USD", chargeFromAdmin));
    }

    public void payLoan(CheckingAccount a, Money m) {
        a.convertAllToUSD();
        float addToAdmin = m.getMoneyAmount();
        a.removeMoney(m);
        a.clearLoan();
        Admin.getInstance().addMoney(new Money("USD", addToAdmin));
    }

    public void save(Account a, Money m) {
        a.addMoney(m);
    }
}