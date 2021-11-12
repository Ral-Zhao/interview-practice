package questions.leetbook.top_interview_questions.bit;

import org.junit.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 统计所有小于非负整数 n 的质数的数量。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 10
 * 输出：4
 * 解释：小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
 * 示例 2：
 * <p>
 * 输入：n = 0
 * 输出：0
 * 示例 3：
 * <p>
 * 输入：n = 1
 * 输出：0
 *  
 * <p>
 * 提示：
 * <p>
 * 0 <= n <= 5 * 10^6
 * <p>
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions/x20yuc/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class CountPrimes {
    public int countPrimes(int n) {
        if (n <= 1) {
            return 0;
        }
        int[] primes = new int[n];
        int count = 0;
        for (int i = 2; i < primes.length; i++) {
            for (int j = 2; j * i < n; j++) {
                if (primes[j * i] == 1) {
                    continue;
                }
                primes[j * i] = 1;
                count++;
            }
        }
        return n - count - 2;
    }
    public int method_2(int n) {
        List<Integer> primes = new ArrayList<Integer>();
        int[] isPrime = new int[n];
        Arrays.fill(isPrime, 1);
        for (int i = 2; i < n; ++i) {
            if (isPrime[i] == 1) {
                primes.add(i);
            }
            for (int j = 0; j < primes.size() && i * primes.get(j) < n; ++j) {
                isPrime[i * primes.get(j)] = 0;
                if (i % primes.get(j) == 0) {
                    break;
                }
            }
        }
        return primes.size();
    }

    public static void main(String[] args) {
        CountPrimes solution = new CountPrimes();
        Assert.assertEquals(4, solution.countPrimes(10));
        Assert.assertEquals(0, solution.countPrimes(0));
        Assert.assertEquals(0, solution.countPrimes(1));
    }
}
