class Client extends User {
    private AccountManager m;

    public Client(String userName, String userId, String password, Admin a) {
        super(userName, userId, password);
        m = new AccountManager(a);
    }

    public void createAccount(String account) {
        if (isAccountExist(account) == false) {
            Account a = m.createAccount(account);
            addAccount(a);
        }
    }

    public void closeAccount(String account) {
        if (isAccountExist(account) == true) {
            if (account.equals("SAVING")) {
                removeAccount(getSavingAccount());
            } else if (account.equals("CHECKING")) {
                removeAccount(getCheckingAccount());
            } else if (account.equals("STOCK")) {
                removeAccount(getStockAccount());
            }
        }
    }

    public boolean isAccountExist(String account) {
        for (Account a : this.getAccounts()) {
            if (a.getAccountType().equals(account)) {
                return true;
            }
        }
        return false;
    }

    public SavingAccount getSavingAccount() {
        for (Account a : this.getAccounts()) {
            if (a.getAccountType().equals("SAVING")) {
                return (SavingAccount) a;
            }
        }
        return null;
    }

    public CheckingAccount getCheckingAccount() {
        for (Account a : this.getAccounts()) {
            if (a.getAccountType().equals("CHECKING")) {
                return (CheckingAccount) a;
            }
        }
        return null;
    }

    public StockAccount getStockAccount() {
        for (Account a : this.getAccounts()) {
            if (a.getAccountType().equals("STOCK")) {
                return (StockAccount) a;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Admin a = new Admin("admin", "1111", "2222");
        Client c = new Client("John", "1122", "3344", a);
        c.createAccount("SAVING");
        System.out.println(c.getSavingAccount());
        System.out.println(c.isAccountExist("STOCK"));
    }
}