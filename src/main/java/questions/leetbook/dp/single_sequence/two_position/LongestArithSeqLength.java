package questions.leetbook.dp.single_sequence.two_position;

import org.junit.Assert;

import java.util.HashMap;
import java.util.Map;

/**
 * 给你一个整数数组 nums，返回 nums 中最长等差子序列的长度。
 * <p>
 * 回想一下，nums 的子序列是一个列表 nums[i1], nums[i2], ..., nums[ik] ，且 0 <= i1 < i2 < ... < ik <= nums.length - 1。
 * 并且如果 seq[i+1] - seq[i]( 0 <= i < seq.length - 1) 的值都相同，那么序列 seq 是等差的。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [3,6,9,12]
 * 输出：4
 * 解释：
 * 整个数组是公差为 3 的等差数列。
 * 示例 2：
 * <p>
 * 输入：nums = [9,4,7,2,10]
 * 输出：3
 * 解释：
 * 最长的等差子序列是 [4,7,10]。
 * 示例 3：
 * <p>
 * 输入：nums = [20,1,15,3,10,5,8]
 * 输出：4
 * 解释：
 * 最长的等差子序列是 [20,15,10,5]。
 *  
 * <p>
 * 提示：
 * <p>
 * 2 <= nums.length <= 1000
 * 0 <= nums[i] <= 500
 * <p>
 * 作者：FennelDumplings
 * 链接：https://leetcode-cn.com/leetbook/read/dynamic-programming-1-plus/5rta4g/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class LongestArithSeqLength {
    public int longestArithSeqLength(int[] nums) {
        if (nums.length == 2) {
            return 2;
        }
        Map<Integer, Integer> map = new HashMap<>();
        int[][] dp = new int[nums.length][nums.length];
        int max = 2;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int target = nums[i] - (nums[j] - nums[i]);
                if (map.containsKey(target) && map.get(target) < i) {
                    int k = map.get(target);
                    dp[i][j] = dp[k][i] + 1;
                    max = Math.max(max, dp[i][j]+2);
                }
            }
            map.put(nums[i], i);
        }
        return max;
    }

    public int longestArithSeqLength_2(int[] nums) {
        int n = nums.length, ans = 0;
        int[][] dp = new int[n][1010];//dp[i][d]表示以i结尾d为等差的最长序列长度
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                // nums[i]与其前面所有的数做差
                int d = nums[i] - nums[j] + 500;
                dp[i][d] = Math.max(dp[i][d], dp[j][d] + 1);
                ans = Math.max(ans, dp[i][d]);
            }
        }
        return ans + 1;
    }


    public static void main(String[] args) {
        LongestArithSeqLength solution = new LongestArithSeqLength();
        int[] nums = new int[]{3,6,9,12};
        Assert.assertEquals(4,solution.longestArithSeqLength(nums));
        nums = new int[]{9,4,7,2,10};
        Assert.assertEquals(3,solution.longestArithSeqLength(nums));
        nums = new int[]{20,1,15,3,10,5,8};
        Assert.assertEquals(4,solution.longestArithSeqLength(nums));
    }
}
