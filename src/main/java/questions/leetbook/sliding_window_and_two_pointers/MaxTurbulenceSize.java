package questions.leetbook.sliding_window_and_two_pointers;

import org.junit.Assert;

/**
 * 当 A 的子数组 A[i], A[i+1], ..., A[j] 满足下列条件时，我们称其为湍流子数组：
 * <p>
 * 若 i <= k < j，当 k 为奇数时， A[k] > A[k+1]，且当 k 为偶数时，A[k] < A[k+1]；
 * 或 若 i <= k < j，当 k 为偶数时，A[k] > A[k+1] ，且当 k 为奇数时， A[k] < A[k+1]。
 * 也就是说，如果比较符号在子数组中的每个相邻元素对之间翻转，则该子数组是湍流子数组。
 * <p>
 * 返回 A 的最大湍流子数组的长度。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：[9,4,2,10,7,8,8,1,9]
 * 输出：5
 * 解释：(A[1] > A[2] < A[3] > A[4] < A[5])
 * 示例 2：
 * <p>
 * 输入：[4,8,12,16]
 * 输出：2
 * 示例 3：
 * <p>
 * 输入：[100]
 * 输出：1
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= A.length <= 40000
 * 0 <= A[i] <= 10^9
 * <p>
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/sliding-window-and-two-pointers/rinwtr/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class MaxTurbulenceSize {
    public int maxTurbulenceSize(int[] arr) {
        if (arr.length == 1) {
            return 1;
        }

        int left = 0;
        int right = 1;
        boolean rease = true;
        int max = 1;
        while (right < arr.length) {
            if (arr[right] > arr[right - 1]) {
                if (left == right - 1) {
                    rease = true;
                    max = Math.max(max, 2);
                } else if (rease) {
                    left = right - 1;
                } else {
                    rease = true;
                    max = Math.max(max, right - left + 1);
                }
            } else if (arr[right] < arr[right - 1]) {
                if (left == right - 1) {
                    rease = false;
                    max = Math.max(max, 2);
                } else if (!rease) {
                    left = right - 1;
                } else {
                    rease = false;
                    max = Math.max(max, right - left + 1);
                }
            } else {
                left = right;
            }

            right++;
        }
        return max;
    }

    public static void main(String[] args) {
        MaxTurbulenceSize solution = new MaxTurbulenceSize();
        int[] nums = new int[]{9, 4, 2, 10, 7, 8, 8, 1, 9};
        Assert.assertEquals(5, solution.maxTurbulenceSize(nums));
        nums = new int[]{4, 8, 12, 16};
        Assert.assertEquals(2, solution.maxTurbulenceSize(nums));
        nums = new int[]{9, 9};
        Assert.assertEquals(1, solution.maxTurbulenceSize(nums));
    }
}
