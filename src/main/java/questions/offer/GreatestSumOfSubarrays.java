package questions.offer;

/**
 *  题目42 连续子数组的最大和
 *
 *  输入一个整型数组，数组里有整数也有负数。数组中的一个或连续多个整数组成一个子数组。
 *  求所有子数组的和的最大值。要求时间复杂度为O(n)。
 *
 */
public class GreatestSumOfSubarrays {
    public static int greatestSum(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int[] dp = new int[arr.length];
        dp[0] = arr[0];
        int max = dp[0];
        for (int i = 1; i < arr.length; i++) {
            int value = arr[i];
            if (arr[i] + dp[i - 1] > arr[i]) {
                value = arr[i] + dp[i - 1];
            }
            dp[i] = value;
            if (value > max) {
                max = value;
            }
        }
        return max;
    }
}
