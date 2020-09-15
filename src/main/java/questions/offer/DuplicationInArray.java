package questions.offer;

/**
 * 题目3 数组中的重复数字
 */
public class DuplicationInArray {

    /**
     * 在一个长度为n的数组中，所有数字都在[0,n-1]的范围内。
     * 数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。
     * 请找出数组中任意一个重复的数字。
     * <p>
     * 如，输入长度为7的数组{2,3,1,0,2,5,3}, 输出为2或3.
     */
    public static int duplicate(int[] nums) {
        int i = 0;
        //循环直到所有数字都在其所表示的下标中，或存在两个相同的数字
        while (i < nums.length) {
            int curValue = nums[i];
            if (curValue != i) {
                int nextValue = nums[curValue];
                //找到重复的元素
                if (curValue == nextValue) {
                    return curValue;
                }
                //交换当前的元素到其正确的下标下
                nums[i] = nextValue;
                nums[curValue] = curValue;

            } else {
                //只有当前元素找到了相应的下标才更新i
                i++;
            }
        }
        return -1;
    }

    /**
     * 不修改数组找出重复数字
     * <p>
     * 在一个长度为n+1的数组中，所有数字都在[1,n]的范围内。
     * 数组中至少有一个数字是重复的。
     * 请找出数组中任意一个重复的数字，但不能修改数组。
     * <p>
     * 如，输入长度为7的数组{2,3,5,4,3,2,6,7}, 输出为2或3.
     */
    public static int duplicate2(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = (end - start) / 2 + start;
            int count = countNumber(nums, start + 1, mid + 1);
            if (start == end && count > 1) {
                return start + 1;
            }
            if (mid - start + 1 < count) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }

    private static int countNumber(int[] nums, int min, int max) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= min && nums[i] <= max) {
                count++;
            }
        }
        return count;
    }
}
