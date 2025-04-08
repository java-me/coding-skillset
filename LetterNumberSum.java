import java.util.HashMap;
import java.util.Map;

public class LetterNumberSum {
    public static String convertString(String input) {
        Map<Character, Integer> letterCountMap = new HashMap<>();
        int i = 0;
        while (i < input.length()) {
            char letter = input.charAt(i);
            i++;
            StringBuilder numberStr = new StringBuilder();
            while (i < input.length() && Character.isDigit(input.charAt(i))) {
                numberStr.append(input.charAt(i));
                i++;
            }
            int number = Integer.parseInt(numberStr.toString());
            letterCountMap.put(letter, letterCountMap.getOrDefault(letter, 0) + number);
        }

        StringBuilder result = new StringBuilder();
        for (Map.Entry<Character, Integer> entry : letterCountMap.entrySet()) {
            result.append(entry.getKey());
            result.append(entry.getValue());
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(convertString("a3b5a2c4"));
		System.out.println(convertString("a3b5a20c4"));
    }
}    