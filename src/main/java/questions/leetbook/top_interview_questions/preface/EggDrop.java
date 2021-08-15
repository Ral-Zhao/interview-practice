package questions.leetbook.top_interview_questions.preface;

import org.junit.Assert;

/**
 * 给你 k 枚相同的鸡蛋，并可以使用一栋从第 1 层到第 n 层共有 n 层楼的建筑。
 * <p>
 * 已知存在楼层 f ，满足 0 <= f <= n ，任何从 高于 f 的楼层落下的鸡蛋都会碎，从 f 楼层或比它低的楼层落下的鸡蛋都不会破。
 * <p>
 * 每次操作，你可以取一枚没有碎的鸡蛋并把它从任一楼层 x 扔下（满足 1 <= x <= n）。如果鸡蛋碎了，你就不能再次使用它。
 * 如果某枚鸡蛋扔下后没有摔碎，则可以在之后的操作中 重复使用 这枚鸡蛋。
 * <p>
 * 请你计算并返回要确定 f 确切的值 的 最小操作次数 是多少？
 * <p>
 *  
 * 示例 1：
 * <p>
 * 输入：k = 1, n = 2
 * 输出：2
 * 解释：
 * 鸡蛋从 1 楼掉落。如果它碎了，肯定能得出 f = 0 。
 * 否则，鸡蛋从 2 楼掉落。如果它碎了，肯定能得出 f = 1 。
 * 如果它没碎，那么肯定能得出 f = 2 。
 * 因此，在最坏的情况下我们需要移动 2 次以确定 f 是多少。
 * 示例 2：
 * <p>
 * 输入：k = 2, n = 6
 * 输出：3
 * 示例 3：
 * <p>
 * 输入：k = 3, n = 14
 * 输出：4
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= k <= 100
 * 1 <= n <= 10^4
 * <p>
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions/xmup75/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class EggDrop {
    public int superEggDrop(int k, int n) {
        // dp[k][m]=N 有k个鸡蛋，最多可以扔m次，能够测试N层楼
        // 所需要的就是不断增大m，知道dp[k][m] >= n 此时m就是使用k个鸡蛋，测试n层用的最少的次数
        // dp[i][m] = dp[i-1][m-1] + dp[i][m-1] + 1
        // 确定层数嘛，区别于递归里面的看法，此时这么想
        // 在丢鸡蛋层往下有多少层? 如何度量这个层数呢？是不是加入鸡蛋在这里扔下去碎了(下面都已经被测得不可能了) dp[i-1][m-1]就表示测到的这个下半层楼的层数
        // 在丢鸡蛋层往上有多少层? 如何度量这个层数呢？是不是加入鸡蛋在这里扔下去没碎(上面都已经被测得不可能了) dp[i][m-1]就表示测到的这个上半层楼的层数
        // 故当前总共可测的楼层数  上半层 + 下半层 + 当前这一层

        int[][] dp = new int[k + 1][n+1];
        int time = 0;
        while (dp[k][time] < n) {
            time++;
            for (int i = 1; i <= k; i++) {
                dp[i][time] = dp[i - 1][time - 1] + dp[i][time - 1] + 1;
            }
        }
        return time;
    }

    public static void main(String[] args) {
        EggDrop solution = new EggDrop();
        Assert.assertEquals(2, solution.superEggDrop(1, 2));
        Assert.assertEquals(3, solution.superEggDrop(2, 6));
        Assert.assertEquals(4, solution.superEggDrop(3, 14));
    }
}
