package questions.leetbook.greedy;

import org.junit.Assert;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 给定一个区间的集合，找到需要移除区间的最小数量，使剩余区间互不重叠。
 * <p>
 * 注意:
 * <p>
 * 可以认为区间的终点总是大于它的起点。
 * 区间 [1,2] 和 [2,3] 的边界相互“接触”，但没有相互重叠。
 * 示例 1:
 * <p>
 * 输入: [ [1,2], [2,3], [3,4], [1,3] ]
 * <p>
 * 输出: 1
 * <p>
 * 解释: 移除 [1,3] 后，剩下的区间没有重叠。
 * 示例 2:
 * <p>
 * 输入: [ [1,2], [1,2], [1,2] ]
 * <p>
 * 输出: 2
 * <p>
 * 解释: 你需要移除两个 [1,2] 来使剩下的区间没有重叠。
 * 示例 3:
 * <p>
 * 输入: [ [1,2], [2,3] ]
 * <p>
 * 输出: 0
 * <p>
 * 解释: 你不需要移除任何区间，因为它们已经是无重叠的了。
 * <p>
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/greedy/rvvp3t/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class OverlapIntervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        int right = intervals[0][1];
        int count = 1;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= right) {
                count++;
                right = intervals[i][1];
            }
        }
        return intervals.length - count;
    }

    public static void main(String[] args) {
        OverlapIntervals solution = new OverlapIntervals();
        int[][] intervals = new int[][]{{1, 2}, {2, 3}, {3, 4}, {1, 3}};
        Assert.assertEquals(1, solution.eraseOverlapIntervals(intervals));
        intervals = new int[][]{{1, 2}, {1, 2}, {1, 2}};
        Assert.assertEquals(2, solution.eraseOverlapIntervals(intervals));
        intervals = new int[][]{{1, 2}, {2, 3}};
        Assert.assertEquals(0, solution.eraseOverlapIntervals(intervals));
    }
}
