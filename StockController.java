import java.util.List;

/**
 * @ClassName: StockController
 * @Author: Xudong Gao
 * @Description: This class provides methods for the bank admin to operate stocks.
 * @Date: Dec 2021
 */
public class StockController {
    private StockMarket market;
    private StocksView view;
    StockController(StocksView view,StockMarket stockMarket){
        this.view = view;
        market = stockMarket;
    }
    public void updatePrice(int index,float price){
        Stock stock = market.getStock(index);
        if(stock!=null) {
            stock.getHistoryPrice().add(stock.getPrice());
            stock.setChangePercent((price-stock.getPrice())/stock.getPrice());
            System.out.println(stock.getChangePercent());
            stock.setPrice(price);
        }
    }
    public void addNewStock(String name,float price){
        market.setCode(market.getCode()+1);
        String code = "0000"+market.getCode();
        market.addStock(name,code,price);
    }
    public boolean isExisted(String name){
        return market.isExisted(name);
    }
    public StocksView getView(){return view;}
    public Stock getStock(int index){return market.getStock(index);}
    public Stock getStock(String name){return market.getStock(name);}
    public void deleteStock(int index){
        market.deleteStock(index);
    }
    public List<Stock> getStocks(){
        return market.getStocks();
    }
    public StockMarket getMarket(){return market;}
}