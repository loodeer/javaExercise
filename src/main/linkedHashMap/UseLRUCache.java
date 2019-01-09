/**
 * @author loodeer
 * @date 2019-01-09 09:19
 */
public class UseLRUCache {

    public static void main(String[] args) {
        LRUCache<String, Object> cache = new LRUCache<>(3);
        cache.put("a", "abstract");
        cache.put("b", "basic");
        cache.put("c", "call");
        cache.get("a");
        cache.put("d", "call");
        System.out.println(cache);
    }
}
