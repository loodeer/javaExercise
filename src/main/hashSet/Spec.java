import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * @author loodeer
 * @date 2019-01-08 09:21
 */
public class Spec {
    String size;
    String color;
    public Spec(String size, String color) {
        this.size = size;
        this.color = color;
    }

    @Override public String toString() {
        return "[size=" + size + ", color=" + color + "]";
    }

    @Override public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Spec spec = (Spec) o;
        return Objects.equals(size, spec.size) &&
                Objects.equals(color, spec.color);
    }

    @Override public int hashCode() {
        return Objects.hash(size, color);
    }

    public static void main(String[] args) {
        // Spec 类必须重写 toString 和 equals 下面才输出一个元素
        // Map/Set的key为自定义对象时，必须重写hashCode和equals。 关于hashCode和equals的处理，遵循如下规则：  1） 只要重写equals，就必须重写hashCode。  2） 因为Set存储的是不重复的对象，依据hashCode和equals进行判断，所以Set存储的对象必须重写这两个方法。  3） 如果自定义对象做为Map的键，那么必须重写hashCode和equals
        Set<Spec> set = new HashSet<>();
        set.add(new Spec("M", "red"));
        set.add(new Spec("M", "red"));
        System.out.println(set);
    }
}
