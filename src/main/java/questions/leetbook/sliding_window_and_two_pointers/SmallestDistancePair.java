package questions.leetbook.sliding_window_and_two_pointers;

import java.util.Arrays;

/**
 * 给定一个整数数组，返回所有数对之间的第 k 个最小距离。一对 (A, B) 的距离被定义为 A 和 B 之间的绝对差值。
 *
 * 示例 1:
 *
 * 输入：
 * nums = [1,3,1]
 * k = 1
 * 输出：0
 * 解释：
 * 所有数对如下：
 * (1,3) -> 2
 * (1,1) -> 0
 * (3,1) -> 2
 * 因此第 1 个最小距离的数对是 (1,1)，它们之间的距离为 0。
 * 提示:
 *
 * 2 <= len(nums) <= 10000.
 * 0 <= nums[i] < 1000000.
 * 1 <= k <= len(nums) * (len(nums) - 1) / 2.
 *
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/sliding-window-and-two-pointers/ri46sd/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class SmallestDistancePair {
    /*
    1、首先对数组nums排序，可以得到最小距离为0，最大距离为nums[-1] - nums[0]，使用二分法在最小和最大距离之间找到符合要求的距离
    2、令left = 0, right = nums[-1] - nums[0]，mid = (left + right) // 2
    3、如果比mid小的距离的数量比k小（get_count(mid) < k），说明当前mid偏小，要增大mid，令left = mid + 1
    4、如果比mid小的距离的数量等于k（get_count(mid) == k），这并不能代表当前mid就是我们想要的结果，
       比如对于nums = [1,3,1]，k = 1，它的距离排序后是 [0,2,2]，如果mid为1，比mid小的距离的数量为1，正好等于 k，
       但显然1并不是最终结果，0才是，所以这种情况mid应该继续减小，令right = mid - 1
    5、如果比mid小的距离的数量比k大（get_count(mid) > k），mid偏大，要减小mid，令right = mid - 1
    6、4和5可以合并，最后返回的是left

     */
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int left = 0, right = nums[n - 1] - nums[0];
        while(left <= right){
            int mid = (left + right) / 2;
            if(getCount(mid, nums) < k){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return left;
    }

    private int getCount(int dis, int[] nums){
        int l = 0, cnt = 0;
        for(int r = 0; r < nums.length; r++){
            while(nums[r] - nums[l] > dis){
                l++;
            }
            cnt += r - l;
        }
        return cnt;
    }
}
