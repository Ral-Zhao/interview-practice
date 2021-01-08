package sort;

/**
 *  快速排序
 */
public class QuickSort {
    public static void sort(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        sort(nums, 0, nums.length - 1);
    }

    private static void sort(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }
        int index = getIndex(nums, start, end);
        sort(nums, start, index - 1);
        sort(nums, index + 1, end);
    }

    private static int getIndex(int[] nums, int start, int end) {
        int temp = nums[start];
        while (start < end) {
            while (start < end && nums[end] > temp) {
                end--;
            }
            if (start < end) {
                nums[start] = nums[end];
            }
            while (start < end && nums[start] < temp) {
                start++;
            }
            if (start < end) {
                nums[end] = nums[start];
            }
        }
        nums[start] = temp;
        return start;
    }
}
