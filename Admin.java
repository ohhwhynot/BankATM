/**
 * @ClassName: Admin
 * @Author: Juan Guang
 * @Description: This class represent the Admin of our ATM and it has an account 
 *              which all the fee he/she charged will be put into and 
 *              loan to the client will be taken out from
 * @Date: Dec 2021
 */
class Admin extends User {

    private UserManager um;
    private Account account;
    private StockController stockController;
    
    private static Admin instance = new Admin("adm", "12345");

    private Admin(String userName, String password) {
        super(userName, password);
        this.account = new SavingAccount();
        SessionHandler.getInstance().loadLogs();
        
        StockMarket market = BackupController.getInstance().loadUpStockMarket();
        TimeController.setStartTime(BackupController.getInstance().loadTime());
        this.stockController = new StockController(new StocksView(),market);

        this.um = new UserManager("./Users");
    }


    public static Admin getInstance() {
        return instance;
    }

    public StockController getStockController(){return  stockController;};



    public void addMoney(Money money) {
        account.addMoney(money);
    }

    public void removeMoney(Money money) {
        account.removeMoney(money);
    }

    public UserManager getUserManager() {
        return this.um;
    }
}