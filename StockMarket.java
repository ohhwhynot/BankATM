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


    private int code;
    public StockMarket(){
        stocks = new ArrayList<>();
    }
    public StockMarket(List<String> list){
        code = Integer.parseInt(list.remove(0));
        stocks = new ArrayList<>();
        for (String i:list){
            String[] args = i.split(" ");
            stocks.add(new Stock(args[0],args[1],Float.parseFloat(args[2]),Float.parseFloat(args[3]),
                            Boolean.parseBoolean(args[4])));
        }
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
        return null;
    }
    public Stock getStock(int index){
        return stocks.get(index);
    }
    public int getCode() {
        return code;
    }

    public boolean isExisted(String name){
        for (Stock stock:stocks){
            if (stock.getName().equals(name)){
                return true;
            }
        }
        return false;
    }
    public void setCode(int code) {
        this.code = code;
    }
    public void addStock(String name,String code,float price){
        stocks.add(new Stock(name,code,price,0,false));
    }
    public void deleteStock(int index){
        stocks.remove(index);

    }
}