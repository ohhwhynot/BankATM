
/**
 * @ClassName: TimeController
 * @Author: Xudong Gao
 * @Description:
 * @Date: Dec 2021
 */
public class TimeController {
    private static ATMDate startDate =new ATMDate();
    private static long startRealTime;
    private static ATMDate curDate = new ATMDate();
    public static void startTime(){
        startRealTime = System.currentTimeMillis();
        startDate.setDate(new int[]{2020, 1, 1, 0});
    }
    public static void setStartTime(ATMDate start){
        startRealTime = System.currentTimeMillis();
        startDate = start;
    }
    public static ATMDate getCurDate(){
        long curRealTime = System.currentTimeMillis();
        long timeD = curRealTime - startRealTime;
        double hourD = (double) (timeD/1000) * 2;
        int dayD = (int)hourD/24;
        int monthD = dayD/30;
        int yearD = monthD/12;
        int[] dateTemp = {yearD+startDate.getYear(),monthD%12+startDate.getMonth(),dayD%30+startDate.getDay(),
                (int)hourD%24+startDate.getHour()};
        curDate.setDate(dateTemp);
        ATMDate cur = curDate;
        return cur;
    }


    public static int getDaysDifference(ATMDate past,ATMDate now){
        int yearD = now.getYear()-past.getYear();
        int monthD = now.getMonth() - past.getMonth();
        int dayD = now.getDay() - past.getDay();
        int allDayD = yearD*360 + monthD * 30 + dayD;
        return allDayD;
    }
}

