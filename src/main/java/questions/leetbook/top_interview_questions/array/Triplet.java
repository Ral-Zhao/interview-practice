package questions.leetbook.top_interview_questions.array;

import org.junit.Assert;

/**
 * 给你一个整数数组 nums ，判断这个数组中是否存在长度为 3 的递增子序列。
 * <p>
 * 如果存在这样的三元组下标 (i, j, k) 且满足 i < j < k ，使得 nums[i] < nums[j] < nums[k] ，返回 true ；否则，返回 false 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3,4,5]
 * 输出：true
 * 解释：任何 i < j < k 的三元组都满足题意
 * 示例 2：
 * <p>
 * 输入：nums = [5,4,3,2,1]
 * 输出：false
 * 解释：不存在满足题意的三元组
 * 示例 3：
 * <p>
 * 输入：nums = [2,1,5,0,4,6]
 * 输出：true
 * 解释：三元组 (3, 4, 5) 满足题意，因为 nums[3] == 0 < nums[4] == 4 < nums[5] == 6
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 10^5
 * -2^31 <= nums[i] <= 2^31 - 1
 *  
 * <p>
 * 进阶：你能实现时间复杂度为 O(n) ，空间复杂度为 O(1) 的解决方案吗？
 * <p>
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions/xmb141/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class Triplet {
    public boolean increasingTriplet(int[] nums) {
        if (nums.length < 3) {
            return false;
        }
        int flag = nums[0];
        boolean[] greater = new boolean[nums.length];
        greater[0] = false;
        for (int i = 1; i < nums.length; i++) {
            greater[i] = nums[i] > flag;
            flag = Math.min(flag, nums[i]);
        }
        flag = nums[nums.length - 1];
        boolean[] less = new boolean[nums.length];
        less[nums.length - 1] = false;
        for (int i = nums.length - 2; i >= 0; i--) {
            less[i] = nums[i] < flag;
            flag = Math.max(flag, nums[i]);
        }
        for (int i = 0; i < nums.length; i++) {
            if (less[i] && greater[i]) {
                return true;
            }
        }
        return false;
    }

    public boolean increasingTriplet_2(int[] nums) {
        // 时间：O(N), 空间O(1)
        int small = Integer.MAX_VALUE, mid = Integer.MAX_VALUE;
        for (int num: nums) {
            if (small >= num) small = num;
                // 进入到mid的语句块意味着 small < num <= mid;
            else if (mid >= num) mid = num;
                // 进入到return语句块意味着 num > mid, num > samll
                // 要注意small和mid初始值都是int的最大值，能进入到return语句块，意味着，此刻small和mid
                // 都已经发生过赋值了，一旦赋值过，肯定满足 mid > small，因此直接返回true即可。
            else return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Triplet solution = new Triplet();
        int[] nums = new int[]{1, 2, 3, 4, 5};
        Assert.assertTrue(solution.increasingTriplet(nums));
        nums = new int[]{5, 4, 3, 2, 1};
        Assert.assertTrue(!solution.increasingTriplet(nums));
        nums = new int[]{2, 1, 5, 0, 4, 6};
        Assert.assertTrue(solution.increasingTriplet(nums));
    }
}
