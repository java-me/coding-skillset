
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapExample {

	public static void main(String[] args) {

		ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();
		// 使用ConcurrentHashMap的作用是什么？好像使用普通的HashMap的效果也一样，输出的结果也一模一样。
		// 其实是有差别的，待阅读：https://www.doubao.com/chat/1521950771672834
		// HashMap<String, Integer> map = new HashMap<>();


		Thread writer = new Thread(() -> {
			for (int i = 0; i < 5; i++) {
				map.put(Integer.toString(i), i);
				System.out.println("put: " + i);
			}
		});

		Thread reader = new Thread(() -> {
			for (int i = 0; i < 5; i++) {
				Integer value = map.get(Integer.toString(i));
				System.out.println("get: " + value);
			}
		});

		writer.start();
		reader.start();
		
		try {
			writer.join();
			reader.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
