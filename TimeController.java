
/**
 * @ClassName: TimeController
 * @Author: Xudong Gao
 * @Description:
 * @Date: Dec 2021
 */
public class TimeController {
    private static ATMDate startDate;
    private static long startRealTime;
    private static ATMDate curDate;
    public static void startTime(){
        startRealTime = System.currentTimeMillis();
        startDate.setDate(new int[]{0, 0, 0, 0});
    }

    public static ATMDate getCurDate(){
        long curRealTime = System.currentTimeMillis();
        long timeD = curRealTime - startRealTime;
        double hourD = (double) (timeD/1000) * 2;
        int dayD = (int)hourD/24;
        int monthD = dayD/30;
        int yearD = monthD/12;
        int[] dateTemp = {yearD,monthD%12,dayD%30,(int)hourD%24};
        curDate.setDate(dateTemp);
        return curDate;
    }

    public static int getDaysDifference(ATMDate past,ATMDate now){
        int yearD = now.getYear()-past.getYear();
        int monthD = now.getMonth() - past.getMonth();
        int dayD = now.getDay() - past.getDay();
        int allDayD = yearD*360 + monthD * 30 + dayD;
        return allDayD;
    }
}

