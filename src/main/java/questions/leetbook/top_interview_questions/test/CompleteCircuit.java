package questions.leetbook.top_interview_questions.test;

import org.junit.Assert;

/**
 * 在一条环路上有 N 个加油站，其中第 i 个加油站有汽油 gas[i] 升。
 * <p>
 * 你有一辆油箱容量无限的的汽车，从第 i 个加油站开往第 i+1 个加油站需要消耗汽油 cost[i] 升。你从其中的一个加油站出发，开始时油箱为空。
 * <p>
 * 如果你可以绕环路行驶一周，则返回出发时加油站的编号，否则返回 -1。
 * <p>
 * 说明: 
 * <p>
 * 如果题目有解，该答案即为唯一答案。
 * 输入数组均为非空数组，且长度相同。
 * 输入数组中的元素均为非负数。
 * 示例 1:
 * <p>
 * 输入:
 * gas  = [1,2,3,4,5]
 * cost = [3,4,5,1,2]
 * <p>
 * 输出: 3
 * <p>
 * 解释:
 * 从 3 号加油站(索引为 3 处)出发，可获得 4 升汽油。此时油箱有 = 0 + 4 = 4 升汽油
 * 开往 4 号加油站，此时油箱有 4 - 1 + 5 = 8 升汽油
 * 开往 0 号加油站，此时油箱有 8 - 2 + 1 = 7 升汽油
 * 开往 1 号加油站，此时油箱有 7 - 3 + 2 = 6 升汽油
 * 开往 2 号加油站，此时油箱有 6 - 4 + 3 = 5 升汽油
 * 开往 3 号加油站，你需要消耗 5 升汽油，正好足够你返回到 3 号加油站。
 * 因此，3 可为起始索引。
 * 示例 2:
 * <p>
 * 输入:
 * gas  = [2,3,4]
 * cost = [3,4,3]
 * <p>
 * 输出: -1
 * <p>
 * 解释:
 * 你不能从 0 号或 1 号加油站出发，因为没有足够的汽油可以让你行驶到下一个加油站。
 * 我们从 2 号加油站出发，可以获得 4 升汽油。 此时油箱有 = 0 + 4 = 4 升汽油
 * 开往 0 号加油站，此时油箱有 4 - 3 + 2 = 3 升汽油
 * 开往 1 号加油站，此时油箱有 3 - 3 + 3 = 3 升汽油
 * 你无法返回 2 号加油站，因为返程需要消耗 4 升汽油，但是你的油箱只有 3 升汽油。
 * 因此，无论怎样，你都不可能绕环路行驶一周。
 * <p>
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions/xmguej/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class CompleteCircuit {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int len = cost.length;
        int[] delta = new int[len];
        for (int i = 0; i < len; i++) {
            delta[i] = gas[i] - cost[i];
        }
        if (len == 1) {
            return delta[0] >= 0 ? 0 : -1;
        }
        for (int i = 0; i < len; i++) {
            if (delta[i] <= 0) {
                continue;
            }
            int sum = 0;
            for (int j = i; j < i + len; j++) {
                sum += delta[j % len];
                if (sum < 0) {
                    break;
                }
            }
            if (sum >= 0) {
                return i;
            }
        }
        return -1;
    }

    /**
     *  1.先不考虑循环问题。
     *
     * -2 -2 -2 3 3 这是每一个站加了油到下一个站能剩余的量(gas[i] - cost[i])（不考虑之前站加的油。）
     *  从这个数组可以看出来， 是负数的必然不是起点，因为，就不可能走到下一个站。
     *  所以必然是正数的才可能是起点。 再猜想： 该数组的前缀和最小处可能是循环的终点，下一个位置可能是起点。
     *   假设该点为a, 若a之前的某个点b是终点， 它的差数组接下来一段b->a和是负值，必然不能从b的下一个出发到a点。
     *   （因为到达a才是前缀和最小，a前的一段和必然是负值） 再假设，终点在a的后边的某个位置b ， 则a->b这一段和必然是正数，
     *   否则前缀和到b才是最小。在该段和是正数的情况下，从b的下一个出发，很可能无法到达a.
     *   因为，该段和是正数，它在最小前缀的后边，需要最后经过a之后才能取到，但是可能恰好缺少该段和而不能到达a。
     *
     * 2.循环 对 前缀和 的影响。 若原差数组是 -2 3 3 -2 -2 求最小前缀和依然可以定位到第一个3作为出发点。
     * 但是为什么循环没有影响呢。 为什么会等价于-2 -2 -2 3 3呢？
     *  其实求前缀和的意义，就是划分，最小最大子段和， 对于 -2 3 3 -2 -2 完全肯伊等价于 -2 2 的问题把后边写成一个和 其就和 -2 -2 -2 3 3 是一致的的了。
     *  都是在前边存在最小前缀和， 后边为起点。
     *
     * 3.不可行的判断
     * （1） ： 差数组的和 为负数， 必然不能走完循环。显然
     * （2）： 那么对于和为正数的差数组，一定可以吗？ 不显然，但是是的。
     * 对于 该问题 总能划分为 -2 -2 -2 3 3 类似的形式， 如果后半段有负数如-2 3 3 -2 -2 也等价于 -2 2 问题 ： 总是分为最小前缀和部分，和后边和为正数的形式。
     * 正数 >= 最小前缀 就一定能走完。
     *
     * 4. 如果最小前缀是在最后的位置，如果sum >= 0 则 说明正数段在前边。
     */
    public int method_2(int[] gas, int[] cost) {
        int index = 0;
        int minsum = gas[0] - cost[0];
        int presum = gas[0] - cost[0];
        for(int i = 1; i < gas.length; i++){
            int tempsum = presum + gas[i] - cost[i];
            if(tempsum < minsum) {
                index = i;
                minsum = tempsum;
            }
            presum = tempsum;
        }
        if(presum < 0) return -1;
        return (index+1) % gas.length;
    }

    public int method_3(int[] gas, int[] cost) {
        int n = gas.length;
        for (int i = 0; i < n; i++) {
            int j = i;
            int remain = gas[i];
            while (remain - cost[j] >= 0) {
                //减去花费的加上新的点的补给
                remain = remain - cost[j] + gas[(j + 1) % n];
                j = (j + 1) % n;
                //j 回到了 i
                if (j == i) {
                    return i;
                }
            }
            //最远距离绕到了之前，所以 i 后边的都不可能绕一圈了
            if (j < i) {
                return -1;
            }
            //i 直接跳到 j，外层 for 循环执行 i++，相当于从 j + 1 开始考虑
            i = j;

        }
        return -1;
    }

    public static void main(String[] args) {
        CompleteCircuit solution = new CompleteCircuit();
        int[] gas = new int[]{1, 2, 3, 4, 5};
        int[] cost = new int[]{3, 4, 5, 1, 2};
        Assert.assertEquals(3, solution.canCompleteCircuit(gas, cost));
        gas = new int[]{2, 3, 4};
        cost = new int[]{3, 4, 3};
        Assert.assertEquals(-1, solution.canCompleteCircuit(gas, cost));
        gas = new int[]{2};
        cost = new int[]{2};
        Assert.assertEquals(0, solution.canCompleteCircuit(gas, cost));
    }
}
