import java.util.Arrays;

/**
 * @ClassName: ATMDate
 * @Author: Xudong Gao
 * @Description:
 * @Date: Dec 2021
 */
public class ATMDate {
    private int[] date;

    ATMDate() {
        this.date = new int[4];
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