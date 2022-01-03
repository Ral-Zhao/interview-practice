package questions.leetbook.sliding_window_and_two_pointers;

import org.junit.Assert;

import java.util.Arrays;

/**
 * 给定一个长度为 n 的整数数组和一个目标值 target，寻找能够使条件 nums[i] + nums[j] + nums[k] < target 成立的三元组  i, j, k 个数（0 <= i < j < k < n）。
 * <p>
 * 示例：
 * <p>
 * 输入: nums = [-2,0,1,3], target = 2
 * 输出: 2
 * 解释: 因为一共有两个三元组满足累加和小于 2:
 *      [-2,0,1]
 * [-2,0,3]
 * 进阶：是否能在 O(n2) 的时间复杂度内解决？
 * <p>
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/sliding-window-and-two-pointers/rwr0vg/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class ThreeSumSmaller {
    public int threeSumSmaller(int[] nums, int target) {
        Arrays.sort(nums);
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum >= target) {
                    right--;
                } else {
                    result +=(right-left);
                    left++;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        ThreeSumSmaller solution = new ThreeSumSmaller();
        int[] nums = new int[]{-2, 0, 1, 3};
        //Assert.assertEquals(2, solution.threeSumSmaller(nums, 2));
        nums = new int[]{-1,1,-1,-1};
        //Assert.assertEquals(1, solution.threeSumSmaller(nums, -1));
        nums = new int[]{0,-4,-1,1,-1,2};
        Assert.assertEquals(1, solution.threeSumSmaller(nums, -5));
    }
}
