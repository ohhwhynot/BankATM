import java.util.ArrayList;
import java.util.HashMap;

public abstract class Account {
    protected float balance;
    protected ArrayList<Money> moneyList;
    protected Currency curr;

    public void convertToBalance() {
        this.balance = 0;
        for (Money money : moneyList) {
            float rate = curr.getValue(money.getCountryCode());
            this.balance += money.getMoneyAmount() / rate;
        }
    }

    public void convertTo(int index, int index2) {
        Money sellM = this.moneyList.get(index);
        Money buyM = this.moneyList.get(index2);
        float sellAmount = sellM.getMoneyAmount();
        sellM.subtractMoneyAmount(sellAmount);
        float buyUSD = sellAmount / this.curr.getValue(sellM.getCountryCode());
        float buyAmount = buyUSD * this.curr.getValue(buyM.getCountryCode());
        buyM.addMoneyAmount(buyAmount);
    }

    public void convertAllToUSD() {
        for (int i = moneyList.size() - 1; i >= 0; i--) {
            convertTo(i, 0);
        }
    }

    public void constructMoneyList() {
        // HashMap<String, Float> currency = this.curr.getCurrency();
        // for (int i = 0; i < currency.size(); i++) {
        // String ccode = (String) currency.keySet().toArray()[i];
        // this.moneyList.add(new Money(ccode, (float) 0));
        // }
        this.moneyList.add(new Money("USD", (float) 0));
        this.moneyList.add(new Money("EUR", (float) 0));
        this.moneyList.add(new Money("CNY", (float) 0));
        this.moneyList.add(new Money("JPY", (float) 0));
    }

    public float getBalance() {
        convertToBalance();
        return this.balance;
    }

    public void printMoneyList() {
        System.out.println("\nYour account has: ");
        for (Money m : moneyList) {
            System.out.println(String.format("%.2f  %s", m.getMoneyAmount(), m.getCountryCode()));
        }
    }

    public void addMoney(Money money) {
        for (Money m : moneyList) {
            if (m.getCountryCode().equals(money.getCountryCode())) {
                m.addMoneyAmount(money.getMoneyAmount());
            }
        }

    }

    public void calculateFee() {

    }

    public void removeMoney(Money money) {
        for (Money m : moneyList) {
            if (m.getCountryCode().equals(money.getCountryCode())) {
                if (m.getMoneyAmount() < money.getMoneyAmount()) {
                    System.out.println("Insufficient balance");
                    break;
                }
                m.subtractMoneyAmount(money.getMoneyAmount());
            }
        }
    }

    public abstract String toString();
}
