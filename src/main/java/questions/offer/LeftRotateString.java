package questions.offer;

/**
 *  题目58-2 左旋转字符串
 *
 *  字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。
 *  比如，输入字符串"abcdefg"和数字2，该方法将返回左旋两位得到的结果"cdefgab"。
 */
public class LeftRotateString {
    public static String rotate(String string, int n) {
        if (string == null || string.length() == 0 || n < 1 || n >= string.length()) {
            return string;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(string.substring(n)).append(string, 0, n);
        return sb.toString();
    }
}
