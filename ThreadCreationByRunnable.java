class NumberPrintRunnable implements Runnable {
	@Override
	public void run() {
		for (int i = 0 ; i < 10 ; i++) {
			System.err.println(Thread.currentThread().getName() + ": " + i);
		}
	}
}

public class ThreadCreationByRunnable {
	public static void main(String[] args) {
		NumberPrintRunnable numberPrintRunnable = new NumberPrintRunnable();
		Thread thread = new Thread(numberPrintRunnable);
		thread.start();
	}
}
