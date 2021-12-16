import java.util.ArrayList;

/**
 * @ClassName: SavingAccount
 * @Author: Junyang Li
 * @Description:
 * @Date: Dec 2021
 */
public class SavingAccount extends Account {

    private boolean updateTrigger;

    public SavingAccount() {
        super();
        this.moneyList = new ArrayList<Money>();
        this.curr = new Currency();
        constructMoneyList();
        this.updateTrigger = false;
        this.date = TimeController.getCurDate();
    }

    public SavingAccount(float usd, float eur, float cny, float jpy, int[] date) {
        super();
        this.moneyList = new ArrayList<Money>();
        this.curr = new Currency();
        constructMoneyList();
        this.addMoney(new Money("USD", (float) usd));
        this.addMoney(new Money("EUR", (float) eur));
        this.addMoney(new Money("CNY", (float) cny));
        this.addMoney(new Money("JPY", (float) jpy));
        if (this.getBalance() >= 5000) {
            this.updateTrigger = true;
        }
        this.date = new ATMDate();
        this.date.setDate(date);
    }

    public float interestCalculation(int datediff) {
        float interest = 0;
        float balance = this.getBalance();
        if (balance >= 5000) {
            updateTime();
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
        } else {
            interest = 0;
        }
        return interest;
    }

    public void updateTime() {
        if (this.updateTrigger == false) {
            this.date = TimeController.getCurDate();
            this.updateTrigger = true;
        }
    }

    @Override
    public String toString() {
        return String.format("SAVING %s %.2f %.2f %.2f %.2f", this.date.toString(),
                this.moneyList.get(0).getMoneyAmount(), this.moneyList.get(1).getMoneyAmount(),
                this.moneyList.get(2).getMoneyAmount(), this.moneyList.get(3).getMoneyAmount());
    }

    public String getAccountType() {
        return "SAVING";
    }

    public static void main(String[] args) {
        SavingAccount s = new SavingAccount();
        s.addMoney(new Money("USD", (float) 10000));
        s.printMoneyList();
        System.out.println(s);
        System.out.println(s.interestCalculation(1000));
    }

}
