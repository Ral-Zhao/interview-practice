package questions.offer;

/**
 *  题目46 把数字翻译成字符串
 *
 *  给定一个数字，按照如下规则把它翻译成字符串：0翻译成"a"，1翻译成"b"，……，11翻译成"l"，……25翻译成"z"。
 *  一个数字可能有多个翻译。例如12258有5种不同的翻译，分别为"bccfi"，"bwfi"，"bczi"，"mcfi"和"mzi"。
 *  请实现一个方法，计算一个数字有多少种不同的翻译方法。
 *
 */
public class TranslateNumbersToStrings {
    public static int trasnlateNumbers(String numbers) {
        if (numbers == null || "".equals(numbers)) {
            return 0;
        }
        if (numbers.length() == 1) {
            return 1;
        }
        int[] dp = new int[numbers.length()];
        dp[numbers.length() - 1] = 1;
        int num = (numbers.charAt(numbers.length() - 2) - '0') * 10 + (numbers.charAt(numbers.length() - 1) - '0');
        dp[numbers.length() - 2] = num < 26 ? 2 : 1;
        for (int i = numbers.length() - 3; i >= 0; i--) {
            num = (numbers.charAt(i) - '0') * 10 + (numbers.charAt(i + 1) - '0');
            if (num < 26) {
                dp[i] = dp[i + 1] + dp[i + 2];
            } else {
                dp[i] = dp[i + 1];
            }
        }
        for (int n : dp) {
            System.out.print(n + " ");
        }
        return dp[0];
    }
}
