package questions.offer;

/**
 *  题目63 股票的最大利润
 *
 *  假设把某股票的价格按照时间先后顺序存储在数组中，请问买卖股票一次可能获得的最大利润是多少？
 *  例如，一只股票在某些时间节点的价格为{9,11,8,5,7,12,16,14}。
 *  如果我们能在价格为5的时候买入并在价格为16时卖出，则能收获最大的利润11。
 */
public class MaximalProfit {
    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int[] dp = new int[prices.length];
        int low = prices[0];
        int maxProfit = 0;
        for (int i = 1; i < dp.length; i++) {
            if (prices[i] >= prices[i - 1]) {
                dp[i] = dp[i - 1] + (prices[i] - prices[i - 1]);
            } else {
                dp[i] = prices[i] - low >= 0 ? prices[i] - low : 0;
            }
            if (prices[i] < low) {
                low = prices[i];
            }
            if (dp[i] > maxProfit) {
                maxProfit = dp[i];
            }
        }
        return maxProfit;
    }
}
