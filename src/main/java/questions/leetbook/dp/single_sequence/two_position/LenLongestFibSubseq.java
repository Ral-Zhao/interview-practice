package questions.leetbook.dp.single_sequence.two_position;

import org.junit.Assert;

import java.util.HashMap;
import java.util.Map;

/**
 * 如果序列 X_1, X_2, ..., X_n 满足下列条件，就说它是 斐波那契式 的：
 * <p>
 * n >= 3
 * 对于所有 i + 2 <= n，都有 X_i + X_{i+1} = X_{i+2}
 * 给定一个严格递增的正整数数组形成序列 arr ，找到 arr 中最长的斐波那契式的子序列的长度。
 * 如果一个不存在，返回  0 。
 * <p>
 * （回想一下，子序列是从原序列 arr 中派生出来的，它从 arr 中删掉任意数量的元素（也可以不删），
 * 而不改变其余元素的顺序。例如， [3, 5, 8] 是 [3, 4, 5, 6, 7, 8] 的一个子序列）
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入: arr = [1,2,3,4,5,6,7,8]
 * 输出: 5
 * 解释: 最长的斐波那契式子序列为 [1,2,3,5,8] 。
 * 示例 2：
 * <p>
 * 输入: arr = [1,3,7,11,12,14,18]
 * 输出: 3
 * 解释: 最长的斐波那契式子序列有 [1,11,12]、[3,11,14] 以及 [7,11,18] 。
 *  
 * <p>
 * 提示：
 * <p>
 * 3 <= arr.length <= 1000
 * 1 <= arr[i] < arr[i + 1] <= 10^9
 * <p>
 * 作者：FennelDumplings
 * 链接：https://leetcode-cn.com/leetbook/read/dynamic-programming-1-plus/5ruvye/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class LenLongestFibSubseq {
    public int lenLongestFibSubseq(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], i);
        }
        int[][] dp = new int[arr.length][arr.length];
        int max = 0;
        for (int i = 2; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {

                if (arr[i] - arr[j] < arr[j]) {
                    break;
                }
                int index = map.getOrDefault(arr[i] - arr[j], -1);
                if (index != -1 && index != j) {
                    if (dp[j][index] != 0) {
                        dp[index][i] = Math.max(dp[index][i], dp[j][index] + 1);
                    } else {
                        dp[index][i] = 3;
                    }
                    max = Math.max(max, dp[index][i]);
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        LenLongestFibSubseq solution = new LenLongestFibSubseq();
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
        //Assert.assertEquals(5, solution.lenLongestFibSubseq(arr));
        //arr = new int[]{1, 3, 7, 11, 12, 14, 18};
        //Assert.assertEquals(3, solution.lenLongestFibSubseq(arr));
        //arr = new int[]{2, 4, 7, 8, 9, 10, 14, 15, 18, 23, 32, 50};
        //Assert.assertEquals(5, solution.lenLongestFibSubseq(arr));
        arr = new int[]{2392, 2545, 2666, 5043, 5090, 5869, 6978, 7293, 7795};
        Assert.assertEquals(0, solution.lenLongestFibSubseq(arr));
    }
}
