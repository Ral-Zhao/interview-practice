package questions.leetbook.dp.single_sequence.rob;

import org.junit.Assert;

/**
 * 给你一个整数数组 nums ，你可以对它进行一些操作。
 * <p>
 * 每次操作中，选择任意一个 nums[i] ，删除它并获得 nums[i] 的点数。
 * 之后，你必须删除 所有 等于 nums[i] - 1 和 nums[i] + 1 的元素。
 * <p>
 * 开始你拥有 0 个点数。返回你能通过这些操作获得的最大点数。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [3,4,2]
 * 输出：6
 * 解释：
 * 删除 4 获得 4 个点数，因此 3 也被删除。
 * 之后，删除 2 获得 2 个点数。总共获得 6 个点数。
 * 示例 2：
 * <p>
 * 输入：nums = [2,2,3,3,3,4]
 * 输出：9
 * 解释：
 * 删除 3 获得 3 个点数，接着要删除两个 2 和 4 。
 * 之后，再次删除 3 获得 3 个点数，再次删除 3 获得 3 个点数。
 * 总共获得 9 个点数。
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 2 * 10^4
 * 1 <= nums[i] <= 10^4
 * <p>
 * 作者：FennelDumplings
 * 链接：https://leetcode-cn.com/leetbook/read/dynamic-programming-1-plus/5r0kh6/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class DeleteAndEarn {
    public int deleteAndEarn(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int max = 0;
        for (int n : nums) {
            max = Math.max(max, n);
        }
        int[] arr = new int[max + 1];
        for (int i = 0; i < nums.length; i++) {
            arr[nums[i]] += nums[i];
        }
        if (arr.length == 2) {
            return Math.max(arr[0], arr[1]);
        }
        int first = arr[0];
        int second = Math.max(arr[0], arr[1]);
        for (int i = 2; i < arr.length; i++) {
            int temp = second;
            second = Math.max(second, first + arr[i]);
            first = temp;
        }
        return second;
    }

    public static void main(String[] args) {
        DeleteAndEarn solution = new DeleteAndEarn();
        int[] nums = new int[]{3, 4, 2};
        Assert.assertEquals(6, solution.deleteAndEarn(nums));
        nums = new int[]{2, 2, 3, 3, 3, 4};
        Assert.assertEquals(9, solution.deleteAndEarn(nums));
    }
}
