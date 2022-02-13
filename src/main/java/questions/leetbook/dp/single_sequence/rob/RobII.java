package questions.leetbook.dp.single_sequence.rob;

import org.junit.Assert;

/**
 * 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都 围成一圈 ，
 * 这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。
 * <p>
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，今晚能够偷窃到的最高金额。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [2,3,2]
 * 输出：3
 * 解释：你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
 * 示例 2：
 * <p>
 * 输入：nums = [1,2,3,1]
 * 输出：4
 * 解释：你可以先偷窃 1 号房屋（金额 = 1），然后偷窃 3 号房屋（金额 = 3）。
 *      偷窃到的最高金额 = 1 + 3 = 4 。
 * 示例 3：
 * <p>
 * 输入：nums = [1,2,3]
 * 输出：3
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 1000
 * <p>
 * 作者：FennelDumplings
 * 链接：https://leetcode-cn.com/leetbook/read/dynamic-programming-1-plus/5rds55/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class RobII {
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length==2){
            return Math.max(nums[0],nums[1]);
        }
        int[] dp1 = new int[nums.length-1];
        dp1[0] = nums[0];
        dp1[1] = nums[0];
        for (int i = 2; i < dp1.length; i++) {
            dp1[i] = Math.max(dp1[i-1],dp1[i-2]+nums[i]);
        }

        int[] dp2 = new int[nums.length];
        dp2[0] = 0;
        dp2[1] = nums[1];
        for (int i = 2; i < dp2.length; i++) {
            dp2[i] = Math.max(dp2[i-1],dp2[i-2]+nums[i]);
        }

        return Math.max(dp1[dp1.length-1],dp2[dp2.length-1]);
    }

    public static void main(String[] args) {
        RobII solution = new RobII();
        int[] nums = new int[]{2, 3, 2};
        Assert.assertEquals(3, solution.rob(nums));
        nums = new int[]{1, 2, 3, 1};
        Assert.assertEquals(4, solution.rob(nums));
        nums = new int[]{1, 2, 3};
        Assert.assertEquals(3, solution.rob(nums));
    }
}
