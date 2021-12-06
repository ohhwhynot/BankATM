/**
 * @ClassName: StockController
 * @Author: Xudong Gao
 * @Description:
 * @Date: Dec 2021
 */
public class StockController {
    private StockMarket market;
    public void updatePrice(String info,float price){
        Stock stock = market.getStock(info);
        if(stock!=null) {
            stock.getHistoryPrice().add(stock.getPrice());
            stock.setChangePercent((price-stock.getPrice())/stock.getPrice());
            stock.setPrice(price);
        }
    }
    public void addNewStock(String name,String code,float price){
        market.addStock(name,code,price);
    }
    public void deleteNewStock(String info){
        market.deleteStock(info);
    }

}