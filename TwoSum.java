import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        // 创建一个哈希表用于存储值及其对应的索引
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            // 计算当前元素的补数
            int complement = target - nums[i];
            // 如果补数在哈希表中存在，说明找到了两个数的和为目标值
            if (map.containsKey(complement)) {
                // 返回这两个数的索引
                return new int[]{map.get(complement), i};
            }
            // 将当前元素及其索引存入哈希表
            map.put(nums[i], i);
        }
        // 如果没有找到这样的两个数，返回空数组
        return new int[0];
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] result = twoSum(nums, target);
        for (int i : result) {
            System.out.print(i + " ");
        }
    }
}