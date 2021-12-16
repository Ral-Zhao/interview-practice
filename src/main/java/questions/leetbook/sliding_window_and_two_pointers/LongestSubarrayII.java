package questions.leetbook.sliding_window_and_two_pointers;

import org.junit.Assert;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 给你一个整数数组 nums ，和一个表示限制的整数 limit，请你返回最长连续子数组的长度，该子数组中的任意两个元素之间的绝对差必须小于或者等于 limit 。
 * <p>
 * 如果不存在满足条件的子数组，则返回 0 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [8,2,4,7], limit = 4
 * 输出：2
 * 解释：所有子数组如下：
 * [8] 最大绝对差 |8-8| = 0 <= 4.
 * [8,2] 最大绝对差 |8-2| = 6 > 4.
 * [8,2,4] 最大绝对差 |8-2| = 6 > 4.
 * [8,2,4,7] 最大绝对差 |8-2| = 6 > 4.
 * [2] 最大绝对差 |2-2| = 0 <= 4.
 * [2,4] 最大绝对差 |2-4| = 2 <= 4.
 * [2,4,7] 最大绝对差 |2-7| = 5 > 4.
 * [4] 最大绝对差 |4-4| = 0 <= 4.
 * [4,7] 最大绝对差 |4-7| = 3 <= 4.
 * [7] 最大绝对差 |7-7| = 0 <= 4.
 * 因此，满足题意的最长子数组的长度为 2 。
 * 示例 2：
 * <p>
 * 输入：nums = [10,1,2,4,7,2], limit = 5
 * 输出：4
 * 解释：满足题意的最长子数组是 [2,4,7,2]，其最大绝对差 |2-7| = 5 <= 5 。
 * 示例 3：
 * <p>
 * 输入：nums = [4,2,2,2,4,4,2,2], limit = 0
 * 输出：3
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 10^5
 * 1 <= nums[i] <= 10^9
 * 0 <= limit <= 10^9
 * <p>
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/sliding-window-and-two-pointers/ru2r9d/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class LongestSubarrayII {
    public int longestSubarray(int[] nums, int limit) {
        Deque<Integer> min = new ArrayDeque<>();
        Deque<Integer> max = new ArrayDeque<>();
        int left = 0;
        int right = 0;
        int len = 0;
        while (right < nums.length) {
            while (!min.isEmpty() && nums[min.peekLast()] > nums[right]) {
                min.pollLast();
            }
            min.addLast(right);
            while (!max.isEmpty() && nums[max.peekLast()] < nums[right]) {
                max.pollLast();
            }
            max.addLast(right);
            right++;
            if (nums[max.peekFirst()] - nums[min.peekFirst()] <= limit) {
                len = Math.max(len, right - left);
            }
            while (!max.isEmpty() && !min.isEmpty() && (nums[max.peekFirst()] - nums[min.peekFirst()] > limit)) {
                if (max.peekFirst() == left) {
                    max.pollFirst();
                }
                if (min.peekFirst() == left) {
                    min.pollFirst();
                }
                left++;
            }
            len = Math.max(len, right - left);
        }

        return len;
    }

    public static void main(String[] args) {
        LongestSubarrayII solution = new LongestSubarrayII();
        int[] nums = new int[]{8, 2, 4, 7};
        Assert.assertEquals(2, solution.longestSubarray(nums, 4));
        nums = new int[]{10, 1, 2, 4, 7, 2};
        Assert.assertEquals(4, solution.longestSubarray(nums, 5));
        nums = new int[]{4, 2, 2, 2, 4, 4, 2, 2};
        Assert.assertEquals(3, solution.longestSubarray(nums, 0));
    }
}
