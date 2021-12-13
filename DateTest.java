import java.io.IOException;

/**
 * @ClassName: Kain
 * @Author: Xudong Gao
 * @Description:
 * @Date: Dec 2021
 */
public class DateTest {
    public static void main(String[] args) throws InterruptedException, IOException {
        // UserManager um = new UserManager("./Users");
        TimeController.startTime();
        Admin a = new Admin("john", "1122", "3344");
        Client c = new Client("john", "1122", "3344", a);
        new ClientHome(c).setVisible(true);
        // new StocksMarketScreen().setVisible(true);
        // SessionHandler log = SessionHandler.getInstance();
        // log.addLog("aaaaaaaa");
        // log.addLog("bbbbbbbb");
        // log.writeLogs();
        // TimeController.startTime();
        // while (true) {
        // Thread.sleep(1000);
        // System.out.println( TimeController.getCurDate());
        // }
    }
}