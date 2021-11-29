package questions.leetbook.sort;

import org.junit.Assert;

/**
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
 * 输入一个数组，求出这个数组中的逆序对的总数。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: [7,5,6,4]
 * 输出: 5
 *  
 * <p>
 * 限制：
 * <p>
 * 0 <= 数组长度 <= 50000
 * <p>
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/sort-algorithms/etdd3m/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class ReversePairs {
    private int count;

    public int reversePairs(int[] nums) {
        this.count = 0;
        if (nums == null || nums.length == 0) {
            return 0;
        }
        sort(nums, 0, nums.length - 1, new int[nums.length]);
        return count;
    }

    private void sort(int[] nums, int start, int end, int[] temp) {
        if (start == end) {
            return;
        }
        int mid = start + (end - start) / 2;
        sort(nums, start, mid, temp);
        sort(nums, mid + 1, end, temp);
        merge(nums, start, mid, end, temp);
    }

    private void merge(int[] nums, int start, int mid, int end, int[] temp) {
        int start1 = start;
        int start2 = mid + 1;
        int index = 0;
        while (start1 <= mid && start2 <= end) {
            if (nums[start1] <= nums[start2]) {
                temp[index++] = nums[start1++];
            } else {
                temp[index++] = nums[start2++];
                count += (mid - start1 + 1);
            }
        }
        while (start1 <= mid) {
            temp[index++] = nums[start1++];
        }
        while (start2 <= end) {
            temp[index++] = nums[start2++];
        }
        index = 0;
        for (int i = start; i <= end; i++) {
            nums[i] = temp[index++];
        }
    }

    public static void main(String[] args) {
        ReversePairs solution = new ReversePairs();
        int[] nums = new int[]{7, 5, 6, 4};
        Assert.assertEquals(5, solution.reversePairs(nums));
        nums = new int[]{1, 3, 2, 3, 1};
        Assert.assertEquals(4, solution.reversePairs(nums));
    }
}
