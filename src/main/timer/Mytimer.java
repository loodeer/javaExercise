package timer;

import org.joda.time.DateTime;

import java.util.Timer;

/**
 * @author loodeer
 * @date 2018-12-22 21:31
 */
public class Mytimer {
    public static void main(String[] args) {
        MyTimerTask myTimerTask = new MyTimerTask();
        myTimerTask.setName("loodeer's task");

        Timer timer = new Timer();

        // 5秒后，仅执行一次
        //DateTime dateTime = new DateTime();
        //System.out.println("schedule 的第一种用法，X秒后执行一次");
        //timer.schedule(myTimerTask, 5000L);

        //        System.out.println("schedule 的第二种用法，指定时间点执行一次，若指定时间是过去时间，会立马执行一次");
        //        timer.schedule(myTimerTask, dateTime.minusSeconds(2).toDate());
        //        System.out.println("---");
        //        timer.schedule(myTimerTask, dateTime.plusSeconds(5).toDate());

        System.out.println("schedule 的第三种用法，延时X毫秒执行一次，然后每隔Y毫秒执行一次");
        timer.schedule(myTimerTask, 2000L, 1000L);

        //        System.out.println("schedule 的第四种用法，指定时间点执行一次，然后每隔Y毫秒执行一次");
        //        timer.schedule(myTimerTask, dateTime.plusSeconds(5).toDate(), 1000L);

    }
}
