package questions.offer;

/**
 * 题目14 打印从1到最大的n位数
 * <p>
 * 输入数字n，按顺序打印从1到最大的n位十进制数。
 */
public class PrintMaxNumber {
    public static void printNumber(int max) {
        char[] arr = new char[max];
        helper(arr, max, 0);
    }

    private static void helper(char[] arr, int len, int index) {
        if (index == len - 1) {
            print(arr);
            return;
        }
        for (int i = 0; i < 10; i++) {
            arr[index] = (char) (i + '0');
            helper(arr, len, index + 1);
        }
    }

    private static void print(char[] arr) {
        StringBuilder sb = new StringBuilder();
        boolean first = true;
        for (int i = 0; i < arr.length; i++) {
            if (first && arr[i] == '0') {
                continue;
            }
            first = false;
            sb.append(arr[i]);
        }
        System.out.println(sb.toString());
    }
}
