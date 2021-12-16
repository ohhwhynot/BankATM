/**
 * @ClassName: AccountFactory
 * @Author: Junyang Li
 * @Description:
 * @Date: Dec 2021
 */
public class AccountFactory {
    public Account createAccount(String accountType) {
        if (accountType == null) {
            return null;
        }
        if (accountType.equalsIgnoreCase("CHECKING")) {
            return new CheckingAccount();
        } else if (accountType.equalsIgnoreCase("SAVING")) {
            return new SavingAccount();
        } else if (accountType.equalsIgnoreCase("STOCK")) {
            return new StockAccount();
        }
        return null;
    }
}
