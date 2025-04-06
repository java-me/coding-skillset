class SynchronizedCounter {

	private int i = 0;

	public synchronized void increment() {
		i++;
		System.err.println(Thread.currentThread().getName() + ": " + i);
	}
}

public class ThreadSynchronizationExample {
	public static void main(String[] args) {
		SynchronizedCounter synchronizedCounter = new SynchronizedCounter();

		Thread t1 = new Thread(() -> {
			for (int i = 0 ; i < 10 ; i++) {
				synchronizedCounter.increment();
			}
		});

		Thread t2 = new Thread(() -> {
			for (int i = 0 ; i < 10 ; i++) {
				synchronizedCounter.increment();
			}
		});

		t1.start();
		t2.start();
		// 如果程序在这里结束，我们会看到t1和t2会交替执行。

		// 下面将使用join的方法来确保第二个线程要等到第一个线程完全执行完之后才执行。
		// 要实现这个效果，必须要在上面的方法SynchronizedCounter.increment里面使用synchronized这个修饰符。
		// 否则，这两个线程也依然会以不可预知的顺序交替执行。

		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
