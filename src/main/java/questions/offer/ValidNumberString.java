package questions.offer;

/**
 *  题目20 表示数值的字符串
 *
 *  判断字符串是否表示数值（包括整数和小数）。
 *  例如："+100"、"5e2"、"-123"、"3.14"及"-1E-16"都表示数值。
 *  "12e"、"1a3.14"、"1.2.2"、"+-5"及"12e+5.4"都不是
 *
 */
public class ValidNumberString {
    public static boolean isValidNumberString(String number) {
        if (number == null || "".equals(number)) {
            return false;
        }

        int index = 0;
        if (number.charAt(0) == '+' || number.charAt(0) == '-') {
            index++;
        }
        while (index < number.length() &&
                (number.charAt(index) != '.' && number.charAt(index) != 'e' && number.charAt(index) != 'E')) {
            if (number.charAt(index) - '0' > 10 || number.charAt(index) - '0' < 0) {
                return false;
            }
            index++;
        }

        if (index == number.length()) {
            return true;
        }
        if (number.charAt(index) == '.') {
            index++;
            while (index < number.length() && (number.charAt(index) != 'e' && number.charAt(index) != 'E')) {
                if (number.charAt(index) - '0' > 10 || number.charAt(index) - '0' < 0) {
                    return false;
                }
                index++;
            }
        }
        if (index == number.length()) {
            return true;
        }

        if (number.charAt(index) == 'e' || number.charAt(index) == 'E') {
            index++;
            if (index == number.length()) {
                return false;
            }
            if (number.charAt(index) == '+' || number.charAt(index) == '-') {
                index++;
            }
            while (index < number.length()) {
                if (number.charAt(index) - '0' > 10 || number.charAt(index) - '0' < 0) {
                    return false;
                }
                index++;
            }
        }
        return index == number.length();
    }
}
