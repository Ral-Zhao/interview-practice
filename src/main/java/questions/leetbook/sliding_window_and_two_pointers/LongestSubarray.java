package questions.leetbook.sliding_window_and_two_pointers;

import org.junit.Assert;

/**
 * 给你一个二进制数组 nums ，你需要从中删掉一个元素。
 * <p>
 * 请你在删掉元素的结果数组中，返回最长的且只包含 1 的非空子数组的长度。
 * <p>
 * 如果不存在这样的子数组，请返回 0 。
 * <p>
 *  
 * <p>
 * 提示 1：
 * <p>
 * 输入：nums = [1,1,0,1]
 * 输出：3
 * 解释：删掉位置 2 的数后，[1,1,1] 包含 3 个 1 。
 * 示例 2：
 * <p>
 * 输入：nums = [0,1,1,1,0,1,1,0,1]
 * 输出：5
 * 解释：删掉位置 4 的数字后，[0,1,1,1,1,1,0,1] 的最长全 1 子数组为 [1,1,1,1,1] 。
 * 示例 3：
 * <p>
 * 输入：nums = [1,1,1]
 * 输出：2
 * 解释：你必须要删除一个元素。
 * 示例 4：
 * <p>
 * 输入：nums = [1,1,0,0,1,1,1,0,1]
 * 输出：4
 * 示例 5：
 * <p>
 * 输入：nums = [0,0,0]
 * 输出：0
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 10^5
 * nums[i] 要么是 0 要么是 1 。
 * <p>
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/sliding-window-and-two-pointers/riau3j/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class LongestSubarray {
    public int longestSubarray(int[] nums) {
        int left = 0;
        int right = 0;
        int zeroNum = 0;
        int max = 0;
        while (right < nums.length) {
            while (right < nums.length && zeroNum < 2) {
                max = Math.max(max, right - left - 1);
                if (nums[right] == 0) {
                    zeroNum++;
                }
                right++;
            }
            while (zeroNum >= 2) {
                if (nums[left] == 0) {
                    zeroNum--;
                }
                left++;
            }
            max = Math.max(max, right - left - 1);
        }
        return max;
    }

    public static void main(String[] args) {
        LongestSubarray solution = new LongestSubarray();
        int[] nums = new int[]{1, 1, 0, 1};
        Assert.assertEquals(3, solution.longestSubarray(nums));
        nums = new int[]{0, 1, 1, 1, 0, 1, 1, 0, 1};
        Assert.assertEquals(5, solution.longestSubarray(nums));
        nums = new int[]{1, 1, 1};
        Assert.assertEquals(2, solution.longestSubarray(nums));
        nums = new int[]{1, 1, 0, 0, 1, 1, 1, 0, 1};
        Assert.assertEquals(4, solution.longestSubarray(nums));
        nums = new int[]{0, 0, 0};
        Assert.assertEquals(0, solution.longestSubarray(nums));
    }
}
