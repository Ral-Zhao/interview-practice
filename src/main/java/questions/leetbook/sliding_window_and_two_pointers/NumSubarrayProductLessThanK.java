package questions.leetbook.sliding_window_and_two_pointers;

import org.junit.Assert;

/**
 * 给定一个正整数数组 nums和整数 k 。
 * <p>
 * 请找出该数组内乘积小于 k 的连续的子数组的个数。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [10,5,2,6], k = 100
 * 输出: 8
 * 解释: 8个乘积小于100的子数组分别为: [10], [5], [2], [6], [10,5], [5,2], [2,6], [5,2,6]。
 * 需要注意的是 [10,5,2] 并不是乘积小于100的子数组。
 * 示例 2:
 * <p>
 * 输入: nums = [1,2,3], k = 0
 * 输出: 0
 *  
 * <p>
 * 提示: 
 * <p>
 * 1 <= nums.length <= 3 * 10^4
 * 1 <= nums[i] <= 1000
 * 0 <= k <= 10^6
 * <p>
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/sliding-window-and-two-pointers/righbj/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class NumSubarrayProductLessThanK {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k == 0) {
            return 0;
        }
        int left = 0;
        int right = 0;
        int count = 0;
        int sum = 1;
        while (right < nums.length) {
            sum *= nums[right];
            right++;

            while (left < right && sum >= k) {
                sum /= nums[left];
                left++;
            }
            if (sum < k) {
                count += right - left;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        NumSubarrayProductLessThanK solution = new NumSubarrayProductLessThanK();
        int[] nums = new int[]{10, 5, 2, 6};
        Assert.assertEquals(8, solution.numSubarrayProductLessThanK(nums, 100));
        nums = new int[]{1, 2, 3};
        Assert.assertEquals(0, solution.numSubarrayProductLessThanK(nums, 0));
        nums = new int[]{1, 1, 1};
        Assert.assertEquals(0, solution.numSubarrayProductLessThanK(nums, 1));
    }
}
