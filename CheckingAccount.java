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

    public CheckingAccount(String CountryCode, float money) {
        super();
        this.moneyList = new ArrayList<Money>();
        this.curr = new Currency();
        constructMoneyList();
        addMoney(new Money(CountryCode, money));
        this.loan = 0;
    }

    public void loan(Money m) {
        this.loan += m.getMoneyAmount() / curr.getValue(m.getCountryCode());
        addMoney(m);
    }

    public float getLoan() {
        return this.loan;
    }

    public float calculateLoan(int datediff) {
        int months = datediff / 30;
        float balance = this.getBalance();
        float interest = balance * (float) 0.02;
        interest = interest * months;
        return interest;

    }

    public String toString() {
        return String.format("This checking account's total balance is %.2f USD", (this.getBalance()));
    }

    public static void main(String[] args) {
        CheckingAccount c = new CheckingAccount();
        c.loan(new Money("EUR", (float) 1000));
        c.printMoneyList();
        System.out.println(c.getLoan() + " " + c.calculateLoan(180));
    }
}
