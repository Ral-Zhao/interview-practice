package questions.offer;

/**
 *  题目51 数组中的逆序对
 *
 *  在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
 *  输入一个数组，求出这个数组中的逆序对的总数。
 *  例如，在数组{7,5,6,4}中，一共存在5个逆序对，分别为(7,6)、(7,5)、(7,4)、(6,4)和(5,4)。
 *
 */
public class InversePairs {
    public static int getInverseCount(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        return count(nums, 0, nums.length - 1);
    }

    private static int count(int[] nums, int start, int end) {
        if (start == end) {
            return 0;
        }
        int mid = start + (end - start) / 2;
        int left = count(nums, start, mid);
        int right = count(nums, mid + 1, end);
        int[] copy = new int[end - start + 1];
        int count = 0;
        int index = copy.length - 1;
        int i = mid;
        int j = end;
        while (i >= start && j >= mid + 1) {
            if (nums[i] > nums[j]) {
                count += j - mid;
                copy[index--] = nums[i--];
            } else {
                copy[index--] = nums[j--];
            }
        }
        while (i >= start) {
            copy[index--] = nums[i--];
        }
        while (j >= mid + 1) {
            copy[index--] = nums[j--];
        }
        index = 0;
        for (int k = start; k <= end; k++) {
            nums[k] = copy[index++];
        }
        return left + right + count;
    }
}
