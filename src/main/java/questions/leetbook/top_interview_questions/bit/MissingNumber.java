package questions.leetbook.top_interview_questions.bit;

import org.junit.Assert;

/**
 * 给定一个包含 [0, n] 中 n 个数的数组 nums ，找出 [0, n] 这个范围内没有出现在数组中的那个数。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [3,0,1]
 * 输出：2
 * 解释：n = 3，因为有 3 个数字，所以所有的数字都在范围 [0,3] 内。2 是丢失的数字，因为它没有出现在 nums 中。
 * 示例 2：
 * <p>
 * 输入：nums = [0,1]
 * 输出：2
 * 解释：n = 2，因为有 2 个数字，所以所有的数字都在范围 [0,2] 内。2 是丢失的数字，因为它没有出现在 nums 中。
 * 示例 3：
 * <p>
 * 输入：nums = [9,6,4,2,3,5,7,0,1]
 * 输出：8
 * 解释：n = 9，因为有 9 个数字，所以所有的数字都在范围 [0,9] 内。8 是丢失的数字，因为它没有出现在 nums 中。
 * 示例 4：
 * <p>
 * 输入：nums = [0]
 * 输出：1
 * 解释：n = 1，因为有 1 个数字，所以所有的数字都在范围 [0,1] 内。1 是丢失的数字，因为它没有出现在 nums 中。
 *  
 * <p>
 * 提示：
 * <p>
 * n == nums.length
 * 1 <= n <= 10^4
 * 0 <= nums[i] <= n
 * nums 中的所有数字都 独一无二
 *  
 * <p>
 * 进阶：你能否实现线性时间复杂度、仅使用额外常数空间的算法解决此问题?
 * <p>
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions/x27sii/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class MissingNumber {
    public int missingNumber(int[] nums) {
        int count = 0;
        int n = nums.length;
        for (int i = 0; i < nums.length; i++) {
            count += nums[i];
        }
        return n * (n + 1) / 2 - count;
    }

    public static void main(String[] args) {
        MissingNumber solution = new MissingNumber();
        int[] nums = new int[]{3, 0, 1};
        Assert.assertEquals(2, solution.missingNumber(nums));
        nums = new int[]{0, 1};
        Assert.assertEquals(2, solution.missingNumber(nums));
        nums = new int[]{9, 6, 4, 2, 3, 5, 7, 0, 1};
        Assert.assertEquals(8, solution.missingNumber(nums));
        nums = new int[]{0};
        Assert.assertEquals(1, solution.missingNumber(nums));
    }
}
