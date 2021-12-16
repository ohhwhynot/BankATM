import java.util.HashMap;

/**
 * @ClassName: Currency
 * @Author: Junyang Li
 * @Description:
 * @Date: Dec 2021
 */
public class Currency {
    private HashMap<String, Float> currency;

    public Currency() {
        currency = new HashMap<String, Float>();
        generateValue();
    }

    public void generateValue() {
        this.currency.put("USD", (float) 1.00);
        this.currency.put("EUR", (float) 0.88);
        this.currency.put("CNY", (float) 6.37);
        this.currency.put("JPY", (float) 113);
    }

    public HashMap<String, Float> getCurrency() {
        return this.currency;
    }

    public float getValue(String key) {
        return this.currency.get(key);
    }

    public void printCurrencies() {
        for (HashMap.Entry<String, Float> entry : this.currency.entrySet()) {
            System.out.println("The currency is " + entry.getKey()
                    + ", the convertion rate from USD to this currency is " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        Currency c = new Currency();
        System.out.print(c.getCurrency());
    }
}