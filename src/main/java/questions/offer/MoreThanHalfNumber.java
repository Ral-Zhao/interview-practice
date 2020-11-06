package questions.offer;

/**
 *  题目39 数组中出现次数超过一半的数字
 *
 *  数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 */
public class MoreThanHalfNumber {
    public static int method1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int mid = nums.length / 2;
        int start = 0;
        int end = nums.length - 1;
        int index = partition(nums, start, end);
        while (index != mid) {
            if (index <= mid) {
                start = index + 1;
                index = partition(nums, start, end);
            } else {
                end = index - 1;
                index = partition(nums, start, end);
            }
        }
        int result = nums[index];
        int count = 0;
        for (int num : nums) {
            if (num == result) {
                count++;
            }
        }
        result = count * 2 > nums.length ? result : 0;
        return result;
    }

    private static int partition(int[] nums, int start, int end) {
        int target = nums[start];
        int index = start;
        while (start < end) {
            if (nums[start] <= target) {
                start++;
            } else if (nums[end] > target) {
                end--;
            } else {
                int temp = nums[start];
                nums[start] = nums[end];
                nums[end] = temp;
                start++;
                end--;
            }
        }
        nums[index] = nums[start];
        nums[start] = target;
        return start;
    }

    public static int method2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int result = nums[0];
        int times = 1;
        for (int i = 1; i < nums.length; i++) {
            if (times == 0) {
                result = nums[i];
                times = 1;
            } else if (nums[i] == result) {
                times++;
            } else {
                times--;
            }
        }
        int count = 0;
        for (int num : nums) {
            if (num == result) {
                count++;
            }
        }
        result = count * 2 > nums.length ? result : 0;
        return result;
    }

}
