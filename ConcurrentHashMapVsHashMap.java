import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

// 代码来源：https://www.doubao.com/chat/1521950771672834

public class ConcurrentHashMapVsHashMap {
    public static void main(String[] args) {
        // 测试 HashMap 在多线程环境下的问题
        // testHashMapInMultiThread();

        // 测试 ConcurrentHashMap 在多线程环境下的表现
        // testConcurrentHashMapInMultiThread();

        // 测试 HashMap 的快速失败迭代器
        // testHashMapIterator();

        // 测试 ConcurrentHashMap 的弱一致性迭代器
        testConcurrentHashMapIterator();
    }

    public static void testHashMapInMultiThread() {
        Map<String, Integer> hashMap = new HashMap<>();
        // 线程 1：向 HashMap 中添加元素
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                hashMap.put("key" + i, i);
            }
        });
        // 线程 2：从 HashMap 中读取元素
        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                hashMap.get("key" + i);
            }
        });
        thread1.start();
        thread2.start();
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("HashMap 元素数量: " + hashMap.size());
    }

    public static void testConcurrentHashMapInMultiThread() {
        Map<String, Integer> concurrentHashMap = new ConcurrentHashMap<>();
        // 线程 1：向 ConcurrentHashMap 中添加元素
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                concurrentHashMap.put("key" + i, i);
            }
        });
        // 线程 2：从 ConcurrentHashMap 中读取元素
        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                concurrentHashMap.get("key" + i);
            }
        });
        thread1.start();
        thread2.start();
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("ConcurrentHashMap 元素数量: " + concurrentHashMap.size());
    }

    public static void testHashMapIterator() {
        Map<String, Integer> hashMap = new HashMap<>();
        hashMap.put("key1", 1);
        hashMap.put("key2", 2);
        hashMap.put("key3", 3);
        Iterator<Map.Entry<String, Integer>> iterator = hashMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Integer> entry = iterator.next();
            if (entry.getKey().equals("key2")) {
                // 修改 HashMap 的结构，会触发快速失败
                hashMap.remove("key2");
            }
        }
    }

    public static void testConcurrentHashMapIterator() {
        Map<String, Integer> concurrentHashMap = new ConcurrentHashMap<>();
        concurrentHashMap.put("key1", 1);
        concurrentHashMap.put("key2", 2);
        concurrentHashMap.put("key3", 3);
        Iterator<Map.Entry<String, Integer>> iterator = concurrentHashMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Integer> entry = iterator.next();
            if (entry.getKey().equals("key2")) {
                // 修改 ConcurrentHashMap 的结构，不会抛出异常
                concurrentHashMap.remove("key2");
            }
        }
        System.out.println("ConcurrentHashMap 迭代完成，未抛出异常");
    }
}