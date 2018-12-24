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
    public static void main(String[] args) throws SchedulerException, InterruptedException {
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

        Thread.sleep(3000L);
        // scheduler 挂起
        scheduler.standby();

        Thread.sleep(5000L);
        // scheduler 重新启动, standby 之后少执行的,会追加执行,如下
        scheduler.start();
        /*
        current time is: 2018-12-24 12:43:38
        current exec time is: 2018-12-24 12:43:38
        current exec time is: 2018-12-24 12:43:39
        current exec time is: 2018-12-24 12:43:40
        current exec time is: 2018-12-24 12:43:41
        current exec time is: 2018-12-24 12:43:46
        current exec time is: 2018-12-24 12:43:46
        current exec time is: 2018-12-24 12:43:46
        current exec time is: 2018-12-24 12:43:46
        current exec time is: 2018-12-24 12:43:46
        current exec time is: 2018-12-24 12:43:47
        current exec time is: 2018-12-24 12:43:48
        current exec time is: 2018-12-24 12:43:49
        current exec time is: 2018-12-24 12:43:50
        current exec time is: 2018-12-24 12:43:51
        current exec time is: 2018-12-24 12:43:52
        current exec time is: 2018-12-24 12:43:53
         */

        // 等待任务执行完成之后，再关闭 scheduler
        scheduler.shutdown(true);
        System.out.println("scheduler has shut down ?" + scheduler.isShutdown());
        // 直接关闭 scheduler，未完成的任务也会继续执行完成
        scheduler.shutdown();
    }
}
