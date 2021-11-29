package sort;

/**
 * 快速排序
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
            while (start < end && nums[end] >= temp) {
                end--;
            }
            if (start < end) {
                nums[start] = nums[end];
            }
            while (start < end && nums[start] <= temp) {
                start++;
            }
            if (start < end) {
                nums[end] = nums[start];
            }
        }
        nums[start] = temp;
        return start;
    }

    public static int partition(int[] arr, int start, int end) {
        // 取第一个数为基数
        int pivot = arr[start];
        // 从第二个数开始分区
        int left = start + 1;
        // 右边界
        int right = end;
        // left、right 相遇时退出循环
        while (left < right) {
            // 找到第一个大于基数的位置
            while (left < right && arr[left] <= pivot) left++;
            // 交换这两个数，使得左边分区都小于或等于基数，右边分区大于或等于基数
            if (left != right) {
                exchange(arr, left, right);
                right--;
            }
        }
        // 如果 left 和 right 相等，单独比较 arr[right] 和 pivot
        if (left == right && arr[right] > pivot) right--;
        // 将基数和中间数交换
        if (right != start) exchange(arr, start, right);
        // 返回中间值的下标
        return right;
    }

    private static void exchange(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
