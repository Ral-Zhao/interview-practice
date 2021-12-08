package questions.leetbook.sliding_window_and_two_pointers;

import org.junit.Assert;

/**
 * 给定一个二进制数组，你可以最多将 1 个 0 翻转为 1，找出其中最大连续 1 的个数。
 * <p>
 * 示例 1：
 * <p>
 * 输入：[1,0,1,1,0]
 * 输出：4
 * 解释：翻转第一个 0 可以得到最长的连续 1。
 *      当翻转以后，最大连续 1 的个数为 4。
 *  
 * <p>
 * 注：
 * <p>
 * 输入数组只包含 0 和 1.
 * 输入数组的长度为正整数，且不超过 10,000
 *  
 * <p>
 * 进阶：
 * 如果输入的数字是作为 无限流 逐个输入如何处理？换句话说，内存不能存储下所有从流中输入的数字。您可以有效地解决吗？
 * <p>
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/sliding-window-and-two-pointers/rirsze/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class FindMaxConsecutiveOnes {
    public int findMaxConsecutiveOnes(int[] nums) {
        int left = 0;
        int right = 0;
        int zeroNum = 0;
        int max = 0;
        while (right < nums.length) {
            while (right < nums.length && zeroNum < 2) {
                max = Math.max(max, right - left);
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
            max = Math.max(max, right - left);
        }
        return max;
    }

    public static void main(String[] args) {
        FindMaxConsecutiveOnes solution = new FindMaxConsecutiveOnes();
        int[] nums = new int[]{1, 0, 1, 1, 0};
        Assert.assertEquals(4, solution.findMaxConsecutiveOnes(nums));
        nums = new int[]{1, 1, 0, 1};
        Assert.assertEquals(4, solution.findMaxConsecutiveOnes(nums));
    }
}
