package questions.leetbook.dp.single_sequence.max_subarray_sum;

import org.junit.Assert;

/**
 * 给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），
 * 并返回该子数组所对应的乘积。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: [2,3,-2,4]
 * 输出: 6
 * 解释: 子数组 [2,3] 有最大乘积 6。
 * 示例 2:
 *
 * 输入: [-2,0,-1]
 * 输出: 0
 * 解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
 *
 * 作者：FennelDumplings
 * 链接：https://leetcode-cn.com/leetbook/read/dynamic-programming-1-plus/5rmwns/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class MaxProduct {
    public int maxProduct(int[] nums) {
        int[] dpMax = new int[nums.length];
        int[] dpMin = new int[nums.length];
        dpMax[0] = nums[0];
        dpMin[0] = nums[0];
        int max = dpMax[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i]>0){
                dpMax[i] = Math.max(nums[i],nums[i]*dpMax[i-1]);
                dpMin[i] = Math.min(nums[i],nums[i]*dpMin[i-1]);
            }else if (nums[i]<0){
                dpMax[i] = Math.max(nums[i],nums[i]*dpMin[i-1]);
                dpMin[i] = Math.min(nums[i],nums[i]*dpMax[i-1]);
            }else {
                dpMax[i] = 0;
                dpMin[i] = 0;
            }
            max = Math.max(max,dpMax[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        MaxProduct solution = new MaxProduct();
        int[] nums = new int[]{2,3,-2,4};
        Assert.assertEquals(6,solution.maxProduct(nums));
        nums = new int[]{-2,0,-1};
        Assert.assertEquals(0,solution.maxProduct(nums));
        nums = new int[]{5,6,-3,4,-3};
        Assert.assertEquals(1080,solution.maxProduct(nums));
    }
}
