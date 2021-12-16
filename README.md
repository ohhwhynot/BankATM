###BankATM

Compile and run commands:\
javac Main.java\
java Main
**************************************
Class Description:\
Main:This is a main function for the program.\Cancel changes
UserManager: This class manage all the users and contains functions of loading and storing all the users\
User: This class is the parent class of Admin and Client. It contains some coexisting fields         i.e. username password and accounts\
Admin: This class represent the Admin of our ATM and it has an account which all the fee he/she charged will be put into and loan to the client will be taken out from\
Client: This class represents a client. A Client have a list of accounts(checking, saving and stock)\
\
ATMDate: This class represents virtual time for this ATM program. 1 real seconds will be 2 ATM hour.\
TimeController: This class can control ATM time, which is used in logs and computing interests.\
StocksView: This class can transform the stock data to tables.\
StockMarket: This class represents a stock market which provides methods to operate stock.\
StockController: This class provides methods for the bank admin to operate stocks.\
Stock: This class represents a stock in this program.\
SessionHandler: This class can handle the logs produced by users.\
BackupController:This class provides  functions to load and store data.\
Screens:\
ATMHome: This is a home screen for all users to sign up and log in.\
ClientHome: This is a home screen for a client. A client can choose their action.\
AdminScreen: This is a home screen for the admin. The admin can choose his action like updating stocks.\
AccountInfoScreen,addStockScreen,DepositWithdrawScreen,ExchangeScreen, LogScreen, SignUpScreen,StocksMarketScreen,TimeScreen,\
TradeStockScreen,TransferScreen 

Account: This is an abstract class for all three types of accounts, it has basic getters and setters, and common method for all three class like convertion.\
SavingAccount: Extension of account class, have the ability to calculate interest.\
CheckingAccount: Extension of account class, can rent a loan if balance is over 500.\
StockAccount: Extension of account class, on top of having money, it also have a list of stocks owned by the user, and the ability to trade them.\
AccountManager: This class uses factory pattern to create accounts, it also acts as a interface to interact with the account, performing actions like withdraw,\
 deposit, transfer between accounts and apply for loan.\
AccountFactory: The factory class for accounts, take a string and return a new account.\
Currency: Represent real world currency with convertion value.\
Money: Represent real world dollar bill with country code and face value.
