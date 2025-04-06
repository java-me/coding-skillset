
class NumberPrintThread extends Thread {

	@Override
	public void run() {
		for (int i = 0 ; i < 10 ; i++) {
			System.err.println(Thread.currentThread().getName() + ": " + i);
		}
	}
}

public class ThreadCreationByExtend {
	
	public static void main(String[] args) {
		NumberPrintThread numberPrintThread = new NumberPrintThread();
		numberPrintThread.start();
	}

}
