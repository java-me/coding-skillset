public class PrimeNumberChecker {

	private static boolean isPrime(int num) {
		if (num <= 1) {
			return false;
		}

		for (int i = 2 ; i <= Math.sqrt(num) ; i++) {
			if (num % i == 0) return false;
		}

		return true;
	}
	
	public static void main(String[] args) {
		
		for (int i = 0 ; i < 100 ; i++) {
			if (isPrime(i)) {
				System.err.println(i);
			}
		}
	}

}
