import org.apache.commons.lang3.StringUtils;

/**
 * @author loodeer
 * @date 2018-12-26 18:01
 */
public class FilterEmoj {

    public static void main(String[] args) {
        String source = "13256673xcfk的冯绍🙍峰快递是👌否KL9第➕三方";
        String slipStr = "-";
        System.out.println(filterEmoji(source, slipStr));
    }

    /**
     * emoji表情替换
     *
     * @param source 原字符串
     * @param slipStr emoji表情替换成的字符串
     * @return 过滤后的字符串
     */
    public static String filterEmoji(String source,String slipStr) {
        if(StringUtils.isNotBlank(source)){
            return source.replaceAll("[\\ud800\\udc00-\\udbff\\udfff\\ud800-\\udfff]", slipStr);
        }else{
            return source;
        }
    }
}
