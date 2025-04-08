import java.util.Arrays;
import java.util.Comparator;

public class PrimitiveArraySorting {
    public static void main(String[] args) {
        // 整数数组排序
        int[] intArray = {5, 3, 8, 1, 2};
        Arrays.sort(intArray, Comparator.reverseOrder());
        System.out.println("【降序】排序后的整数数组: " + Arrays.toString(intArray));

        // 双精度数组排序
        double[] doubleArray = {3.2, 1.5, 2.7, 0.9};
        Arrays.sort(doubleArray);
        System.out.println("排序后的双精度数组: " + Arrays.toString(doubleArray));

        // 字符数组排序
        char[] charArray = {'c', 'a', 'b'};
        Arrays.sort(charArray);
        System.out.println("排序后的字符数组: " + Arrays.toString(charArray));
    }
}