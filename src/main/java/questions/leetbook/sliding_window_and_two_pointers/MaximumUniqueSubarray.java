package questions.leetbook.sliding_window_and_two_pointers;

import org.junit.Assert;

import java.util.HashMap;
import java.util.Map;

/**
 * 给你一个正整数数组 nums ，请你从中删除一个含有 若干不同元素 的子数组。删除子数组的 得分 就是子数组各元素之 和 。
 * <p>
 * 返回 只删除一个 子数组可获得的 最大得分 。
 * <p>
 * 如果数组 b 是数组 a 的一个连续子序列，即如果它等于 a[l],a[l+1],...,a[r] ，那么它就是 a 的一个子数组。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [4,2,4,5,6]
 * 输出：17
 * 解释：最优子数组是 [2,4,5,6]
 * 示例 2：
 * <p>
 * 输入：nums = [5,2,1,2,5,2,1,2,5]
 * 输出：8
 * 解释：最优子数组是 [5,2,1] 或 [1,2,5]
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 10^5
 * 1 <= nums[i] <= 10^4
 * <p>
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/sliding-window-and-two-pointers/riexy2/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class MaximumUniqueSubarray {
    public int maximumUniqueSubarray(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int right = 0;
        int left = 0;
        int sum = 0;
        int max = 0;
        while (right < nums.length) {
            int num = map.getOrDefault(nums[right], 0);
            map.put(nums[right], num + 1);
            sum += nums[right];
            right++;
            if (num == 0) {
                max = Math.max(max, sum);
            }
            while (map.get(nums[right-1]) > 1) {
                map.put(nums[left], map.get(nums[left]) - 1);
                sum -= nums[left];
                left++;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        MaximumUniqueSubarray solution = new MaximumUniqueSubarray();
        int[] nums = new int[]{4, 2, 4, 5, 6};
        Assert.assertEquals(17, solution.maximumUniqueSubarray(nums));
        nums = new int[]{5,2,1,2,5,2,1,2,5};
        Assert.assertEquals(8, solution.maximumUniqueSubarray(nums));
    }
}
