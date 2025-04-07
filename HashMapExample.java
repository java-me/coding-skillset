import java.util.HashMap;

public class HashMapExample {
    public static void main(String[] args) {
        // 创建 HashMap 对象
        HashMap<String, Integer> map = new HashMap<>();

        // 添加键值对
        map.put("apple", 1);
        map.put("banana", 2);
        map.put("cherry", 3);

        // 获取键对应的值
        Integer value = map.get("apple");
        System.out.println("Value of 'apple': " + value);

        // 检查键是否存在
        boolean hasKey = map.containsKey("banana");
        System.out.println("Contains key 'banana': " + hasKey);

        // 检查值是否存在
        boolean hasValue = map.containsValue(3);
        System.out.println("Contains value 3: " + hasValue);

        // 获取 HashMap 的大小
        int size = map.size();
        System.out.println("Size of the map: " + size);

        // 删除键值对
        map.remove("cherry");
        System.out.println("Size after removing 'cherry': " + map.size());

        // 遍历键
        System.out.println("Keys in the map:");
        for (String key : map.keySet()) {
            System.out.println(key);
        }

        // 遍历值
        System.out.println("Values in the map:");
        for (Integer val : map.values()) {
            System.out.println(val);
        }

        // 遍历键值对
        System.out.println("Key-value pairs in the map:");
        for (HashMap.Entry<String, Integer> entry : map.entrySet()) {
            String key = entry.getKey();
            Integer val = entry.getValue();
            System.out.println(key + ": " + val);
        }
    }
}    