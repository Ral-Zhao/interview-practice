package questions.leetbook.top_interview_questions.test;

import org.junit.Assert;

import java.util.*;

/**
 * 编写一个算法来判断一个数 n 是不是快乐数。
 * <p>
 * 「快乐数」定义为：
 * <p>
 * 对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和。
 * 然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。
 * 如果 可以变为  1，那么这个数就是快乐数。
 * 如果 n 是快乐数就返回 true ；不是，则返回 false 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 19
 * 输出：true
 * 解释：
 * 1^2 + 9^2 = 82
 * 8^2 + 2^2 = 68
 * 6^2 + 8^2 = 100
 * 1^2 + 0^2 + 0^2 = 1
 * 示例 2：
 * <p>
 * 输入：n = 2
 * 输出：false
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 2^31 - 1
 * <p>
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions/xm3y2i/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class HappyNumber {
    public boolean isHappy(int n) {
        Map<Integer, List<Integer>> visited = new HashMap<>();
        while (n != 1) {
            int flag = 0;
            int temp = n;
            int sum = 0;
            while (temp != 0) {
                int mod = temp % 10;
                temp = temp / 10;
                flag = flag ^ (1 << mod);
                sum = sum + mod * mod;
            }
            List<Integer> list = visited.getOrDefault(sum, new ArrayList<>());
            for (int cand : list) {
                if (cand == flag) {
                    return false;
                }
            }
            n = sum;
            list.add(flag);
            visited.put(sum, list);
        }
        return true;
    }

    public boolean method_2(int n) {
        int fast = n;
        int slow = n;
        do {
            slow = squareSum(slow);
            fast = squareSum(fast);
            fast = squareSum(fast);
        } while (slow != fast);
        return fast == 1;
    }

    private int squareSum(int m) {
        int squaresum = 0;
        while (m != 0) {
            squaresum += (m % 10) * (m % 10);
            m /= 10;
        }
        return squaresum;
    }

    public static void main(String[] args) {
        HappyNumber solution = new HappyNumber();
        Assert.assertTrue(solution.isHappy(19));
        Assert.assertTrue(!solution.isHappy(2));
        Assert.assertTrue(solution.isHappy(133));
    }
}
