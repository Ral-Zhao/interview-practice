package questions.leetbook.top_interview_questions.dp;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
 *
 * 给你一个整数 n ，返回和为 n 的完全平方数的 最少数量 。
 *
 * 完全平方数 是一个整数，其值等于另一个整数的平方；换句话说，其值等于一个整数自乘的积。例如，1、4、9 和 16 都是完全平方数，而 3 和 11 不是。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：n = 12
 * 输出：3
 * 解释：12 = 4 + 4 + 4
 * 示例 2：
 *
 * 输入：n = 13
 * 输出：2
 * 解释：13 = 4 + 9
 *  
 * 提示：
 *
 * 1 <= n <= 10^4
 *
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions/x2959v/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class NumSquares {

    /**
     * 动态规划的思想是，与当前状态对应的信息，可以由之前状态对应的信息递推出来。
     * 对于此题来说，我们可以:
     *
     * 把一个数看作一个状态，记当前的数为i，i之前的某个数为x
     * 把和为数i的完全平方数的最少数量看作状态对应的信息，记为dp[i]
     * 那现在问题就变成了，具体i之前的哪个x.可以使得通过dp[x]推出dp[i]?
     * 显然，在数i之前一定存在着许多数x使得 x+一个完全平方数等于 i,
     * 即x+k*k=i(k=1,2,3...)，也就是x与i之间差一个完全平方数,
     * 即dp[x]+1 = dp[i]。
     *
     * 所以，我们只要找到所有与i差一个完全平方数的x,然后看这些x的哪个dp[x]最小，把最小的dp[x]+1,就得到了dp[i]。
     *
     */
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        for (int i = 1; i < dp.length; i++) {
            dp[i] = dp[i - 1] + 1;
            for (int j = 1, k; (k = i - j * j) >= 0; j++) {
                dp[i] = Math.min(dp[i], dp[k] + 1);
            }
        }
        return dp[n];
    }

    /**
     * BFS 层次遍历 求第一个满足条件的节点的层次
     *
     *         7
     *        / \
     *       6   3
     *     / \    \
     *    5   2    2
     *   / \   \    \
     * 1    4   1    1
     *
     */
    public int method_2(int n) {
        Queue<Integer> queue=new LinkedList<>();
        HashSet<Integer> visited=new HashSet<>();
        queue.offer(n);
        visited.add(n);
        int level=0;

        while(!queue.isEmpty()){
            level++;
            int len=queue.size();

            for(int i=0;i<len;i++){
                int cur=queue.poll();

                for(int j=1;j*j<=cur;j++){
                    int tmp=cur-j*j;
                    if(tmp==0)
                        return level;
                    if(!visited.contains(tmp))
                        queue.offer(tmp);
                    visited.add(tmp);
                }
            }
        }
        return level;
    }
}
