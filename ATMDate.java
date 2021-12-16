
/**
 * @ClassName: ATMDate
 * @Author: Xudong Gao
 * @Description: This class represents virtual time for this ATM program. 1 real seconds will be 2 ATM hour.
 * @Date: Dec 2021
 */
public class ATMDate {
    private int[] date;

    ATMDate() {
        this.date = new int[4];
    }

    ATMDate(String time) {
        String[] date = time.split(" ");
        this.date = new int[4];
        for(int i = 0;i<4;i++) {
            this.date[i] = Integer.parseInt(date[i]);
        }
    }

    public int[] getDate() {
        return date;
    }

    public void setDate(int[] date) {
        this.date = date;
    }

    public int getYear() {
        return this.date[0];
    }

    public int getMonth() {
        return this.date[1];
    }

    public int getDay() {
        return this.date[2];
    }

    public int getHour() {
        return this.date[3];
    }

    @Override
    public String toString() {
        return date[0] + "/" + date[1] + "/" + date[2] + " " + date[3] + ":00";
    }
}