package questions.leetbook.sliding_window_and_two_pointers;

import org.junit.Assert;

/**
 * 给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
 * <p>
 * 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 * 示例 2:
 * <p>
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 * 输出: 4
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= k <= nums.length <= 104
 * -104 <= nums[i] <= 104
 * <p>
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/sliding-window-and-two-pointers/rlifzm/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class FindKthLargest {
    public int findKthLargest(int[] nums, int k) {
        int target = nums.length - k;
        int left = 0;
        int right = nums.length - 1;
        while (true) {
            int index = getIndex(nums, left, right);
            if (index == target) {
                return nums[index];
            } else if (index < target) {
                left = index + 1;
            } else {
                right = index - 1;
            }
        }
    }


    private int getIndex(int[] nums, int left, int right) {
        int temp = nums[left];
        int l = left;
        left++;
        while (left < right) {
            if (nums[left] <= temp) {
                left++;
            } else {
                swap(nums, left, right);
                right--;
            }
        }
        if (nums[right] > temp) {
            swap(nums, right - 1, l);
            return right - 1;
        } else {
            swap(nums, right, l);
            return right;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        FindKthLargest solution = new FindKthLargest();
        int[] nums = new int[]{3, 2, 1, 5, 6, 4};
        Assert.assertEquals(5, solution.findKthLargest(nums, 2));
        nums = new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6};
        Assert.assertEquals(4, solution.findKthLargest(nums, 4));
    }
}
