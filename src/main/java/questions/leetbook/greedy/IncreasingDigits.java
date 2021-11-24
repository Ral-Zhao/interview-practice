package questions.leetbook.greedy;

import org.junit.Assert;

/**
 * 给定一个非负整数 N，找出小于或等于 N 的最大的整数，同时这个整数需要满足其各个位数上的数字是单调递增。
 * <p>
 * （当且仅当每个相邻位数上的数字 x 和 y 满足 x <= y 时，我们称这个整数是单调递增的。）
 * <p>
 * 示例 1:
 * <p>
 * 输入: N = 10
 * 输出: 9
 * 示例 2:
 * <p>
 * 输入: N = 1234
 * 输出: 1234
 * 示例 3:
 * <p>
 * 输入: N = 332
 * 输出: 299
 * 说明: N 是在 [0, 10^9] 范围内的一个整数。
 * <p>
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/greedy/rvcvsh/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class IncreasingDigits {
    public int monotoneIncreasingDigits(int n) {
        if (n < 10) {
            return n;
        }
        String str = String.valueOf(n);
        int[] nums = new int[str.length()];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = str.charAt(i) - '0';
        }
        int peakIndex = 0;
        int same = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                peakIndex = i;
            } else if (nums[i] < nums[i - 1]) {
                break;
            } else {
                same++;
            }
        }
        if (peakIndex == nums.length - 1 || (peakIndex == 0 && same == nums.length)) {
            return n;
        }
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i < peakIndex) {
                result = result * 10 + nums[i];
            } else if (i == peakIndex) {
                result = result * 10 + nums[i] - 1;
            } else {
                result = result * 10 + 9;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        IncreasingDigits solution = new IncreasingDigits();
        Assert.assertEquals(9, solution.monotoneIncreasingDigits(10));
        Assert.assertEquals(1234, solution.monotoneIncreasingDigits(1234));
        Assert.assertEquals(299, solution.monotoneIncreasingDigits(332));
        Assert.assertEquals(11, solution.monotoneIncreasingDigits(11));
    }
}
