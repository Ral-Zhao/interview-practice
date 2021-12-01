package questions.leetbook.sort;

import org.junit.Assert;

import java.util.Arrays;

/**
 * 给定一个无序的数组，找出数组在排序之后，相邻元素之间最大的差值。
 * <p>
 * 如果数组元素个数小于 2，则返回 0。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [3,6,9,1]
 * 输出: 3
 * 解释: 排序后的数组是 [1,3,6,9], 其中相邻元素 (3,6) 和 (6,9) 之间都存在最大差值 3。
 * 示例 2:
 * <p>
 * 输入: [10]
 * 输出: 0
 * 解释: 数组元素个数小于 2，因此返回 0。
 * 说明:
 * <p>
 * 你可以假设数组中所有元素都是非负整数，且数值在 32 位有符号整数范围内。
 * 请尝试在线性时间复杂度和空间复杂度的条件下解决此问题。
 * <p>
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/sort-algorithms/racnnc/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class MaximumGap {
    public int maximumGap(int[] nums) {
        if (nums.length < 2) {
            return 0;
        }
        int maxLen = 0;
        int max = nums[0];
        for (int num : nums) {
            if (num > max) {
                max = num;
            }
        }
        while (max != 0) {
            maxLen++;
            max = max / 10;
        }
        int div = 1;
        for (int i = 0; i < maxLen; i++) {
            int[] counting = new int[10];
            for (int num : nums) {
                counting[num / div % 10]++;
            }
            int preCount = 0;
            for (int j = 0; j < counting.length; j++) {
                preCount += counting[j];
                counting[j] = preCount - counting[j];
            }
            int[] result = new int[nums.length];
            for (int num : nums) {
                int index = num / div % 10;
                result[counting[index]] = num;
                counting[index]++;
            }
            System.arraycopy(result, 0, nums, 0, nums.length);
            Arrays.fill(counting, 0);
            div *= 10;
        }
        max = 0;
        for (int i = 1; i < nums.length; i++) {
            max = Math.max(max, nums[i] - nums[i - 1]);
        }
        return max;
    }

    public static void main(String[] args) {
        MaximumGap solution = new MaximumGap();
        int[] nums = new int[]{3, 6, 9, 1};
        Assert.assertEquals(3, solution.maximumGap(nums));
        nums = new int[]{100,3,2,1};
        Assert.assertEquals(97, solution.maximumGap(nums));
    }
}
