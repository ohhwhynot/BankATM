
/**
 * @ClassName: HeldStock
 * @Author: Junyang Li
 * @Description:
 * @Date: Dec 2021
 */
public class HeldStock {

    private Stock stock;
    private int amount;
    private float cost;

    public HeldStock(Stock stock, int amount, float cost) {
        this.stock = stock;
        this.amount = amount;
        this.cost = cost;
    }

    public Stock getStock() {
        return this.stock;
    }

    public int getAmount() {
        return this.amount;
    }

    public int setAmount(int amount) {
        return this.amount = amount;
    }

    public float getCost() {
        return this.cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public float getTotalCost() {
        return this.cost * this.amount;
    }

}
