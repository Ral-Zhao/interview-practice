package questions.offer;


/**
 * 题目14 剪绳子
 *
 * 给你一根长度为n的绳子，请把绳子剪成m段（m、n都是整数，n>1且m>1），
 * 每段绳子的长度记为k[0],k[1]……k[m]。请问k[0]*k[1]*……*k[m]可能的最大乘积是多少？
 *
 */
public class CutString {

    /**
     * 利用动态规划解决该问题
     */
    public static int maxLengthUseDP(int length) {
        if (length < 2) {
            return 0;
        }
        if (length == 2) {
            return 1;
        }
        if (length == 3) {
            return 2;
        }
        int[] dp = new int[length + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        for (int i = 4; i <= length; i++) {
            int max = 0;
            for (int j = 1; j <= i / 2; j++) {
                max = Math.max(dp[j] * dp[i - j], max);
            }
            dp[i] = max;
        }
        return dp[length];
    }

    /**
     * 利用贪婪算法解决该问题
     */
    public static int maxLengthUseGreed(int length){
        if (length < 2) {
            return 0;
        }
        if (length == 2) {
            return 1;
        }
        if (length == 3) {
            return 2;
        }
        int timesOfThree = length/3;
        if (length-3*timesOfThree==1){
            timesOfThree--;
        }
        int timesOfTwo = (length-3*timesOfThree)/2;
        return (int) Math.pow(3,timesOfThree)*(int)Math.pow(2,timesOfTwo);
    }
}
