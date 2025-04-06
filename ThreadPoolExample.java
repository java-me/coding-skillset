import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolExample {

	public static void main(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(3);

		for (int i = 0; i < 10; i++) {
			// 为了在lambda表达式中使用，声明为final。
			final int taskNumber = i; // 貌似不声明为final也可以。
			executorService.submit(() -> {
				System.out.println(Thread.currentThread().getName() + " - " + taskNumber);
			});
		}

		executorService.shutdown();
	}
}
