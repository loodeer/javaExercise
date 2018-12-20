import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;

/**
 * @author loodeer
 * @date 2018-12-20 23:14
 */
public class JodaDate {
    public static void main(String[] args) {
        DateTime dateTime = new DateTime();
        // dateTime: 2018-12-20T23:20:19.058+08:00
        System.out.println("dateTime: " + dateTime);

        // to date: Thu Dec 20 23:21:12 CST 2018
        System.out.println("to date: " + dateTime.toDate());

        // to string: 2018-12-20T23:21:12.356+08:00
        System.out.println("to string: " + dateTime.toString());

        // to instant: 2018-12-20T15:22:25.086Z
        System.out.println("to instant: " + dateTime.toInstant());

        // to date time ISO: 2018-12-20T23:22:25.086+08:00
        System.out.println("to date time ISO: " + dateTime.toDateTimeISO());

        // to local date: 2018-12-20
        System.out.println("to local date: " + dateTime.toLocalDate());

        // to local time: 23:23:38.005
        System.out.println("to local time: " + dateTime.toLocalTime());

        // to local dateTime: 2018-12-20T23:23:38.005
        System.out.println("to local dateTime: " + dateTime.toLocalDateTime());

        DateTime dateTime1 = new DateTime();
        // now: 2018-12-20 23:36:40
        System.out.println("now: " + dateTime1.toString(DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss")));
    }
}
