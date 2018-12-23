import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * @author loodeer
 * @date 2018-12-24 02:21
 */
public class HelloJob2 implements Job {
    @Override public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        DateTime now = new DateTime();
        DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");
        System.out.println("current exec time is: " + now.toString(dateTimeFormatter));
    }
}
