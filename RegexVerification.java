import java.util.regex.Pattern;

public class RegexVerification {
    public static void main(String[] args) {
        // 定义正则表达式
        String regex = "^1(?:[^0]*0[^0]*0)+[^0]*$";
        // 编译正则表达式
        Pattern pattern = Pattern.compile(regex);

        // 测试字符串
        String[] testStrings = {"100001", "110000", "101", "0000", "10"};

        for (String testString : testStrings) {
            boolean isMatch = pattern.matcher(testString).matches();
            System.out.println("字符串 \"" + testString + "\" 是否匹配: " + isMatch);
        }
    }
}    