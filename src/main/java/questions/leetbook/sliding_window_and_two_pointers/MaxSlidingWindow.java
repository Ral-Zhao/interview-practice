package questions.leetbook.sliding_window_and_two_pointers;

import com.alibaba.fastjson.JSON;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 * <p>
 * 返回滑动窗口中的最大值。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
 * 输出：[3,3,5,5,6,7]
 * 解释：
 * 滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 * 1 [3  -1  -3] 5  3  6  7       3
 * 1  3 [-1  -3  5] 3  6  7       5
 * 1  3  -1 [-3  5  3] 6  7       5
 * 1  3  -1  -3 [5  3  6] 7       6
 * 1  3  -1  -3  5 [3  6  7]      7
 * 示例 2：
 * <p>
 * 输入：nums = [1], k = 1
 * 输出：[1]
 * 示例 3：
 * <p>
 * 输入：nums = [1,-1], k = 1
 * 输出：[1,-1]
 * 示例 4：
 * <p>
 * 输入：nums = [9,11], k = 2
 * 输出：[11]
 * 示例 5：
 * <p>
 * 输入：nums = [4,-2], k = 2
 * 输出：[4]
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 10^5
 * -10^4 <= nums[i] <= 10^4
 * 1 <= k <= nums.length
 * <p>
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/sliding-window-and-two-pointers/rurimj/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class MaxSlidingWindow {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deque = new ArrayDeque<>();
        int index = 0;
        int[] result = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length; i++) {
            while (!deque.isEmpty() && nums[i] > deque.peekLast()) {
                deque.pollLast();
            }
            deque.addLast(nums[i]);
            if (i < k - 1) {
                continue;
            }
            if (i >= k && deque.peekFirst() == nums[i - k]) {
                deque.pollFirst();
            }
            result[index++] = deque.peekFirst();
        }
        return result;
    }

    public static void main(String[] args) {
        MaxSlidingWindow solution = new MaxSlidingWindow();
        int[] nums = new int[]{1, 3, -1, -3, 5, 3, 6, 7};
        int[] result = solution.maxSlidingWindow(nums, 3);
        System.out.println(JSON.toJSONString(result));
        nums = new int[]{1};
        result = solution.maxSlidingWindow(nums, 1);
        System.out.println(JSON.toJSONString(result));
        nums = new int[]{1, -1};
        result = solution.maxSlidingWindow(nums, 1);
        System.out.println(JSON.toJSONString(result));
        nums = new int[]{9, 11};
        result = solution.maxSlidingWindow(nums, 2);
        System.out.println(JSON.toJSONString(result));
    }
}
