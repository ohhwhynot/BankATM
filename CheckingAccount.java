import java.util.ArrayList;

public class CheckingAccount extends Account {
    private float loan;
    private int day;
    private int credit;

    public CheckingAccount() {
        super();
        this.moneyList = new ArrayList<Money>();
        this.curr = new Currency();
        constructMoneyList();
        this.loan = 0;
        this.day = 0;
        this.credit = 0;
    }

    public CheckingAccount(int day, int usd, int eur, int cny, int jpy, int credit, int loan) {
        super();
        this.moneyList = new ArrayList<Money>();
        this.curr = new Currency();
        constructMoneyList();
        this.day = day;
        this.addMoney(new Money("USD", (float) usd));
        this.addMoney(new Money("EUR", (float) eur));
        this.addMoney(new Money("CNY", (float) cny));
        this.addMoney(new Money("JPY", (float) jpy));
        this.credit = credit;
        this.loan = loan;
    }

    public void loan(Money m) {
        this.loan += m.getMoneyAmount() / curr.getValue(m.getCountryCode());
        addMoney(m);
    }

    public float getLoan() {
        return this.loan;
    }

    public void setCredit(int amount) {
        this.credit = amount;
    }

    public void addCredit(int amount) {
        this.credit += amount;
    }

    public void minusCredit(int amount) {
        this.credit -= amount;
    }

    public float calculateLoan(int datediff) {
        int months = datediff / 30;
        float balance = this.getBalance();
        float interest = balance * (float) 0.02;
        interest = interest * months;
        return interest;

    }

    public String toString() {
        return String.format("CHECKING %d %.2f %.2f %.2f %.2f %d %.2f", this.day,
                this.moneyList.get(0).getMoneyAmount(), this.moneyList.get(1).getMoneyAmount(),
                this.moneyList.get(2).getMoneyAmount(), this.moneyList.get(3).getMoneyAmount(), this.credit, this.loan);
    }

    public String getAccountType() {
        return "CHECKING";
    }

    public static void main(String[] args) {
        CheckingAccount c = new CheckingAccount();
        c.loan(new Money("EUR", (float) 1000));
        c.addMoney(new Money("USD", (float) 1000));
        System.out.println(c);
    }
}
