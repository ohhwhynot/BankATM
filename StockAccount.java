import java.util.ArrayList;

public class StockAccount extends Account {
    private ArrayList<HeldStock> stocks;

    public StockAccount() {
        super();
        this.moneyList = new ArrayList<Money>();
        this.curr = new Currency();
        this.stocks = new ArrayList<HeldStock>();
        constructMoneyList();
    }

    public StockAccount(float usd, float eur, float cny, float jpy, int[] date) {
        super();
        this.moneyList = new ArrayList<Money>();
        this.curr = new Currency();
        this.stocks = new ArrayList<HeldStock>();
        constructMoneyList();
        this.addMoney(new Money("USD", (float) usd));
        this.addMoney(new Money("EUR", (float) eur));
        this.addMoney(new Money("CNY", (float) cny));
        this.addMoney(new Money("JPY", (float) jpy));
        this.date = new ATMDate();
        this.date.setDate(date);
    }

    public void buyStock(int amount, Stock stock) {
        float totalPrice = stock.getPrice() * amount;
        if (totalPrice > this.getBalance()) {
            System.out.println("Incifficient balance");
        } else {
            this.moneyList.get(0).subtractMoneyAmount(totalPrice);
            stocks.add(new HeldStock(stock, amount, stock.getPrice()));
        }
    }

    public void sellStock(int amount, Stock stock, float price) {
        float totalPrice = price * amount;
        for (HeldStock hs : stocks) {
            if (hs.getStock().getName().equals(stock.getName())) {
                hs.setAmount(hs.getAmount() - amount);
                this.moneyList.get(0).addMoneyAmount(totalPrice);
            }
        }
    }

    public boolean ifStockExist(Stock s) {
        for (HeldStock hs : stocks) {
            if (hs.getStock().getName().equals(s.getName())) {
                return true;
            }
        }
        return false;
    }

    public String getAccountType() {
        return "STOCK";
    }

    public void addHeldStock(HeldStock stock) {
        stocks.add(stock);
    }

    public String toString() {
        StringBuilder str = new StringBuilder();
        for (HeldStock hs : stocks) {
            str.append(" " + hs.getStock().getName() + "|" + hs.getAmount() + "|" + hs.getCost());
        }
        return String.format("STOCK %s %.2f %.2f %.2f %.2f %s", this.date.toString(),
                this.moneyList.get(0).getMoneyAmount(), this.moneyList.get(1).getMoneyAmount(),
                this.moneyList.get(2).getMoneyAmount(), this.moneyList.get(3).getMoneyAmount(), str.toString());
    }

}
