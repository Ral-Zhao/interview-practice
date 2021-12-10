package questions.leetbook.sliding_window_and_two_pointers;

import org.junit.Assert;

/**
 * 给定一个元素都是正整数的数组A ，正整数 L 以及 R (L <= R)。
 * <p>
 * 求连续、非空且其中最大元素满足大于等于L 小于等于R的子数组个数。
 * <p>
 * 例如 :
 * 输入:
 * A = [2, 1, 4, 3]
 * L = 2
 * R = 3
 * 输出: 3
 * 解释: 满足条件的子数组: [2], [2, 1], [3].
 * 注意:
 * <p>
 * L, R  和 A[i] 都是整数，范围在 [0, 10^9]。
 * 数组 A 的长度范围在[1, 50000]。
 * <p>
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/sliding-window-and-two-pointers/ri3w9i/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class NumSubarrayBoundedMax {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        int count = 0;
        int index = -1;
        int start = 0;
        int end = 0;
        while (end < nums.length) {
            if (nums[end] >= left && nums[end] <= right) {
                index = end;
            }
            if (nums[end] > right) {
                start = end + 1;
                index = -1;
            }
            if (index != -1) {
                count += index - start + 1;
            }
            end++;
        }

        return count;
    }

    public int method_2(int[] nums, int left, int right) {
        return lessEqualsThan(nums, right) - lessEqualsThan(nums, left - 1);
    }

    private int lessEqualsThan(int[] nums, int k) {
        int len = nums.length;
        int res = 0;
        // 循环不变量：nums[left..right] 里的所有元素都小于等于 k
        for (int left = 0, right = 0; right < len; right++) {
            if (nums[right] > k) {
                left = right + 1;
            }
            res += right - left;
        }
        return res;
    }


    public static void main(String[] args) {
        NumSubarrayBoundedMax solution = new NumSubarrayBoundedMax();
        int[] nums = new int[]{2, 1, 4, 3};
        Assert.assertEquals(3, solution.numSubarrayBoundedMax(nums, 2, 3));
    }
}
