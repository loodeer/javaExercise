
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobKey;
import org.quartz.TriggerKey;

/**
 * @author loodeer
 * @date 2018-12-24 00:51
 */
public class HelloJob implements Job {

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        DateTime now = new DateTime();
        DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");
        System.out.println("current exec time is: " + now.toString(dateTimeFormatter));

        JobKey jobKey = jobExecutionContext.getJobDetail().getKey();
        System.out.println("My Job name and group are: " + jobKey.getName() + ":" + jobKey.getGroup());

        TriggerKey triggerKey = jobExecutionContext.getTrigger().getKey();
        System.out.println("My trigger name and group are: " + triggerKey.getName() + ":" + triggerKey.getGroup());

        JobDataMap jobDataMap = jobExecutionContext.getJobDetail().getJobDataMap();
        System.out.println("JobMsg is:" + jobDataMap.getString("message"));
        System.out.println("JobFloatValue is:" + jobDataMap.getFloat("floatJobValue"));

        JobDataMap triggerJobDateMap = jobExecutionContext.getTrigger().getJobDataMap();
        System.out.println("triggerMsg is:" + triggerJobDateMap.getString("message"));
        System.out.println("triggerDoubleValue is: " + triggerJobDateMap.getDouble("doubleTriggerValue"));

    }
}
