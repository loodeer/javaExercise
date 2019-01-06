import java.util.Collection;
import java.util.Collections;
import java.util.PriorityQueue;

/**
 * @author loodeer
 * @date 2019-01-06 16:26
 */
public class Median<E> {

    /**
     * 最小堆
     */
    private PriorityQueue<E> minP;

    /**
     * 最大堆
     */
    private PriorityQueue<E> maxP;

    /**
     * 当前中值
     */
    private E m;

    Median() {
        this.minP = new PriorityQueue<>();
        this.maxP = new PriorityQueue<>(11, Collections.reverseOrder());
    }

    private int compare(E e, E m) {
        Comparable<? super E> cmpr = (Comparable<? super E>) e;
        return cmpr.compareTo(m);
    }

    private void add(E e) {
        // 第一个元素
        if (m == null) {
            m = e;
            return;
        }
        if (compare(e, m) <= 0) {
            // 小于中值，加入最大堆
            maxP.add(e);
        } else {
            // 大于中值，加入最小堆
            minP.add(e);
        }
        // 两个堆差值达到 2， 重新调整。替换当前中值
        if (minP.size() - maxP.size() >= 2) {
            maxP.add(m);
            m = minP.poll();
        } else if (maxP.size() - minP.size() >= 2) {
            minP.add(m);
            m = maxP.poll();
        }
    }

    void addAll(Collection<? extends E> c) {
        for (E e: c) {
            add(e);
        }
    }

    E getM() {
        return m;
    }
}
