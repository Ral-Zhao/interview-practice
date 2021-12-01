package questions.leetbook.sort;

import org.junit.Assert;

/**
 * 给定长度为 2n 的整数数组 nums ，你的任务是将这些数分成 n 对, 例如 (a1, b1), (a2, b2), ..., (an, bn) ，
 * 使得从 1 到 n 的 min(ai, bi) 总和最大。
 * <p>
 * 返回该 最大总和 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,4,3,2]
 * 输出：4
 * 解释：所有可能的分法（忽略元素顺序）为：
 * 1. (1, 4), (2, 3) -> min(1, 4) + min(2, 3) = 1 + 2 = 3
 * 2. (1, 3), (2, 4) -> min(1, 3) + min(2, 4) = 1 + 2 = 3
 * 3. (1, 2), (3, 4) -> min(1, 2) + min(3, 4) = 1 + 3 = 4
 * 所以最大总和为 4
 * 示例 2：
 * <p>
 * 输入：nums = [6,2,6,5,1,2]
 * 输出：9
 * 解释：最优的分法为 (2, 1), (2, 5), (6, 6). min(2, 1) + min(2, 5) + min(6, 6) = 1 + 2 + 6 = 9
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 10^4
 * nums.length == 2 * n
 * -10^4 <= nums[i] <= 10^4
 * <p>
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/sort-algorithms/rabm2i/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class ArrayPairSum {
    public int arrayPairSum(int[] nums) {
        int max = nums[0];
        for (int num : nums) {
            if (Math.abs(num) > max) {
                max = Math.abs(num);
            }
        }
        int maxLen = 0;
        while (max != 0) {
            maxLen++;
            max = max / 10;
        }
        int div = 1;
        for (int i = 0; i < maxLen; i++) {
            int[] counting = new int[19];
            for (int num : nums) {
                counting[num / div % 10 + 9]++;
            }
            int preCount = 0;
            for (int j = 0; j < counting.length; j++) {
                preCount += counting[j];
                counting[j] = preCount - counting[j];
            }
            int[] result = new int[nums.length];
            for (int num : nums) {
                int index = num / div % 10 + 9;
                result[counting[index]] = num;
                counting[index]++;
            }
            System.arraycopy(result, 0, nums, 0, nums.length);
            div *= 10;
        }
        int sum = 0;
        for (int i = 0; i < nums.length; i += 2) {
            sum += nums[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        ArrayPairSum solution = new ArrayPairSum();
        int[] nums = new int[]{6, 2, 6, 5, 1, 2};
        Assert.assertEquals(9, solution.arrayPairSum(nums));
        nums = new int[]{1, 4, 3, 2};
        Assert.assertEquals(4, solution.arrayPairSum(nums));
        nums = new int[]{0, 3, 2, 6, 6, 3};
        Assert.assertEquals(9, solution.arrayPairSum(nums));
    }
}
