package questions.leetbook.top_interview_questions.dp;

import org.junit.Assert;

import java.util.Arrays;

/**
 * 给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
 * <p>
 * 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。
 * <p>
 * 你可以认为每种硬币的数量是无限的。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：coins = [1, 2, 5], amount = 11
 * 输出：3
 * 解释：11 = 5 + 5 + 1
 * 示例 2：
 * <p>
 * 输入：coins = [2], amount = 3
 * 输出：-1
 * 示例 3：
 * <p>
 * 输入：coins = [1], amount = 0
 * 输出：0
 * 示例 4：
 * <p>
 * 输入：coins = [1], amount = 1
 * 输出：1
 * 示例 5：
 * <p>
 * 输入：coins = [1], amount = 2
 * 输出：2
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= coins.length <= 12
 * 1 <= coins[i] <= 2^31 - 1
 * 0 <= amount <= 10^4
 * <p>
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions/x2echt/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        int[][] dp = new int[coins.length][amount + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 0;
        }
        for (int i = 1; i <= amount; i++) {
            if (i < coins[0]) {
                dp[0][i] = -1;
                continue;
            }
            dp[0][i] = i % coins[0] == 0 ? i / coins[0] : -1;
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j <= amount; j++) {
                if (coins[i] > j || dp[i][j - coins[i]] == -1) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    if (dp[i - 1][j] != -1) {
                        dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - coins[i]] + 1);
                    } else {
                        dp[i][j] = dp[i][j - coins[i]] + 1;
                    }
                }
            }
        }
        return dp[coins.length - 1][amount];
    }

    public int method_2(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                //无法凑成amount
                if (i < coin || dp[i - coin] == -1) {
                    continue;
                }
                if (dp[i] == -1) {
                    dp[i] = dp[i - coin] + 1;
                } else {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[amount];
    }

    public static void main(String[] args) {
        CoinChange solution = new CoinChange();
        int[] nums = new int[]{1, 2, 5};
        Assert.assertEquals(3, solution.coinChange(nums, 11));
        nums = new int[]{2};
        Assert.assertEquals(-1, solution.coinChange(nums, 3));
        nums = new int[]{1};
        Assert.assertEquals(0, solution.coinChange(nums, 0));
        nums = new int[]{1};
        Assert.assertEquals(2, solution.coinChange(nums, 2));
        nums = new int[]{2, 5, 10, 1};
        Assert.assertEquals(4, solution.coinChange(nums, 27));
        nums = new int[]{384, 324, 196, 481};
        Assert.assertEquals(-1, solution.coinChange(nums, 285));
        nums = new int[]{1, 2};
        Assert.assertEquals(1, solution.coinChange(nums, 2));
    }
}
