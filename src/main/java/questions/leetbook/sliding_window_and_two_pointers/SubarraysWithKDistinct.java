package questions.leetbook.sliding_window_and_two_pointers;

import org.junit.Assert;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个正整数数组 A，如果 A 的某个子数组中不同整数的个数恰好为 K，则称 A 的这个连续、不一定不同的子数组为好子数组。
 * <p>
 * （例如，[1,2,3,1,2] 中有 3 个不同的整数：1，2，以及 3。）
 * <p>
 * 返回 A 中好子数组的数目。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：A = [1,2,1,2,3], K = 2
 * 输出：7
 * 解释：恰好由 2 个不同整数组成的子数组：[1,2], [2,1], [1,2], [2,3], [1,2,1], [2,1,2], [1,2,1,2].
 * 示例 2：
 * <p>
 * 输入：A = [1,2,1,3,4], K = 3
 * 输出：3
 * 解释：恰好由 3 个不同整数组成的子数组：[1,2,1,3], [2,1,3], [1,3,4].
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= A.length <= 20000
 * 1 <= A[i] <= A.length
 * 1 <= K <= A.length
 * <p>
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/sliding-window-and-two-pointers/riq25e/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class SubarraysWithKDistinct {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return atMost(nums, k) - atMost(nums, k - 1);
    }

    private int atMost(int[] nums, int k) {
        if (nums == null || nums.length == 0) return 0;
        int n = nums.length;

        Map<Integer, Integer> map = new HashMap<>();
        int cnt = 0;
        int left = 0;
        for (int i = 0; i < n; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            while (map.size() > k) {
                map.put(nums[left], map.get(nums[left]) - 1);
                if (map.get(nums[left]) == 0) map.remove(nums[left]); // 用哈希表的话需要删除频次为0的元素
                left++;
            }
            // 窗口个数计算：窗口[left, i]符合要求的话，
            // 以它的每个元素为起点的子窗口也符合要求，那么窗口个数一共 i - left + 1个。
            cnt += i - left + 1;
        }
        return cnt;
    }

    public static void main(String[] args) {
        SubarraysWithKDistinct solution = new SubarraysWithKDistinct();
        int[] nums = new int[]{1, 2, 1, 2, 3};
        Assert.assertEquals(7, solution.subarraysWithKDistinct(nums, 2));
        nums = new int[]{1, 2, 1, 3, 4};
        Assert.assertEquals(3, solution.subarraysWithKDistinct(nums, 3));
    }
}
