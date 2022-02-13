package questions.leetbook.dp.single_sequence.rob;

import org.junit.Assert;

/**
 * 给你一个披萨，它由 3n 块不同大小的部分组成，现在你和你的朋友们需要按照如下规则来分披萨：
 * <p>
 * 你挑选 任意 一块披萨。
 * Alice 将会挑选你所选择的披萨逆时针方向的下一块披萨。
 * Bob 将会挑选你所选择的披萨顺时针方向的下一块披萨。
 * 重复上述过程直到没有披萨剩下。
 * 每一块披萨的大小按顺时针方向由循环数组 slices 表示。
 * <p>
 * 请你返回你可以获得的披萨大小总和的最大值。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：slices = [1,2,3,4,5,6]
 * 输出：10
 * 解释：选择大小为 4 的披萨，Alice 和 Bob 分别挑选大小为 3 和 5 的披萨。
 * 然后你选择大小为 6 的披萨，Alice 和 Bob 分别挑选大小为 2 和 1 的披萨。你获得的披萨总大小为 4 + 6 = 10 。
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：slices = [8,9,8,6,1,1]
 * 输出：16
 * 解释：两轮都选大小为 8 的披萨。如果你选择大小为 9 的披萨，你的朋友们就会选择大小为 8 的披萨，
 * 这种情况下你的总和不是最大的。
 * 示例 3：
 * <p>
 * 输入：slices = [4,1,2,5,8,3,1,9,7]
 * 输出：21
 * 示例 4：
 * <p>
 * 输入：slices = [3,1,2]
 * 输出：3
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= slices.length <= 500
 * slices.length % 3 == 0
 * 1 <= slices[i] <= 1000
 * <p>
 * 作者：FennelDumplings
 * 链接：https://leetcode-cn.com/leetbook/read/dynamic-programming-1-plus/5rlibc/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class MaxSizeSlices {
    public int maxSizeSlices(int[] slices) {
        int[] slices1 = new int[slices.length - 1];
        System.arraycopy(slices, 1, slices1, 0, slices.length - 1);
        int[] slices2 = new int[slices.length - 1];
        System.arraycopy(slices, 0, slices2, 0, slices.length - 1);
        int ans1 = calculate(slices1);
        int ans2 = calculate(slices2);
        return Math.max(ans1, ans2);
    }

    public int calculate(int[] slices) {
        int n = slices.length;
        int choose = (n + 1) / 3;
        int[][] dp = new int[n + 1][choose + 1];
        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= choose; ++j) {
                dp[i][j] = Math.max(dp[i - 1][j], (i - 2 >= 0 ? dp[i - 2][j - 1] : 0) + slices[i - 1]);
            }
        }
        return dp[n][choose];
    }

    public static void main(String[] args) {
        MaxSizeSlices solution = new MaxSizeSlices();
        int[] slices = new int[]{1, 2, 3, 4, 5, 6};
        Assert.assertEquals(10, solution.maxSizeSlices(slices));
        slices = new int[]{8, 9, 8, 6, 1, 1};
        Assert.assertEquals(16, solution.maxSizeSlices(slices));
        slices = new int[]{4, 1, 2, 5, 8, 3, 1, 9, 7};
        Assert.assertEquals(21, solution.maxSizeSlices(slices));
        slices = new int[]{3, 1, 2};
        Assert.assertEquals(3, solution.maxSizeSlices(slices));
    }
}
