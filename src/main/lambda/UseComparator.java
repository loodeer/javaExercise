import com.alibaba.fastjson.JSON;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author luzuheng
 * @date 2019-07-01 02:07
 */
public class UseComparator {

    public static void main(String[] args) {
        List<Student> students = Arrays.asList(new Student("zhangsan", 89d),
                new Student("lisi", 98d),
                new Student("wangwu", 98d));
        students.sort(Comparator.comparing(Student::getName));
        System.out.println("按姓名升序：" + JSON.toJSONString(students));
        students.sort(Comparator.comparing(Student::getName).reversed());
        System.out.println("按姓名降序：" + JSON.toJSONString(students));
        students.sort(Comparator.comparing(Student::getScore).reversed().thenComparing(Student::getName));
        System.out.println("按分数降序，分数相同按姓名升序：" + JSON.toJSONString(students));
    }

}
