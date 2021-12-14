class Admin extends User {

    private Admin() {

    }

    private UserManager um;
    private Account account;
    private StockController stockController;
    
    private static Admin instance = new Admin("adm", "12345");

    private Admin(String userName, String password) {
        super(userName, password);
        this.account = new SavingAccount();

        
        StockMarket market = BackupController.getInstance().loadUpStockMarket();
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