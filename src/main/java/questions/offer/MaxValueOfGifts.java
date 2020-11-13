package questions.offer;

/**
 *  题目47 礼物的最大价值
 *
 *  在一个m×n的棋盘的每一格都放有一个礼物，每个礼物有一定的价值（价值大于0）。
 *  你可以从棋盘的左上角开始拿格子里的礼物，并每次向左或向下移动一格，直到到达棋盘的右下角。
 *  给定一个棋盘及其上面的礼物，请计算你最多能拿多少价值的礼物。
 */
public class MaxValueOfGifts {
    public static int maxValue(int[][] gifts) {
        if (gifts == null || gifts.length == 0) {
            return 0;
        }
        int[][] dp = new int[gifts.length][gifts[0].length];
        dp[0][0] = gifts[0][0];
        for (int i = 1; i < gifts.length; i++) {
            dp[i][0] = dp[i-1][0]+gifts[i][0];
        }
        for (int i = 1; i < gifts[0].length; i++) {
            dp[0][i] = dp[0][i-1]+gifts[0][i];
        }
        for (int i = 1; i < gifts.length; i++) {
            for (int j = 1; j < gifts[0].length; j++) {
                dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1])+gifts[i][j];
            }
        }
        return dp[gifts.length-1][gifts[0].length-1];
    }
}
