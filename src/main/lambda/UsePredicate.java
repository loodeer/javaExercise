import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * @author luzuheng
 * @date 2019-07-01 01:45
 */
public class UsePredicate {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(new Student("zhangsan", 89d),
                new Student("lisi", 91d),
                new Student("wangwu", 98d));

        students = filter(students, t -> t.getScore() > 90);
        System.out.println("大于90分的学生有：" + JSON.toJSONString(students));
    }

    private static <E> List<E> filter(List<E> list, Predicate<E> pred) {
        List<E> retList = new ArrayList<>();
        for (E e : list) {
            if (pred.test(e)) {
                retList.add(e);
            }
        }
        return retList;
    }
}
