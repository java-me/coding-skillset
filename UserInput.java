import java.util.Scanner;

public class UserInput {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		String word0 = scanner.next();
		System.out.println(word0);
		String word1 = scanner.next();
		System.out.println(word1);

		String line0 = scanner.nextLine();
		System.out.println(line0);

		String line1 = scanner.nextLine();
		System.out.println(line1);




		
		scanner.close();
	}
}
