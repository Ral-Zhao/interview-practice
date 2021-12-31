package questions.leetbook.sliding_window_and_two_pointers;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个已经 排好序 的整数数组 nums 和整数 a、b、c。
 * 对于数组中的每一个数 x，计算函数值 f(x) = ax2 + bx + c，请将函数值产生的数组返回。
 * <p>
 * 要注意，返回的这个数组必须按照 升序排列，并且我们所期望的解法时间复杂度为 O(n)。
 * <p>
 * 示例 1：
 * <p>
 * 输入: nums = [-4,-2,2,4], a = 1, b = 3, c = 5
 * 输出: [3,9,15,33]
 * 示例 2：
 * <p>
 * 输入: nums = [-4,-2,2,4], a = -1, b = 3, c = 5
 * 输出: [-23,-5,1,7]
 * <p>
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/sliding-window-and-two-pointers/rwpvnv/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class SortTransformedArray {
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        int[] result = new int[nums.length];
        if (a == 0) {
            for (int i = 0; i < nums.length; i++) {
                result[i] = b * nums[i] + c;
            }
        } else {
            double target = -(b / (2.0 * a));
            int left = 0;
            int right = nums.length;
            while (left < right) {
                int mid = (left + right) / 2;
                if (nums[mid] == target) {
                    left = mid;
                    break;
                } else if (nums[mid] < target) {
                    left = mid+1;
                } else {
                    right = mid;
                }
            }
            if (left == right) {
                left--;
            }
            right = left + 1;
            int index = 0;

        }


        return result;
    }
}
