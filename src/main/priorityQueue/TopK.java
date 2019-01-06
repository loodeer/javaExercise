import java.util.Collection;
import java.util.PriorityQueue;

/**
 * @author loodeer
 * @date 2019-01-06 16:04
 * 将待排序数据，维护一个长度为 K 的最小堆，堆的根就是第 K 个最大的元素
 */
class TopK<E> {

    /**
     * 优先级队列
     */
    private PriorityQueue<E> p;

    /**
     * K 由外部传入
     */
    private int k;

    TopK(int k) {
        this.k = k;
        this.p = new PriorityQueue<>(k);
    }

    void addAll(Collection<? extends E> c) {
        for (E e: c) {
            add(e);
        }
    }

    private void add(E e) {
        if (p.size() < k) {
            p.add(e);
            return;
        }

        // 取出最小堆头部元素，即最小值
        Comparable<? super E> head = (Comparable<? super E>) p.peek();
        if (head.compareTo(e) > 0) {
            // 小于 TopK 中的最小值，不用变
            return;
        }
        // 删除原最小值
        p.poll();
        // 将新元素加入
        p.add(e);
    }

    <T> T[] toArray(T[] a) {
        return p.toArray(a);
    }

    E getKth() {
        return p.peek();
    }
}
