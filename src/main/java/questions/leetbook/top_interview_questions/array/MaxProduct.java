package questions.leetbook.top_interview_questions.array;

import org.junit.Assert;

/**
 * 给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: [2,3,-2,4]
 * 输出: 6
 * 解释: 子数组 [2,3] 有最大乘积 6。
 * 示例 2:
 * <p>
 * 输入: [-2,0,-1]
 * 输出: 0
 * 解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
 * <p>
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions/xmk3rv/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class MaxProduct {
    public int maxProduct(int[] nums) {
        int[] dpMin = new int[nums.length];
        int[] dpMax = new int[nums.length];
        dpMin[0] = nums[0];
        dpMax[0] = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dpMax[i] = Math.max(nums[i], Math.max(dpMax[i - 1] * nums[i], dpMin[i - 1] * nums[i]));
            dpMin[i] = Math.min(nums[i], Math.min(dpMax[i - 1] * nums[i], dpMin[i - 1] * nums[i]));
            max = Math.max(max, dpMax[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        MaxProduct solution = new MaxProduct();
        int[] nums = new int[]{2, 3, -2, 4};
        Assert.assertEquals(6, solution.maxProduct(nums));
        nums = new int[]{-2, 0, -1};
        Assert.assertEquals(0, solution.maxProduct(nums));
    }
}
