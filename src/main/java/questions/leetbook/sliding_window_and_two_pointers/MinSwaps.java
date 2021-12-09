package questions.leetbook.sliding_window_and_two_pointers;

import org.junit.Assert;

/**
 * 给出一个二进制数组 data，你需要通过交换位置，将数组中 任何位置 上的 1 组合到一起，并返回所有可能中所需 最少的交换次数。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：[1,0,1,0,1]
 * 输出：1
 * 解释：
 * 有三种可能的方法可以把所有的 1 组合在一起：
 * [1,1,1,0,0]，交换 1 次；
 * [0,1,1,1,0]，交换 2 次；
 * [0,0,1,1,1]，交换 1 次。
 * 所以最少的交换次数为 1。
 * 示例 2：
 * <p>
 * 输入：[0,0,0,1,0]
 * 输出：0
 * 解释：
 * 由于数组中只有一个 1，所以不需要交换。
 * 示例 3：
 * <p>
 * 输入：[1,0,1,0,1,0,0,1,1,0,1]
 * 输出：3
 * 解释：
 * 交换 3 次，一种可行的只用 3 次交换的解决方案是 [0,0,0,0,0,1,1,1,1,1,1]。
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= data.length <= 10^5
 * 0 <= data[i] <= 1
 * <p>
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/sliding-window-and-two-pointers/ri0xd3/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class MinSwaps {
    public int minSwaps(int[] data) {
        int oneNum = 0;
        for (int num : data) {
            if (num == 1) {
                oneNum++;
            }
        }
        if (oneNum <= 1) {
            return 0;
        }
        int innerOne = 0;
        int min = oneNum;
        int left = 0;
        int right = 0;
        while (right < data.length) {
            while (right < data.length && right - left < oneNum) {
                if (data[right] == 1) {
                    innerOne++;
                }
                right++;
            }
            min = Math.min(min, oneNum - innerOne);
            if (data[left] == 1) {
                innerOne--;
            }
            left++;
        }
        return min;
    }

    public static void main(String[] args) {
        MinSwaps solution = new MinSwaps();
        int[] data = new int[]{1, 0, 1, 0, 1};
        Assert.assertEquals(1, solution.minSwaps(data));
        data = new int[]{1, 0, 1, 0, 1, 0, 0, 1, 1, 0, 1};
        Assert.assertEquals(3, solution.minSwaps(data));
    }
}
