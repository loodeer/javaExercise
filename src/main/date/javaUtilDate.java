import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author loodeer
 * @date 2018-12-20 22:53
 */
public class javaUtilDate {

    public static void main(String[] args) {
        Date date = new Date();
        // new Date: Thu Dec 20 22:56:15 CST 2018
        System.out.println("new Date: " + date);
        // Date to string: Thu Dec 20 22:57:19 CST 2018
        System.out.println("Date to string: " + date.toString());

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        // simpleDateFormat: 2018-12-20 22:59:54
        System.out.println("simpleDateFormat: " + dateFormat.format(date));
    }



}
