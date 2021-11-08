package questions.leetbook.top_interview_questions.dp;

import org.junit.Assert;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 * <p>
 * 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [100,4,200,1,3,2]
 * 输出：4
 * 解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
 * 示例 2：
 * <p>
 * 输入：nums = [0,3,7,2,5,8,4,6,0,1]
 * 输出：9
 *  
 * <p>
 * 提示：
 * <p>
 * 0 <= nums.length <= 10^5
 * -10^9 <= nums[i] <= 10^9
 * <p>
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions/x2xmre/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class LongestConsecutive {
    public int longestConsecutive(int[] nums) {
        Set<Integer> num_set = new HashSet<Integer>();
        for (int num : nums) {
            num_set.add(num);
        }

        int longestStreak = 0;

        for (int num : num_set) {
            if (!num_set.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;

                while (num_set.contains(currentNum + 1)) {
                    currentNum += 1;
                    currentStreak += 1;
                }

                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }

        return longestStreak;
    }

    public int method_2(int[] nums) {
        int len = nums.length, res = 0;
        if (len == 0) return res;
        UnionFind unionfind = new UnionFind(len);
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < len; i++) {
            if (map.containsKey(nums[i] + 1)) {
                int index = map.get(nums[i] + 1);
                unionfind.union(i, index);
            }
        }
        for (int i = 0; i < len; i++) {
            res = Math.max(res, nums[unionfind.find(i)] - nums[i]);
        }
        return res + 1;
    }


    class UnionFind {
        int[] parent;

        public UnionFind(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public void union(int i, int j) {
            int parentI = find(i);
            int parentJ = find(j);
            if (parentI == parentJ) return;
            parent[parentI] = parentJ;
        }

        public boolean isConnected(int i, int j) {
            return find(i) == find(j);
        }

        public int find(int i) {
            while (parent[i] != i) {
                parent[i] = parent[parent[i]];
                i = parent[i];
            }
            return parent[i];
        }

    }

    public static void main(String[] args) {
        LongestConsecutive solution = new LongestConsecutive();
        int[] nums = new int[]{100, 4, 200, 1, 3, 2};
        Assert.assertEquals(4, solution.longestConsecutive(nums));
        nums = new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
        Assert.assertEquals(9, solution.method_2(nums));
        Assert.assertEquals(0, solution.longestConsecutive(new int[0]));
    }
}
