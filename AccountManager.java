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
        // admin action
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
        // admin action
    }

    public void withdraw(Account a, Money m) {
        float fee = calculateFee(m);
        float totalCharge = fee + m.getMoneyAmount();
        m.setMoney(totalCharge);
        a.removeMoney(m);
        // admin action
    }

    public void deposit(Account a, Money m) {
        float fee = calculateFee(m);
        float totalCharge = m.getMoneyAmount() - fee;
        m.setMoney(totalCharge);
        a.addMoney(m);
    }

    public void payInterest(SavingAccount a) {
        int datediff = TimeController.getDaysDifference(a.getDate(), TimeController.getCurDate());
        a.addMoney(new Money("USD", a.interestCalculation(datediff)));
        // admin action
    }

    public void applyLoan(CheckingAccount a, Money m) {
        float chargeFromAdmin = m.getMoneyAmount();
        a.loan(m);
        // admin action
    }

    public void payLoan(CheckingAccount a, Money m) {
        float addToAdmin = m.getMoneyAmount();
        a.removeMoney(m);
        a.clearLoan();
        // admin action
    }

    public void save(Account a, Money m) {
        a.addMoney(m);
    }
}