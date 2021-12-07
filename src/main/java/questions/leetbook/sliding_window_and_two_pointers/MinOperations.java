package questions.leetbook.sliding_window_and_two_pointers;

import org.junit.Assert;

/**
 * 给你一个整数数组 nums 和一个整数 x 。每一次操作时，你应当移除数组 nums 最左边或最右边的元素，然后从 x 中减去该元素的值。
 * 请注意，需要 修改 数组以供接下来的操作使用。
 * <p>
 * 如果可以将 x 恰好 减到 0 ，返回 最小操作数 ；否则，返回 -1 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,1,4,2,3], x = 5
 * 输出：2
 * 解释：最佳解决方案是移除后两个元素，将 x 减到 0 。
 * 示例 2：
 * <p>
 * 输入：nums = [5,6,7,8,9], x = 4
 * 输出：-1
 * 示例 3：
 * <p>
 * 输入：nums = [3,2,20,1,1,3], x = 10
 * 输出：5
 * 解释：最佳解决方案是移除后三个元素和前两个元素（总共 5 次操作），将 x 减到 0 。
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 10^5
 * 1 <= nums[i] <= 10^4
 * 1 <= x <= 10^9
 * <p>
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/sliding-window-and-two-pointers/rl4f2t/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class MinOperations {
    public int minOperations(int[] nums, int x) {
        if (x < nums[0] && x < nums[nums.length - 1]) {
            return -1;
        }
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int target = sum - x;
        if (target < 0) {
            return -1;
        }
        if (target == 0) {
            return nums.length;
        }
        int left = 0;
        int right = 0;
        sum = 0;
        int max = -1;
        while (left < nums.length || right < nums.length) {
            while (right < nums.length && sum < target) {
                sum += nums[right];
                right++;
            }
            if (sum == target) {
                max = Math.max(max, right - left);
            }
            sum -= nums[left];
            left++;
            if (sum == target) {
                max = Math.max(max, right - left);
            }
        }

        if (max == -1) {
            return -1;
        }
        return nums.length - max;
    }

    public static void main(String[] args) {
        MinOperations solution = new MinOperations();
        int[] nums = new int[]{1, 1, 4, 2, 3};
        Assert.assertEquals(2, solution.minOperations(nums, 5));
        nums = new int[]{3, 2, 20, 1, 1, 3};
        Assert.assertEquals(5, solution.minOperations(nums, 10));
        nums = new int[]{1, 1};
        Assert.assertEquals(-1, solution.minOperations(nums, 3));
        nums = new int[]{8828, 9581, 49, 9818, 9974, 9869, 9991, 10000, 10000, 10000, 9999, 9993, 9904, 8819, 1231, 6309};
        Assert.assertEquals(16, solution.minOperations(nums, 134365));
        nums = new int[]{5, 1, 4, 2, 3};
        Assert.assertEquals(2, solution.minOperations(nums, 6));
        nums = new int[]{1, 1, 99};
        Assert.assertEquals(2, solution.minOperations(nums, 2));
    }
}
