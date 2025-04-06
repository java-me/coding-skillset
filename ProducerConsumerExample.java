class ProducerConsumer {

	private int value = 0;
	private boolean hasValue = false;

	public synchronized void put(int i) {
		while (this.hasValue) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		this.value = i;
		this.hasValue = true;
		notify();
	}
	
	public synchronized void take() {
		while (!this.hasValue) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		this.hasValue = false;
		notify();
	}
	
		
	
}
	
public class ProducerConsumerExample {
	
	public static void main(String[] args) {
		ProducerConsumer pc = new ProducerConsumer();

		Thread producer = new Thread(() -> {
			for (int i = 0 ; i < 5 ; i++) {
				pc.put(i);
				System.out.println("Put: " + i);
			}
		});

		Thread consumer = new Thread(() -> {
			for (int i = 0 ; i < 5 ; i++) {
				pc.take();
				System.out.println("Take: " + i);
			}
		});

		producer.start();
		consumer.start();
		// 如果程序到这里结束， 并且此时put和take方法都为空的情况下，两个线程会以不可预知的顺序交替执行。

		// 就算用了以下的join的方法，在上面的put和take方法都为空的情况下，这两个线程依然会以不可预知的顺序交替执行。
		// 维持put和take方法为空的情况下，就算在这两个方法前面加了synchronized的修饰服，这两个线程依然会以不可预知的顺序交替执行。
		// 作为参考，在ThreadSynchronizationExample中， 由于两个线程都是使用了同一个同步方法increment()，所以呢，用了join的方法之后，就能够确保线程2会等到线程1执行完毕后才会执行。
		// 这个情况下，需要使用wait和notify方法来协调这两个方法的执行顺序，也就是做到take方法必须是在put方法之后才能执行，而且每次是先put一次，再take一次。
		try {
			producer.join();
			consumer.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
