package questions.offer;

/**
 *  题目21 调整数组顺序使奇数位于偶数前面
 *
 *  输入一个整数数组，实现一个方法来调整数组中数字的顺序，
 *  使得所有奇数位于数字前半部分，所有偶数位于数组后半部分。
 */
public class ReorderOddEven {
    public static void reorder(int[] arr) {
        int oddIndex = 0;
        int evenIndex = arr.length - 1;
        while (oddIndex < evenIndex) {

            while (oddIndex < evenIndex && (arr[oddIndex] & 1) == 1) {
                oddIndex++;
            }
            while (oddIndex < evenIndex && (arr[evenIndex] & 1) == 0) {
                evenIndex--;
            }
            if (oddIndex < evenIndex) {
                int temp = arr[evenIndex];
                arr[evenIndex] = arr[oddIndex];
                arr[oddIndex] = temp;
            }
        }
    }
}
