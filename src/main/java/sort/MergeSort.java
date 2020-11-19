package sort;

/**
 * 归并排序
 */
public class MergeSort {
    public static void sort(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        sort(nums, 0, nums.length - 1);
    }

    private static void sort(int[] nums, int start, int end) {
        if (start == end) {
            return;
        }
        int mid = start + (end - start) / 2;
        sort(nums, start, mid);
        sort(nums, mid + 1, end);
        merge(nums, start, end, mid);
    }

    private static void merge(int[] nums, int start, int end, int mid) {
        int[] temp = new int[end - start + 1];
        int index = 0;
        int i = start;
        int j = mid + 1;
        while (i <= mid && j <= end) {
            temp[index++] = nums[i] < nums[j] ? nums[i++] : nums[j++];
        }
        while (i <= mid) {
            temp[index++] = nums[i++];
        }
        while (j <= end) {
            temp[index++] = nums[j++];
        }
        index = 0;
        for (int k = start; k <= end; k++) {
            nums[k] = temp[index++];
        }
    }
}
