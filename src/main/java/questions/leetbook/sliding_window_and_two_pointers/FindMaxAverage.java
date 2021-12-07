package questions.leetbook.sliding_window_and_two_pointers;

import org.junit.Assert;

/**
 * 给你一个由 n 个元素组成的整数数组 nums 和一个整数 k 。
 * <p>
 * 请你找出平均数最大且 长度为 k 的连续子数组，并输出该最大平均数。
 * <p>
 * 任何误差小于 10-5 的答案都将被视为正确答案。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,12,-5,-6,50,3], k = 4
 * 输出：12.75
 * 解释：最大平均数 (12-5-6+50)/4 = 51/4 = 12.75
 * 示例 2：
 * <p>
 * 输入：nums = [5], k = 1
 * 输出：5.00000
 *  
 * <p>
 * 提示：
 * <p>
 * n == nums.length
 * 1 <= k <= n <= 105
 * -104 <= nums[i] <= 104
 * <p>
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/sliding-window-and-two-pointers/rlqtt2/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class FindMaxAverage {
    public double findMaxAverage(int[] nums, int k) {
        int right = 0;
        int left = 0;
        int sum = 0;
        int max = Integer.MIN_VALUE;
        while (right < nums.length) {
            while (right < nums.length && right - left < k) {
                sum += nums[right];
                right++;
            }
            max = Math.max(max, sum);
            sum = sum - nums[left];
            left++;
        }
        return max * 1.0 / k;
    }

    public static void main(String[] args) {
        FindMaxAverage solution = new FindMaxAverage();
        int[] nums = new int[]{1, 12, -5, -6, 50, 3};
        Assert.assertEquals(12.75, solution.findMaxAverage(nums, 4), 0.000001);
        nums = new int[]{5};
        Assert.assertEquals(5.00, solution.findMaxAverage(nums, 1), 0.000001);
    }
}
