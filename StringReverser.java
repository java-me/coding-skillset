public class StringReverser {
	public static void main(String[] args) {
		String s = "hello";
		StringBuilder sb = new StringBuilder(s);
		System.err.println(sb.reverse().toString());
	}
}
