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
        this.um = new UserManager("./Users");
        this.stockController = new StockController();
    }

    public static Admin getInstance() {
        return instance;
    }

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