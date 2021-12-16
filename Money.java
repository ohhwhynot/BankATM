/**
 * @ClassName: Money
 * @Author: Junyang Li
 * @Description:
 * @Date: Dec 2021
 */
public class Money {
    private String CountryCode;
    private Float MoneyAmount;

    public Money(String CountryCode, Float MoneyAmount) {
        this.CountryCode = CountryCode;
        this.MoneyAmount = MoneyAmount;
    }

    public String toString() {
        return this.MoneyAmount + " " + this.CountryCode;
    }

    public String getCountryCode() {
        return this.CountryCode;
    }

    public Float getMoneyAmount() {
        return this.MoneyAmount;
    }

    public void addMoneyAmount(Float MoneyAmount) {
        this.MoneyAmount += MoneyAmount;
    }

    public void subtractMoneyAmount(Float MoneyAmount) {
        this.MoneyAmount -= MoneyAmount;
    }

    public void setMoney(Float MoneyAmount) {
        this.MoneyAmount = MoneyAmount;
    }

}
