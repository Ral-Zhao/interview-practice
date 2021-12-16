package questions.leetbook.sliding_window_and_two_pointers;

import org.junit.Assert;

import java.util.TreeMap;

/**
 * N 个灯泡排成一行，编号从 1 到 N 。最初，所有灯泡都关闭。每天只打开一个灯泡，直到 N 天后所有灯泡都打开。
 * <p>
 * 给你一个长度为 N 的灯泡数组 blubs ，其中 bulls[i] = x 意味着在第 (i+1) 天，我们会把在位置 x 的灯泡打开，其中 i 从 0 开始，x 从 1 开始。
 * <p>
 * 给你一个整数 K ，请你输出在第几天恰好有两个打开的灯泡，使得它们中间 正好 有 K 个灯泡且这些灯泡 全部是关闭的 。
 * <p>
 * 如果不存在这种情况，返回 -1 。如果有多天都出现这种情况，请返回 最小的天数 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：
 * bulbs: [1,3,2]
 * K: 1
 * 输出：2
 * 解释：
 * 第一天 bulbs[0] = 1，打开第一个灯泡 [1,0,0]
 * 第二天 bulbs[1] = 3，打开第三个灯泡 [1,0,1]
 * 第三天 bulbs[2] = 2，打开第二个灯泡 [1,1,1]
 * 返回2，因为在第二天，两个打开的灯泡之间恰好有一个关闭的灯泡。
 * 示例 2：
 * <p>
 * 输入：
 * bulbs: [1,2,3]
 * k: 1
 * 输出：-1
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= N <= 20000
 * 1 <= bulbs[i] <= N
 * bulbs 是一个由从 1 到 N 的数字构成的排列
 * 0 <= K <= 20000
 * <p>
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/sliding-window-and-two-pointers/ruaaes/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class KEmptySlots {
    public int kEmptySlots(int[] bulbs, int k) {
        int[] help = new int[bulbs.length];
        for (int i = 0; i < bulbs.length; i++) {
            int pos = bulbs[i] - 1;
            help[pos] = 1;
            int p = pos - 1;
            while (p >= 0 && help[p] != 1) {
                p--;
            }
            if (p >= 0 && p + k == pos - 1) {
                return i + 1;
            }
            p = pos + 1;
            while (p < bulbs.length && help[p] != 1) {
                p++;
            }
            if (p < bulbs.length && pos + k == p - 1) {
                return i + 1;
            }
        }
        return -1;
    }

    public int method_2(int[] bulbs, int k) {
        TreeMap<Integer, Integer> map = new TreeMap();
        int len = bulbs.length;
        if (len == 1) {
            return -1;
        }
        for (int i = 0; i < len; i++) {
            if (map.get(bulbs[i] + k + 1) != null) {
                Integer next = map.ceilingKey(bulbs[i] + 1);
                if (next == null || next > bulbs[i] + k) {
                    return i + 1;
                }
            }
            if (map.get(bulbs[i] - k - 1) != null) {
                Integer next = map.ceilingKey(bulbs[i] - k);
                if (next == null || next > bulbs[i]) {
                    return i + 1;
                }
            }
            map.put(bulbs[i], 0);
        }
        return -1;
    }

    public static void main(String[] args) {
        KEmptySlots solution = new KEmptySlots();
        int[] bulbs = new int[]{1, 3, 2};
        Assert.assertEquals(2, solution.kEmptySlots(bulbs, 1));
        bulbs = new int[]{1, 2, 3};
        Assert.assertEquals(-1, solution.kEmptySlots(bulbs, 1));
    }
}
