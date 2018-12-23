package timer;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;

import java.util.TimerTask;

/**
 * @author loodeer
 * @date 2018-12-22 21:29
 */
public class MyTimerTask extends TimerTask {

    private String name;

    private int count;


    @Override public void run() {
        if (count < 4) {
            DateTime now = new DateTime();
            String nowTime = now.toString(DateTimeFormat.forPattern("yy-MM-dd HH:mm:ss"));
            System.out.println(nowTime + " myTimerTask name is " + name);
            count ++;
        } else {
            cancel();
            System.out.println("task cancel");
        }

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
