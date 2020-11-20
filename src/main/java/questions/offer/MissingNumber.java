package questions.offer;

/**
 *  题目53-2 0~n-1中缺失的数字
 *
 *  一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0~n-1之内。
 *  在范围0~n-1内的n个数字中有且只有一个数字不在数组中，请找出这个数字。
 */
public class MissingNumber {
    public static int missingNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == mid) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return right + 1;
    }
}
