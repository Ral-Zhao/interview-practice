package questions.offer;

/**
 *  题目53-3 数组中数值和下标相等的元素
 *
 *  假设一个单调递增的数组里的每个元素都是整数并且是唯一的。
 *  请写一个方法，找出数组中任意一个数值等于其下标的元素。
 *  例如，在数组{-3,-1,1,3,5}中，数字3和它的下标相等。
 */
public class IntegerIdenticalToIndex {
    public static int getNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (mid == nums[mid]) {
                return mid;
            } else if (mid > nums[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
