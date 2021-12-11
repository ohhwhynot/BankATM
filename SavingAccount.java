import java.util.ArrayList;

public class SavingAccount extends Account {
    private int day;

    public SavingAccount() {
        super();
        this.moneyList = new ArrayList<Money>();
        this.curr = new Currency();
        constructMoneyList();
        this.day = 0;
    }

    public SavingAccount(int day, int usd, int eur, int cny, int jpy) {
        super();
        this.moneyList = new ArrayList<Money>();
        this.curr = new Currency();
        constructMoneyList();
        this.day = day;
        this.addMoney(new Money("USD", (float) usd));
        this.addMoney(new Money("EUR", (float) eur));
        this.addMoney(new Money("CNY", (float) cny));
        this.addMoney(new Money("JPY", (float) jpy));
    }

    public float interestCalculation() {
        int datediff = this.day;
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
        return String.format("SAVING %d %.2f %.2f %.2f %.2f", this.day, this.moneyList.get(0).getMoneyAmount(),
                this.moneyList.get(1).getMoneyAmount(), this.moneyList.get(2).getMoneyAmount(),
                this.moneyList.get(3).getMoneyAmount());
    }

    public String getAccountType() {
        return "SAVING";
    }

    public static void main(String[] args) {
        SavingAccount s = new SavingAccount();
        s.addMoney(new Money("USD", (float) 10000));
        s.printMoneyList();
        System.out.println(s);
        System.out.println(s.interestCalculation());
    }

}
