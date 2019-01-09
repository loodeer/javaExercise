import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author loodeer
 * @date 2019-01-09 08:48
 */
public class LinkedHashMapExercise {

    public static void main(String[] args) {
        t1();
    }

    /**
     * 访问顺序，最近访问的 key 会移到内部双向链表末尾
     */
    private static void t1() {
        Map<String, Integer> accessMap = new LinkedHashMap<>(16, 0.75f, true);
        accessMap.put("c", 1);
        accessMap.put("d", 2);
        accessMap.put("a", 5);
        accessMap.get("c");
        accessMap.put("d", 3);

        for (Map.Entry<String, Integer> entry : accessMap.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
