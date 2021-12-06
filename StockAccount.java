import java.util.ArrayList;

public class StockAccount extends Account {
    private ArrayList<Stock> stocks;

    public StockAccount() {
        super();
        this.moneyList = new ArrayList<Money>();
        this.curr = new Currency();
        constructMoneyList();
        this.stocks = new ArrayList<Stock>();
    }

    public void addStock(Stock stock) {
        this.stocks.add(stock);
    }

    public Stock getStock(int index) {
        return this.stocks.get(index);
    }

    public void removeStock(int index) {
        this.stocks.remove(index);
    }

    public void buyStock(int amount, Stock stock) {
        convertAllToUSD();
        float totalPrice = stock.getPrice() * amount;
        if (totalPrice > this.getBalance()) {
            System.out.println("Incifficient balance");
        } else {
            this.moneyList.get(0).subtractMoneyAmount(totalPrice);
            for (int i = 0; i < amount; i++) {
                addStock(stock);
            }
        }
    }

    public void printStock() {
        for (Stock s : this.stocks) {
            System.out.println(
                    String.format("Name %s, code %s, current price %.2f", s.getName(), s.getCode(), s.getPrice()));
        }
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return null;
    }

}
