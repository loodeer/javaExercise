import java.util.Arrays;

/**
 * @author loodeer
 * @date 2019-01-06 16:16
 * 求前 K 个最大的元素
 */
public class GetTopK {

    public static void main(String[] args) {
        TopK<Integer> top5 = new TopK<>(5);

        top5.addAll(Arrays.asList(4,2,13,8,9,5,7,14,17,89,45,323,99,764,234,65,767));
        System.out.println(Arrays.toString(top5.toArray(new Integer[0])));
        System.out.println(top5.getKth());
    }
}
