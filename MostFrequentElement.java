import java.util.HashMap;
import java.util.Map;

public class MostFrequentElement {
    public static int mostFrequent(int[] nums) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }
        int maxCount = 0;
        int mostFrequent = 0;
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                mostFrequent = entry.getKey();
            }
        }
        return mostFrequent;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 3, 2, 4, 4, 4};
        System.out.println(mostFrequent(nums));
    }
}