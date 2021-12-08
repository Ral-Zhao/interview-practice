package questions.leetbook.sliding_window_and_two_pointers;

import org.junit.Assert;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 在仅包含 0 和 1 的数组 A 中，一次 K 位翻转包括选择一个长度为 K 的（连续）子数组，同时将子数组中的每个 0 更改为 1，而每个 1 更改为 0。
 * <p>
 * 返回所需的 K 位翻转的最小次数，以便数组没有值为 0 的元素。如果不可能，返回 -1。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：A = [0,1,0], K = 1
 * 输出：2
 * 解释：先翻转 A[0]，然后翻转 A[2]。
 * 示例 2：
 * <p>
 * 输入：A = [1,1,0], K = 2
 * 输出：-1
 * 解释：无论我们怎样翻转大小为 2 的子数组，我们都不能使数组变为 [1,1,1]。
 * 示例 3：
 * <p>
 * 输入：A = [0,0,0,1,0,1,1,0], K = 3
 * 输出：3
 * 解释：
 * 翻转 A[0],A[1],A[2]: A变成 [1,1,1,1,0,1,1,0]
 * 翻转 A[4],A[5],A[6]: A变成 [1,1,1,1,1,0,0,0]
 * 翻转 A[5],A[6],A[7]: A变成 [1,1,1,1,1,1,1,1]
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= A.length <= 30000
 * 1 <= K <= A.length
 * <p>
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/sliding-window-and-two-pointers/riv2is/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class MinKBitFlips {
    public int minKBitFlips(int[] nums, int k) {
        int res = 0;
        Deque<Integer> que = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            if (que.size() > 0 && i > que.peek() + k - 1) {
                que.removeFirst();
            }
            //1.本来是1，翻转奇数次变为0，所以需要再次翻转，放入队列
            //2.本来是0，翻转偶数次还是0，所以需要再次翻转，放入队列
            if (que.size() % 2 == nums[i]) {
                if (i + k > nums.length) return -1;
                que.add(i);
                res += 1;
            }
        }
        return res;
    }

    public int method_2(int[] nums, int k) {
        int n = nums.length;
        int ans = 0, revCnt = 0;
        for (int i = 0; i < n; ++i) {
            if (i >= k && nums[i - k] > 1) {
                revCnt ^= 1;
                nums[i - k] -= 2; // 复原数组元素，若允许修改数组 nums，则可以省略
            }
            if (nums[i] == revCnt) {
                if (i + k > n) {
                    return -1;
                }
                ++ans;
                revCnt ^= 1;
                nums[i] += 2;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        MinKBitFlips solution = new MinKBitFlips();
        int[] nums = new int[]{0, 1, 0};
        Assert.assertEquals(2, solution.minKBitFlips(nums, 1));
        nums = new int[]{1, 1, 0};
        Assert.assertEquals(-1, solution.minKBitFlips(nums, 2));
        nums = new int[]{0, 0, 0, 1, 0, 1, 1, 0};
        Assert.assertEquals(3, solution.minKBitFlips(nums, 3));
        nums = new int[]{0, 1, 0, 1, 1};
        Assert.assertEquals(2, solution.minKBitFlips(nums, 2));
    }
}
