import java.util.concurrent.CountDownLatch;

public class CountDownLatchExample {

	public static void main(String[] args) {
		int threadCount = 8;

		CountDownLatch latch = new CountDownLatch(threadCount);

		for (int i = 0; i < threadCount; i++) {
			final int index = i;
			final long sleepTime = (long) (Math.random() * 5000);

			new Thread(() -> {
				System.out.println("Start task: " + index + ", sleepTime: " + sleepTime);
				try {
					Thread.sleep(sleepTime);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				System.out.println("End task: " + index);
				latch.countDown(); // 不运行这一句，那么整个程序就无法结束。
			}).start();
			;
		}

		try {
			latch.await();
			System.out.println("All tasks are done. ");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
