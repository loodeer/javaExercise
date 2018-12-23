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

        DateTime now = new DateTime();
        DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");

        // 创建 jobDeatil 实例，绑定 HelloJob
        JobDetail jobDetail = JobBuilder.newJob(HelloJob.class).withIdentity("myJob", "group1")
                .usingJobData("message", "my job message").usingJobData("floatJobValue", 3.14159F).build();

        System.out.println("JobDetail's name is: " + jobDetail.getKey().getName());
        System.out.println("JobDetail's group is: " + jobDetail.getKey().getGroup());
        System.out.println("JobDetail's class is: " + jobDetail.getJobClass().getName());

        // 创建 Trigger 实例，定义频率
        Trigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("myTrigger", "group1")
                // 立马触发
                // .startNow()
                // 3 秒后执行
                .startAt(now.plusSeconds(3).toDate())
                // 6 秒后结束
                .endAt(now.plusSeconds(6).toDate())
                // 间隔两秒
                .withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(2).repeatForever())
                .usingJobData("message", "my trigger message")
                .usingJobData("doubleTriggerValue", 3.1D)
                .build();

        // 创建 scheduler 实例
        Scheduler scheduler = new StdSchedulerFactory().getScheduler();
        scheduler.scheduleJob(jobDetail, trigger);
        scheduler.start();
        System.out.println("current time is: " + now.toString(dateTimeFormatter));
    }
}
