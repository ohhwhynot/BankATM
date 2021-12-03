/**
 * @ClassName: Kain
 * @Author: Xudong Gao
 * @Description:
 * @Date: Dec 2021
 */
public class DateTest {
    public static void main(String[] args) throws InterruptedException {
        TimeController.startTime();
        while (true) {
            Thread.sleep(1000);
            System.out.println( TimeController.getCurDate());
        }
    }
}