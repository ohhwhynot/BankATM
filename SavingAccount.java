import java.util.ArrayList;

public class SavingAccount extends Account {
    private ATMDate date;

    public SavingAccount() {
        super();
        this.moneyList = new ArrayList<Money>();
        this.curr = new Currency();
        constructMoneyList();
        this.date = new ATMDate();
    }

    public SavingAccount(String CountryCode, float money) {
        super();
        this.moneyList = new ArrayList<Money>();
        this.curr = new Currency();
        constructMoneyList();
        addMoney(new Money(CountryCode, money));
        this.date = new ATMDate();
    }

    public float interestCalculation(int datediff) {
        float interest = 0;
        float balance = this.getBalance();
        if (balance >= 5000) {
            if (datediff <= 7) {
                interest = 0;
            } else if (datediff > 7 && datediff <= 30) {
                interest = balance * (float) 0.00001;
                interest = interest * (datediff / 7);
            } else if (datediff > 30 && datediff <= 180) {
                interest = balance * (float) 0.0001;
                interest = interest * (datediff / 30);
            } else if (datediff > 180 && datediff <= 330) {
                interest = balance * (float) 0.00025;
                interest = interest * (datediff / 30);
            } else if (datediff > 330) {
                interest = balance * (float) 0.0005;
                interest = interest * (datediff / 30);
            }
        }
        return interest;
    }

    @Override
    public String toString() {
        return String.format("This saving account's total balance is %.2f USD", this.getBalance());
    }

    public static void main(String[] args) {
        SavingAccount s = new SavingAccount();
        s.addMoney(new Money("USD", (float) 10000));
        s.printMoneyList();
        System.out.println(s);
        System.out.println(s.interestCalculation(390));
    }

}
