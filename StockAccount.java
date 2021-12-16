import java.util.ArrayList;

public class StockAccount extends Account {
    private ArrayList<HeldStock> stocks;



    private float realizedProfit = 0;

    public StockAccount() {
        super();
        this.moneyList = new ArrayList<Money>();
        this.curr = new Currency();
        this.stocks = new ArrayList<HeldStock>();
        constructMoneyList();
        this.date = TimeController.getCurDate();
    }

    public StockAccount(float usd, float eur, float cny, float jpy, int[] date,float realizedProfit) {
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
        this.realizedProfit = realizedProfit;
    }
    public float getRealizedProfit() {
        return realizedProfit;
    }

    public void setRealizedProfit(float unrealizedProfit) {
        this.realizedProfit = unrealizedProfit;
    }
    public boolean buyStock(int amount, Stock stock) {
        float totalPrice = (stock.getPrice()+2) * amount;
        if (totalPrice <= this.getBalance()) {
            if (ifStockExist(stock) == false) {
                this.moneyList.get(0).subtractMoneyAmount(totalPrice);
                stocks.add(new HeldStock(stock, amount, stock.getPrice()));
                return true;
            } else {
                for (HeldStock hs : stocks) {
                    if (hs.getStock().getName().equals(stock.getName())) {
                        this.moneyList.get(0).subtractMoneyAmount(totalPrice);
                        Admin.getInstance().addMoney(new Money("USD", (float) (2*amount)));
                        hs.setCost((hs.getCost() * hs.getAmount() + stock.getPrice() * amount)
                                / (amount + hs.getAmount()));
                        hs.setAmount(hs.getAmount() + amount);
                        return true;
                    }
                }
            }
            stock.setBought(true);
        } else {
            System.out.println("Insufficient balance");
            return false;
        }
        return false;
    }

    public void sellStock(int amount, Stock stock, float price) {
        int fee =1;
        float totalPrice = price * amount;
        for (HeldStock hs : stocks) {
            if (hs.getStock().getName().equals(stock.getName())) {
                hs.setAmount(hs.getAmount() - amount);
                this.moneyList.get(0).addMoneyAmount(totalPrice-amount*fee);
                this.setRealizedProfit(this.getRealizedProfit()+ (totalPrice-(fee+hs.getCost())*amount));
                Admin.getInstance().addMoney(new Money("USD", (float) (fee*amount)));
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

    public ArrayList<HeldStock> getStocks() {
        return stocks;
    }

    public String getAccountType() {
        return "STOCK";
    }

    public void addHeldStock(HeldStock stock) {
        stocks.add(stock);
    }

    public HeldStock getHeldStock(int index) {
        return stocks.get(index);
    }

    public String toString() {
        StringBuilder str = new StringBuilder();
        for (HeldStock hs : stocks) {
            str.append(" " + hs.getStock().getName() + "|" + hs.getAmount() + "|" + hs.getCost());
        }
        return String.format("STOCK %s %.2f %.2f %.2f %.2f %.2f %s", this.date.toString(),
                this.moneyList.get(0).getMoneyAmount(), this.moneyList.get(1).getMoneyAmount(),
                this.moneyList.get(2).getMoneyAmount(), this.moneyList.get(3).getMoneyAmount(),
                this.realizedProfit, str.toString());
    }

}
