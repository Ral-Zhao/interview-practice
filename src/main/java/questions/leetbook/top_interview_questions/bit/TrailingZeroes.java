package questions.leetbook.top_interview_questions.bit;

import org.junit.Assert;

/**
 * 给定一个整数 n ，返回 n! 结果中尾随零的数量。
 * <p>
 * 提示 n! = n * (n - 1) * (n - 2) * ... * 3 * 2 * 1
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 3
 * 输出：0
 * 解释：3! = 6 ，不含尾随 0
 * 示例 2：
 * <p>
 * 输入：n = 5
 * 输出：1
 * 解释：5! = 120 ，有一个尾随 0
 * 示例 3：
 * <p>
 * 输入：n = 0
 * 输出：0
 *  
 * <p>
 * 提示：
 * <p>
 * 0 <= n <= 10^4
 *  
 * <p>
 * 进阶：你可以设计并实现对数时间复杂度的算法来解决此问题吗？
 * <p>
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions/x2we65/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class TrailingZeroes {
    public int trailingZeroes(int n) {
        int count = 0;
        for (int i = 5; i <= 10000; i*=5) {
            if (i>n){
                break;
            }
            count+=n/i;
        }
        return count;
    }

    public static void main(String[] args) {
        TrailingZeroes solution = new TrailingZeroes();
        Assert.assertEquals(0, solution.trailingZeroes(3));
        Assert.assertEquals(1, solution.trailingZeroes(5));
        Assert.assertEquals(24, solution.trailingZeroes(100));
        Assert.assertEquals(1, solution.trailingZeroes(6));
    }
}
