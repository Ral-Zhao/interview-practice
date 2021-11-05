package questions.leetbook.top_interview_questions.sort;

/**
 * 峰值元素是指其值严格大于左右相邻值的元素。
 * <p>
 * 给你一个整数数组 nums，找到峰值元素并返回其索引。数组可能包含多个峰值，在这种情况下，返回 任何一个峰值 所在位置即可。
 * <p>
 * 你可以假设 nums[-1] = nums[n] = -∞ 。
 * <p>
 * 你必须实现时间复杂度为 O(log n) 的算法来解决此问题。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3,1]
 * 输出：2
 * 解释：3 是峰值元素，你的函数应该返回其索引 2。
 * 示例 2：
 * <p>
 * 输入：nums = [1,2,1,3,5,6,4]
 * 输出：1 或 5
 * 解释：你的函数可以返回索引 1，其峰值元素为 2；
 *      或者返回索引 5， 其峰值元素为 6。
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 1000
 * -2^31 <= nums[i] <= 2^31 - 1
 * 对于所有有效的 i 都有 nums[i] != nums[i + 1]
 * <p>
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions/xacqw5/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class PeakElement {
    public int findPeakElement(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = (end + start) / 2;
            if (mid == 0) {
                if (nums[mid + 1] < nums[mid]) {
                    return mid;
                } else {
                    start = mid + 1;
                }
            } else if (mid == nums.length - 1) {
                if (nums[mid - 1] < nums[mid]) {
                    return mid;
                } else {
                    end = mid - 1;
                }
            } else {
                if (nums[mid - 1] < nums[mid] && nums[mid + 1] < nums[mid]) {
                    return mid;
                } else if (nums[mid + 1] >= nums[mid]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        PeakElement solution = new PeakElement();
        int[] nums = new int[]{1, 2, 3, 1};
        System.out.println(solution.findPeakElement(nums));
        nums = new int[]{1, 2, 1, 3, 5, 6, 4};
        System.out.println(solution.findPeakElement(nums));
        nums = new int[]{1, 2, 4};
        System.out.println(solution.findPeakElement(nums));
        nums = new int[]{3, 1, 2, 4, 5};
        System.out.println(solution.findPeakElement(nums));
        nums = new int[]{3, 1, 2};
        System.out.println(solution.findPeakElement(nums));
        nums = new int[]{3, 2};
        System.out.println(solution.findPeakElement(nums));
        nums = new int[]{1, 2};
        System.out.println(solution.findPeakElement(nums));
    }
}
