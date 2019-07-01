import com.alibaba.fastjson.JSON;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author luzuheng
 * @date 2019-07-01 02:22
 */
public class UseStream {

    public static void main(String[] args) {
        List<Student> students = Arrays.asList(new Student("zhangsan", 89d),
                new Student("lisi", 91d),
                new Student("wangwu", 98d));

        List<Student> above90List = students.stream().filter(t -> t.getScore() > 90).collect(Collectors.toList());
        System.out.println("90分以上同学：" + JSON.toJSONString(above90List));
        List<String> nameList = students.stream().map(Student::getName).collect(Collectors.toList());
        System.out.println("学生姓名：" + nameList);
        List<String> above90Names = students.stream().filter(t -> t.getScore() > 90).peek(System.out::println).map(Student::getName).peek(System.out::println).collect(
                Collectors.toList());
        System.out.println("90分以上同学姓名：" + JSON.toJSONString(above90Names));

        double sum = students.stream().mapToDouble(Student::getScore).sum();
        System.out.println("总分：" + sum);

    }
}
