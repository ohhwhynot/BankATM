import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: Stock
 * @Author: Xudong Gao
 * @Description:
 * @Date: Dec 2021
 */
public class Stock {
    private String name;
    private String code;
    private List<Float> historyPrice;
    private float price;
    private float changePercent;
    private boolean isBought;

    Stock(String name, String code, float price,float changePercent,boolean isBought) {
        this.name = name;
        this.code = code;
        this.price = price;
        this.changePercent = changePercent;
        this.isBought = isBought;
        historyPrice = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<Float> getHistoryPrice() {
        return historyPrice;
    }

    public void setHistoryPrice(List<Float> historyPrice) {
        this.historyPrice = historyPrice;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getChangePercent() {

        return changePercent;
    }
    public boolean isBought(){
        return isBought;
    }
    public void setBought(boolean b){
        isBought=b;
    }

    public void setChangePercent(float changePercent) {
        this.changePercent = changePercent;
    }

}