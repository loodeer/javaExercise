import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

/**
 * @author luzuheng
 * @date 2019-07-01 01:52
 */
public class UseFunction {

    public static void main(String[] args) {
        List<Student> students = Arrays.asList(new Student("zhangsan", 89d),
                new Student("lisi", 91d),
                new Student("wangwu", 98d));
        List<String> names = map(students, Student::getName);
        System.out.println("names: " + names);
        List<Double> scores = map(students, Student::getScore);
        System.out.println("scores: " + scores);
        // 将学生姓名改为大写
        students = map(students, t -> new Student(t.getName().toUpperCase(), t.getScore()));
        System.out.println("new students: " + JSON.toJSONString(students));
    }

    public static <T, R> List<R> map(List<T> list, Function<T, R> mapper) {
        List<R> retList = new ArrayList<>(list.size());
        for (T e : list) {
            retList.add(mapper.apply(e));
        }
        return  retList;
    }
}
