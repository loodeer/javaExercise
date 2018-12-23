import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

/**
 * @author loodeer
 * @date 2018-12-24 02:15
 */
public class HelloCronScheduler {
    public static void main(String[] args) throws SchedulerException {
        DateTime now = new DateTime();
        DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");

        JobDetail jobDetail = JobBuilder.newJob(HelloJob2.class)
                .withIdentity("my cron job", "cron group").build();

        Trigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("my trigger", "cron group")
                // 秒 分 时 日 月 周 年
                .withSchedule(CronScheduleBuilder.cronSchedule("* * * * * ? *"))
                .build();

        Scheduler scheduler = new StdSchedulerFactory().getScheduler();
        scheduler.scheduleJob(jobDetail, trigger);
        scheduler.start();
        System.out.println("current time is: " + now.toString(dateTimeFormatter));
    }
}
