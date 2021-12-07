package questions.leetbook.sliding_window_and_two_pointers;

import org.junit.Assert;

/**
 * 给定一个含有 n 个正整数的数组和一个正整数 target 。
 * <p>
 * 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。
 * 如果不存在符合条件的子数组，返回 0 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：target = 7, nums = [2,3,1,2,4,3]
 * 输出：2
 * 解释：子数组 [4,3] 是该条件下的长度最小的子数组。
 * 示例 2：
 * <p>
 * 输入：target = 4, nums = [1,4,4]
 * 输出：1
 * 示例 3：
 * <p>
 * 输入：target = 11, nums = [1,1,1,1,1,1,1,1]
 * 输出：0
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= target <= 109
 * 1 <= nums.length <= 105
 * 1 <= nums[i] <= 105
 *  
 * <p>
 * 进阶：
 * <p>
 * 如果你已经实现 O(n) 时间复杂度的解法, 请尝试设计一个 O(n log(n)) 时间复杂度的解法。
 * <p>
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/sliding-window-and-two-pointers/ri9ec6/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class MinSubArrayLen {
    public int minSubArrayLen(int target, int[] nums) {
        int min = nums.length + 1;
        int left = 0;
        int right = 0;
        int sum = 0;
        while (right < nums.length) {
            while (right < nums.length && sum < target) {
                sum += nums[right];
                right++;
            }
            if (sum >= target) {
                min = Math.min(min, right - left);
            }
            while (left < right && sum >= target) {
                min = Math.min(min, right - left);
                sum -= nums[left];
                left++;
            }
        }
        return min == nums.length + 1 ? 0 : min;
    }

    public static void main(String[] args) {
        MinSubArrayLen solution = new MinSubArrayLen();
        int[] nums = new int[]{2, 3, 1, 2, 4, 3};
        Assert.assertEquals(2, solution.minSubArrayLen(7, nums));
        nums = new int[]{1, 4, 4};
        Assert.assertEquals(1, solution.minSubArrayLen(4, nums));
        nums = new int[]{1, 1, 1, 1, 1, 1, 1, 1};
        Assert.assertEquals(0, solution.minSubArrayLen(11, nums));
        nums = new int[]{1, 2, 3, 4, 5};
        Assert.assertEquals(3, solution.minSubArrayLen(11, nums));
    }
}
