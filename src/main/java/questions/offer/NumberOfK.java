package questions.offer;

/**
 *  题目53-1 在排序数组中查找数字
 *
 *  统计一个数字在排序数组中出现的次数。例如，输入排序数组{1，2，3，3，3，3，4，5}和数字3，
 *  由于3在这个数组中出现了4次，因此输出4.
 */
public class NumberOfK {
    public static int getNumber(int[] nums, int k) {
        if (nums == null || nums.length < 1 || k < nums[0] || k > nums[nums.length - 1]) {
            return 0;
        }
        int left = getFirstIndex(nums, k);
        int right = getLastIndex(nums, k);
        if (left == -1 || right == -1) {
            return 0;
        }

        return right - left + 1;
    }

    private static int getFirstIndex(int[] nums, int k) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == k) {
                right = mid - 1;
            } else if (nums[mid] > k) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        if (left > nums.length - 1 || nums[left] != k) {
            return -1;
        }
        return left;
    }

    private static int getLastIndex(int[] nums, int k) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == k) {
                left = mid + 1;
            } else if (nums[mid] > k) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        if (right < 0 || nums[right] != k) {
            return -1;
        }
        return right;
    }
}
