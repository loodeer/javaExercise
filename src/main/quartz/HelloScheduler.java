import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

/**
 * @author loodeer
 * @date 2018-12-24 01:21
 */
public class HelloScheduler {
    public static void main(String[] args) throws SchedulerException {
        // 创建 jobDeatil 实例，绑定 HelloJob
        JobDetail jobDetail = JobBuilder.newJob(HelloJob.class).withIdentity("myJob", "group1").build();

        System.out.println("JobDetail's name is: " + jobDetail.getKey().getName());
        System.out.println("JobDetail's group is: " + jobDetail.getKey().getGroup());
        System.out.println("JobDetail's class is: " + jobDetail.getJobClass().getName());

        // 创建 Trigger 实例，定义频率
        Trigger trigger = TriggerBuilder.newTrigger().withIdentity("myTrigger", "group1").startNow()
                .withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(2).repeatForever()).build();

        // 创建 scheduler 实例
        Scheduler scheduler = new StdSchedulerFactory().getScheduler();
        scheduler.scheduleJob(jobDetail, trigger);
        scheduler.start();

        DateTime now = new DateTime();
        DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");
        System.out.println("current time is: " + now.toString(dateTimeFormatter));
    }
}
