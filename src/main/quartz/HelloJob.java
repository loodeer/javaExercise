
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

    private String message;

    private Float floatJobValue;

    private Double doubleTriggerValue;

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

        System.out.println("第二种获取方式");
        // 同名变量，trigger 里设置的优先级高，会覆盖 jobDetail 的
        System.out.println("message is:" + message);
        System.out.println("JobFloatValue is:" + floatJobValue);
        System.out.println("triggerDoubleValue is:" + doubleTriggerValue);
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Float getFloatJobValue() {
        return floatJobValue;
    }

    public void setFloatJobValue(Float floatJobValue) {
        this.floatJobValue = floatJobValue;
    }

    public Double getDoubleTriggerValue() {
        return doubleTriggerValue;
    }

    public void setDoubleTriggerValue(Double doubleTriggerValue) {
        this.doubleTriggerValue = doubleTriggerValue;
    }
}
