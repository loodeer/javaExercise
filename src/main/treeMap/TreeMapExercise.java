import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author loodeer
 * @date 2019-01-08 09:59
 */
public class TreeMapExercise {

    public static void main(String[] args) {
        t3();
        t1();
        t2();
    }

    private static void t3() {
        int i = 16;

        System.out.println(Integer.toBinaryString(i));
        System.out.println(Integer.toHexString(i));
    }

    private static void t1() {
        // 正序
        // Map<String, String> map = new TreeMap<>(String::compareToIgnoreCase);
        // 逆序
        Map<String, String> map = new TreeMap<>(new Comparator<String>() {
            @Override public int compare(String o1, String o2) {
                // return o2.compareTo(o1);
                // 无视大小写
                return o2.compareToIgnoreCase(o1);
            }
        });
        map.put("c", "call");
        map.put("a", "abstract");
        map.put("t", "tree");
        map.put("B", "basic");

        for (Map.Entry<String, String> entry : map.entrySet()) {
            // TreeMap 当 map 使用，输出时 key 也是按顺序的。
            System.out.println(entry.getKey() + "=" + entry.getValue());
        }
    }

    private static void t2() {
        // 按日期比较，默认会按字符串比较，会出现 7-3 > 7-10 的情况
        Map<String, Integer> map = new TreeMap<>(new Comparator<String>() {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            @Override public int compare(String o1, String o2) {
                try {
                    return simpleDateFormat.parse(o1).compareTo(simpleDateFormat.parse(o2));
                } catch (ParseException e) {
                    e.printStackTrace();
                    return 0;
                }
            }
        });
        map.put("2019-7-3", 100);
        map.put("2019-7-10", 120);
        map.put("2019-8-1", 90);

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + "=" + entry.getValue());
        }
    }
}
