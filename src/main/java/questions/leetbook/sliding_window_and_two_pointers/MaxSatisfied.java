package questions.leetbook.sliding_window_and_two_pointers;

import org.junit.Assert;

/**
 * 今天，书店老板有一家店打算试营业 customers.length 分钟。每分钟都有一些顾客（customers[i]）会进入书店，所有这些顾客都会在那一分钟结束后离开。
 * <p>
 * 在某些时候，书店老板会生气。 如果书店老板在第 i 分钟生气，那么 grumpy[i] = 1，否则 grumpy[i] = 0。 当书店老板生气时，那一分钟的顾客就会不满意，不生气则他们是满意的。
 * <p>
 * 书店老板知道一个秘密技巧，能抑制自己的情绪，可以让自己连续 X 分钟不生气，但却只能使用一次。
 * <p>
 * 请你返回这一天营业下来，最多有多少客户能够感到满意。
 *  
 * <p>
 * 示例：
 * <p>
 * 输入：customers = [1,0,1,2,1,1,7,5], grumpy = [0,1,0,1,0,1,0,1], X = 3
 * 输出：16
 * 解释：
 * 书店老板在最后 3 分钟保持冷静。
 * 感到满意的最大客户数量 = 1 + 1 + 1 + 1 + 7 + 5 = 16.
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= X <= customers.length == grumpy.length <= 20000
 * 0 <= customers[i] <= 1000
 * 0 <= grumpy[i] <= 1
 * <p>
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/sliding-window-and-two-pointers/rlkdli/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class MaxSatisfied {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int origin = 0;
        for (int i = 0; i < customers.length; i++) {
            if (grumpy[i] == 0) {
                origin += customers[i];
            }
        }
        int max = 0;
        int sum = 0;
        for (int i = 0; i < grumpy.length; i++) {
            if (i < minutes) {
                sum += grumpy[i] == 1 ? customers[i] : 0;
                continue;
            }
            max = Math.max(max, sum);
            if (grumpy[i] == 1) {
                sum += customers[i];
            }
            if (grumpy[i - minutes] == 1) {
                sum -= customers[i - minutes];
            }
        }
        max = Math.max(max, sum);
        return origin + max;
    }

    public static void main(String[] args) {
        MaxSatisfied solution = new MaxSatisfied();
        int[] customers = new int[]{1, 0, 1, 2, 1, 1, 7, 5};
        int[] grumpy = new int[]   {0, 1, 0, 1, 0, 1, 0, 1};
        Assert.assertEquals(16, solution.maxSatisfied(customers, grumpy, 3));
    }
}
