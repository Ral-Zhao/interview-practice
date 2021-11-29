package questions.leetbook.sort;

import org.junit.Assert;

/**
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
 * <p>
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：[3,2,3]
 * 输出：3
 * 示例 2：
 * <p>
 * 输入：[2,2,1,1,1,2,2]
 * 输出：2
 *  
 * <p>
 * 进阶：
 * <p>
 * 尝试设计时间复杂度为 O(n)、空间复杂度为 O(1) 的算法解决此问题。
 * <p>
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/sort-algorithms/et2gzs/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class MajorityElement {
    public int majorityElement(int[] nums) {
        int index = getIndex(nums, 0, nums.length - 1);
        return nums[index];
    }

    private int getIndex(int[] nums, int start, int end) {
        int temp = nums[start];
        int left = start;
        int right = end;
        while (left < right) {
            while (left < right && nums[right] >= temp) {
                right--;
            }
            if (left < right) {
                nums[left] = nums[right];
            }
            while (left < right && nums[left] <= temp) {
                left++;
            }
            if (left < right) {
                nums[right] = nums[left];
            }
        }
        nums[left] = temp;
        if (left == nums.length / 2) {
            return left;
        } else if (left > nums.length / 2) {
            return getIndex(nums, start, left - 1);
        } else {
            return getIndex(nums, left + 1, end);
        }
    }

    public static void main(String[] args) {
        MajorityElement solution = new MajorityElement();
        int[] nums = new int[]{3, 2, 3};
        Assert.assertEquals(3, solution.majorityElement(nums));
        nums = new int[]{2, 2, 1, 1, 1, 2, 2};
        Assert.assertEquals(2, solution.majorityElement(nums));
    }

}
