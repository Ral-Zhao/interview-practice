package questions.offer;


/**
 *  题目49 丑数
 *
 *  我们把只包含因子2、3和5的数称作丑数。求按从小到大排序的第1500个丑数。
 *  习惯上我们把1当作第一个丑数。
 *
 */
public class UglyNumber {
    public static int getNumber(int index) {
        int[] arr = new int[index];
        arr[0] = 1;
        int indexOfTwo = 0;
        int indexOfThree = 0;
        int indexOfFive = 0;
        int pos = 1;
        while (pos < index) {
            int min = Math.min(arr[indexOfTwo] * 2, Math.min(arr[indexOfFive] * 5, arr[indexOfThree] * 3));
            arr[pos] = min;
            while (arr[indexOfTwo] * 2 <= min) {
                indexOfTwo++;
            }
            while (arr[indexOfThree] * 3 <= min) {
                indexOfThree++;
            }
            while (arr[indexOfFive] * 5 <= min) {
                indexOfFive++;
            }
            pos++;
        }
        return arr[index - 1];
    }
}
