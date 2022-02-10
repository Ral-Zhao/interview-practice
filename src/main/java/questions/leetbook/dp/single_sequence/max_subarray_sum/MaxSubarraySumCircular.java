package questions.leetbook.dp.single_sequence.max_subarray_sum;

import org.junit.Assert;

/**
 * 给定一个由整数数组 A 表示的环形数组 C，求 C 的非空子数组的最大可能和。
 * <p>
 * 在此处，环形数组意味着数组的末端将会与开头相连呈环状。（形式上，当0 <= i < A.length 时 C[i] = A[i]，且当 i >= 0 时 C[i+A.length] = C[i]）
 * <p>
 * 此外，子数组最多只能包含固定缓冲区 A 中的每个元素一次。
 * （形式上，对于子数组 C[i], C[i+1], ..., C[j]，不存在 i <= k1, k2 <= j 其中 k1 % A.length = k2 % A.length）
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：[1,-2,3,-2]
 * 输出：3
 * 解释：从子数组 [3] 得到最大和 3
 * 示例 2：
 * <p>
 * 输入：[5,-3,5]
 * 输出：10
 * 解释：从子数组 [5,5] 得到最大和 5 + 5 = 10
 * 示例 3：
 * <p>
 * 输入：[3,-1,2,-1]
 * 输出：4
 * 解释：从子数组 [2,-1,3] 得到最大和 2 + (-1) + 3 = 4
 * 示例 4：
 * <p>
 * 输入：[3,-2,2,-3]
 * 输出：3
 * 解释：从子数组 [3] 和 [3,-2,2] 都可以得到最大和 3
 * 示例 5：
 * <p>
 * 输入：[-2,-3,-1]
 * 输出：-1
 * 解释：从子数组 [-1] 得到最大和 -1
 *  
 * <p>
 * 提示：
 * <p>
 * -30000 <= A[i] <= 30000
 * 1 <= A.length <= 30000
 * <p>
 * 作者：FennelDumplings
 * 链接：https://leetcode-cn.com/leetbook/read/dynamic-programming-1-plus/5r2pah/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class MaxSubarraySumCircular {
    public int maxSubarraySumCircular(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = dp[0];
        int sum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(0, dp[i - 1]) + nums[i];
            max = Math.max(max, dp[i]);
            sum += nums[i];
        }
        dp[0] = nums[0];
        int min = dp[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.min(dp[i - 1], 0) + nums[i];
            min = Math.min(min, dp[i]);
        }

        return max < 0 ? max : Math.max(max, sum - min);
    }

    public static void main(String[] args) {
        MaxSubarraySumCircular solution = new MaxSubarraySumCircular();
        int[] nums = new int[]{1, -2, 3, -2};
        Assert.assertEquals(3, solution.maxSubarraySumCircular(nums));
        nums = new int[]{5, -3, 5};
        Assert.assertEquals(10, solution.maxSubarraySumCircular(nums));
        nums = new int[]{3, -1, 2, -1};
        Assert.assertEquals(4, solution.maxSubarraySumCircular(nums));
        nums = new int[]{3, -2, 2, -3};
        Assert.assertEquals(3, solution.maxSubarraySumCircular(nums));
        nums = new int[]{-2, -3, -1};
        Assert.assertEquals(-1, solution.maxSubarraySumCircular(nums));
    }
}
