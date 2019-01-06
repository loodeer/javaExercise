import java.util.Arrays;
import java.util.List;

/**
 * @author loodeer
 * @date 2019-01-06 16:36
 */
public class GetMedian {

    public static void main(String[] args) {
        Median<Integer> median = new Median<>();
        //List<Integer> list = Arrays.asList(13,15,17,18,14,1,2,3,4,5,6,7,8,9,10,11); // 8
        //List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9); // 5
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        median.addAll(list);
        System.out.println(median.getM());
    }
}
