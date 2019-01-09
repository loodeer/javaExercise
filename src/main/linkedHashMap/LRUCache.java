import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author loodeer
 * @date 2019-01-09 09:16
 */
public class LRUCache<K, V> extends LinkedHashMap {
    private int maxEntries;

    LRUCache(int maxEntries) {
        super(16, 0.75f, true);
        this.maxEntries = maxEntries;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry eldest) {
        return size() > maxEntries;
    }
}
