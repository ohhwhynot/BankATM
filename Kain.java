/**
 * @ClassName: Kain
 * @Author: Xudong Gao
 * @Description:
 * @Date: Dec 2021
 */
public class Kain {
    public static void main(String[] args) {
        TimeController.startTime();
        while (true) {
            System.out.println(TimeController.getCurDate());
        }
    }
}