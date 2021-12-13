import java.util.ArrayList;

public class CheckingAccount extends Account {
    private float loan;

    public CheckingAccount() {
        super();
        this.moneyList = new ArrayList<Money>();
        this.curr = new Currency();
        constructMoneyList();
        this.loan = 0;
    }

    public CheckingAccount(int day, float usd, float eur, float cny, float jpy, float loan, int[] date) {
        super();
        this.moneyList = new ArrayList<Money>();
        this.curr = new Currency();
        constructMoneyList();
        this.date = new ATMDate();
        this.date.setDate(date);
        this.addMoney(new Money("USD", (float) usd));
        this.addMoney(new Money("EUR", (float) eur));
        this.addMoney(new Money("CNY", (float) cny));
        this.addMoney(new Money("JPY", (float) jpy));
        this.loan = loan;
    }

    public void loan(Money m) {
        this.loan = m.getMoneyAmount();
        addMoney(m);
    }

    public float getLoan() {
        return this.loan;
    }

    public void clearLoan() {
        this.loan = 0;
    }

    public void calculateLoan(int datediff) {
        int months = datediff / 30;
        float interest = loan * (float) 0.02;
        interest = interest * months;
        this.loan += interest;
    }

    public float calculateMaxLoan() {
        return getBalance() * 2;
    }

    public String toString() {
        return String.format("CHECKING %s %.2f %.2f %.2f %.2f %.2f", this.date.toString(),
                this.moneyList.get(0).getMoneyAmount(), this.moneyList.get(1).getMoneyAmount(),
                this.moneyList.get(2).getMoneyAmount(), this.moneyList.get(3).getMoneyAmount(), this.loan);
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
