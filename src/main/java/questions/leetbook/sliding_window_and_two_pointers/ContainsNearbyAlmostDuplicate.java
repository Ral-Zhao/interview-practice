package questions.leetbook.sliding_window_and_two_pointers;

import org.junit.Assert;

import java.util.*;

/**
 * 给你一个整数数组 nums 和两个整数 k 和 t 。请你判断是否存在 两个不同下标 i 和 j，使得 abs(nums[i] - nums[j]) <= t ，同时又满足 abs(i - j) <= k 。
 * <p>
 * 如果存在则返回 true，不存在返回 false。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3,1], k = 3, t = 0
 * 输出：true
 * 示例 2：
 * <p>
 * 输入：nums = [1,0,1,1], k = 1, t = 2
 * 输出：true
 * 示例 3：
 * <p>
 * 输入：nums = [1,5,9,1,5,9], k = 2, t = 3
 * 输出：false
 *  
 * <p>
 * 提示：
 * <p>
 * 0 <= nums.length <= 2 * 10^4
 * -2^31 <= nums[i] <= 2^31 - 1
 * 0 <= k <= 10^4
 * 0 <= t <= 2^31 - 1
 * <p>
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/sliding-window-and-two-pointers/rumvrr/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class ContainsNearbyAlmostDuplicate {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        List<int[]> pairs = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int[] pair = new int[]{i, nums[i]};
            pairs.add(pair);
        }
        Collections.sort(pairs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[1], o2[1]);
            }
        });
        int left = 0;
        int right = 1;
        while (right < nums.length) {
            List<Integer> positions = new ArrayList<>();
            while (right < nums.length && (long) pairs.get(right)[1] - (long) pairs.get(left)[1] <= t) {
                positions.add(pairs.get(right)[0]);
                right++;
            }
            positions.add(pairs.get(left)[0]);
            Collections.sort(positions);
            int l = 0;
            for (int i = 1; i < positions.size(); i++) {
                if (positions.get(i) - positions.get(l) <= k) {
                    return true;
                }
                while (l < i && positions.get(i) - positions.get(l) > k) {
                    l++;
                }
            }

            left++;
            right = left + 1;
        }
        return false;
    }

    public boolean method_2(int[] nums, int k, int t) {
        int n = nums.length;
        TreeSet<Long> ts = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            Long u = nums[i] * 1L;
            // 从 ts 中找到小于等于 u 的最大值（小于等于 u 的最接近 u 的数）
            Long l = ts.floor(u);
            // 从 ts 中找到大于等于 u 的最小值（大于等于 u 的最接近 u 的数）
            Long r = ts.ceiling(u);
            if (l != null && u - l <= t) return true;
            if (r != null && r - u <= t) return true;
            // 将当前数加到 ts 中，并移除下标范围不在 [max(0, i - k), i) 的数（维持滑动窗口大小为 k）
            ts.add(u);
            if (i >= k) ts.remove(nums[i - k] * 1L);
        }
        return false;
    }

    /*
        利用桶排序 https://leetcode-cn.com/problems/contains-duplicate-iii/solution/gong-shui-san-xie-yi-ti-shuang-jie-hua-d-dlnv/
     */
    private long size;

    public boolean method_3(int[] nums, int k, int t) {
        int n = nums.length;
        Map<Long, Long> map = new HashMap<>();
        size = t + 1L;
        for (int i = 0; i < n; i++) {
            long u = nums[i] * 1L;
            long idx = getIdx(u);
            // 目标桶已存在（桶不为空），说明前面已有 [u - t, u + t] 范围的数字
            if (map.containsKey(idx)) return true;
            // 检查相邻的桶
            long l = idx - 1, r = idx + 1;
            if (map.containsKey(l) && u - map.get(l) <= t) return true;
            if (map.containsKey(r) && map.get(r) - u <= t) return true;
            // 建立目标桶
            map.put(idx, u);
            // 移除下标范围不在 [max(0, i - k), i) 内的桶
            if (i >= k) map.remove(getIdx(nums[i - k] * 1L));
        }
        return false;
    }

    long getIdx(long u) {
        return u >= 0 ? u / size : ((u + 1) / size) - 1;
    }


    public static void main(String[] args) {
        ContainsNearbyAlmostDuplicate solution = new ContainsNearbyAlmostDuplicate();
        int[] nums = new int[]{1, 2, 3, 1};
        Assert.assertTrue(solution.containsNearbyAlmostDuplicate(nums, 3, 0));
        nums = new int[]{1, 0, 1, 1};
        Assert.assertTrue(solution.containsNearbyAlmostDuplicate(nums, 1, 2));
        nums = new int[]{1, 5, 9, 1, 5, 9};
        Assert.assertTrue(!solution.containsNearbyAlmostDuplicate(nums, 2, 3));
        nums = new int[]{-2147483648, 2147483647};
        Assert.assertTrue(!solution.containsNearbyAlmostDuplicate(nums, 1, 1));
        nums = new int[]{1, 2, 5, 6, 7, 2, 4};
        Assert.assertTrue(solution.containsNearbyAlmostDuplicate(nums, 4, 0));
    }
}
