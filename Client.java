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

    public boolean isAccountExist(String account) {
        for (Account a : this.getAccounts()) {
            if (a.getAccountType().equals(account)) {
                return true;
            }
        }
        return false;
    }

}