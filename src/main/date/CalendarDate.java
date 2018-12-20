import java.util.Calendar;

/**
 * @author loodeer
 * @date 2018-12-20 23:01
 */
public class CalendarDate {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        // Calendar: java.util.GregorianCalendar[time=1545318538596,areFieldsSet=true,areAllFieldsSet=true,lenient=true,zone=sun.util.calendar.ZoneInfo[id="Asia/Shanghai",offset=28800000,dstSavings=0,useDaylight=false,transitions=19,lastRule=null],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=1,YEAR=2018,MONTH=11,WEEK_OF_YEAR=51,WEEK_OF_MONTH=4,DAY_OF_MONTH=20,DAY_OF_YEAR=354,DAY_OF_WEEK=5,DAY_OF_WEEK_IN_MONTH=3,AM_PM=1,HOUR=11,HOUR_OF_DAY=23,MINUTE=8,SECOND=58,MILLISECOND=596,ZONE_OFFSET=28800000,DST_OFFSET=0]
        System.out.println("Calendar: " + calendar);

        calendar.set(2019,Calendar.JANUARY,1);
        System.out.println("Calendar: " + calendar);

        // 2019年0月1日 …… 额
        System.out.println(calendar.get(Calendar.YEAR) + "年" + calendar.get(Calendar.MONTH) + "月" + calendar.get(Calendar.DATE) + "日");
    }
}
