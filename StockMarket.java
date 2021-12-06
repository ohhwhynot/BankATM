import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: StockMarket
 * @Author: Xudong Gao
 * @Description:
 * @Date: Dec 2021
 */
public class StockMarket {


    private List<Stock> stocks;
    public StockMarket(){
        stocks = new ArrayList<>();
    }
    public List<Stock> getStocks() {
        return stocks;
    }

    public void setStocks(List<Stock> stocks) {
        this.stocks = stocks;
    }
    public Stock getStock(String info){
        boolean isFound = false;
        for(Stock stock:stocks){
            if(stock.getCode().equals(info)||stock.getName().equals(info)){
                isFound = true;
                return stock;
            }
        }
        if(isFound==false) {
            //todo notfound
            return null;
        }
        return null;
    }
    public void addStock(String name,String code,float price){
        stocks.add(new Stock(name,code,price));
    }
    public void deleteStock(String info){
        for(Stock stock:stocks){
            if(stock.getCode().equals(info)||stock.getName().equals(info)){
                stocks.remove(stock);
            }
        }
    }
}