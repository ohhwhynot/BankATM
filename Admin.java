class Admin extends User {

    private Account account;

    public Admin(String userName, String password) {
        super(userName, password);
        this.account = new SavingAccount();
    }

    public void addMoney(Money money) {
        account.addMoney(money);
    }

    public void removeMoney(Money money) {
        account.removeMoney(money);
    }
}