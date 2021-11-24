package questions.leetbook.greedy;

import org.junit.Assert;

/**
 * 给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。
 * <p>
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * <p>
 * 判断你是否能够到达最后一个下标。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [2,3,1,1,4]
 * 输出：true
 * 解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
 * 示例 2：
 * <p>
 * 输入：nums = [3,2,1,0,4]
 * 输出：false
 * 解释：无论怎样，总会到达下标为 3 的位置。但该下标的最大跳跃长度是 0 ， 所以永远不可能到达最后一个下标。
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 3 * 10^4
 * 0 <= nums[i] <= 10^5
 * <p>
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/greedy/rv7s03/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class JumpGame {
    public boolean canJump(int[] nums) {
        if (nums.length == 1) {
            return true;
        }
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (i <= max) {
                max = Math.max(max, nums[i] + i);
                if (max >= nums.length - 1) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        JumpGame solution = new JumpGame();
        int[] nums = new int[]{2, 3, 1, 1, 4};
        Assert.assertTrue(solution.canJump(nums));
        nums = new int[]{3, 2, 1, 0, 4};
        Assert.assertTrue(!solution.canJump(nums));
        nums = new int[]{0};
        Assert.assertTrue(solution.canJump(nums));
    }
}
