Name: Xudong Gao
email: Xdgao@bu.edu
BU ID: U39508249

Name: Junyang Li
email: jl981215@bu.edu
BU ID: U53650416

Name: Juan Guang
email: jguang@bu.edu
BU ID: U87172366
**************************************
Compile and run commands:
> javac Main.java
> java Main
**************************************
Class Description:
Main:This is a main function for the program.
UserManager: This class manage all the users and contains functions of loading and storing all the users
User: This class is the parent class of Admin and Client. It contains some coexisting fields         i.e. username password and accounts
Admin: This class represent the Admin of our ATM and it has an account which all the fee he/she charged will be put into and loan to the client will be taken out from
Client: This class represents a client. A Client have a list of accounts(checking, saving and stock)

ATMDate: This class represents virtual time for this ATM program. 1 real seconds will be 2 ATM hour.
TimeController: This class can control ATM time, which is used in logs and computing interests.
StocksView: This class can transform the stock data to tables.
StockMarket: This class represents a stock market which provides methods to operate stock.
StockController: This class provides methods for the bank admin to operate stocks.
Stock: This class represents a stock in this program.
SessionHandler: This class can handle the logs produced by users.
BackupController:This class provides  functions to load and store data.
Screens:
ATMHome: This is a home screen for all users to sign up and log in.
ClientHome: This is a home screen for a client. A client can choose their action.
AdminScreen: This is a home screen for the admin. The admin can choose his action like updating stocks.
AccountInfoScreen,addStockScreen,DepositWithdrawScreen,ExchangeScreen, LogScreen, SignUpScreen,StocksMarketScreen,TimeScreen,
TradeStockScreen,TransferScreen 