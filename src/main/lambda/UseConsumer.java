import com.alibaba.fastjson.JSON;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * @author luzuheng
 * @date 2019-07-01 01:59
 */
public class UseConsumer {

    public static void main(String[] args) {
        List<Student> students = Arrays.asList(new Student("zhangsan", 89d),
                new Student("lisi", 91d),
                new Student("wangwu", 98d));
        foreach(students, t -> t.setName(t.getName().toUpperCase()));
        System.out.println("students: " + JSON.toJSONString(students));
    }

    public static <E> void foreach(List<E> list, Consumer<E> consumer) {
        for (E e : list) {
            consumer.accept(e);
        }
    }
}
