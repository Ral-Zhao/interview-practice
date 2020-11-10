package questions.offer;

/**
 * 题目43 1~n整数中1出现的次数
 *
 * 输入一个整数n，求1~n这n个整数的十进制表示中1出现的次数。
 * 例如，输入12，1~12的整数中包含1的数字有1、10、11和12，1一共出现了5次。
 */
public class NumberOf1 {
    public static int getNumbers(int num) {
        if (num < 1) {
            return 0;
        }
        if (num < 10) {
            return 1;
        }
        return helper(String.valueOf(num));
    }

    private static int helper(String num) {
        if ("".equals(num)){
            return 0;
        }
        char ch = num.charAt(0);
        if (num.length() == 1) {
            if (ch - '0' > 0) {
                return 1;
            } else {
                return 0;
            }
        }
        int numOfFirst = 0;
        int firstNumber = ch - '0';
        if (firstNumber > 1) {
            numOfFirst = powerBase10(num.length() - 1);
        } else {
            numOfFirst = Integer.parseInt(num.substring(1)) + 1;
        }
        int numOfOther = firstNumber * (num.length() - 1) * powerBase10(num.length() - 2);
        return helper(num.substring(1)) + numOfFirst + numOfOther;

    }

    private static int powerBase10(int n) {
        int result = 1;
        for (int i = 0; i < n; i++) {
            result = result * 10;
        }
        return result;
    }
}
