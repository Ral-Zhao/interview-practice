package questions.offer;

import java.util.ArrayList;
import java.util.List;

/**
 *  题目57-1 和为s的两个数字
 *
 *  输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。
 *  如果有多对数字和等于s，则输出任意一对即可。
 */
public class TwoNumbersWithSum {
    public static List<Integer> getNumbers(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return null;
        }
        int left = 0;
        int right = nums.length - 1;
        List<Integer> result = null;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == target) {
                result = new ArrayList<>();
                result.add(nums[left]);
                result.add(nums[right]);
                break;
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return result;
    }
}
