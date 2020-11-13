package questions.offer;

import java.util.Arrays;
import java.util.Comparator;

/**
 *  题目45 把数组排成最小的数
 *
 *  输入一个整数数组，把数组里所有的数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 *  例如，输入数组{3,32,321},则打印出3个数字能排成的最小数字321323.
 */
public class SortArrayForMinNumber {
    public static String minNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        String[] numString = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            numString[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(numString, new MinNumberComparator());
        StringBuilder sb = new StringBuilder();
        for (String s : numString) {
            sb.append(s);
        }
        return sb.toString();
    }

    static class MinNumberComparator implements Comparator<String> {

        @Override
        public int compare(String o1, String o2) {
            String num1 = o1 + o2;
            String num2 = o2 + o1;
            return num1.compareTo(num2);
        }
    }
}
