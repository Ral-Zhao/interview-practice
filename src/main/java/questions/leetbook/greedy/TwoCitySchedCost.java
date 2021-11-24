package questions.leetbook.greedy;

import org.junit.Assert;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 公司计划面试 2n 人。给你一个数组 costs ，其中 costs[i] = [aCosti, bCosti] 。第 i 人飞往 a 市的费用为 aCosti ，飞往 b 市的费用为 bCosti 。
 * <p>
 * 返回将每个人都飞到 a 、b 中某座城市的最低费用，要求每个城市都有 n 人抵达。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：costs = [[10,20],[30,200],[400,50],[30,20]]
 * 输出：110
 * 解释：
 * 第一个人去 a 市，费用为 10。
 * 第二个人去 a 市，费用为 30。
 * 第三个人去 b 市，费用为 50。
 * 第四个人去 b 市，费用为 20。
 * <p>
 * 最低总费用为 10 + 30 + 50 + 20 = 110，每个城市都有一半的人在面试。
 * 示例 2：
 * <p>
 * 输入：costs = [[259,770],[448,54],[926,667],[184,139],[840,118],[577,469]]
 * 输出：1859
 * 示例 3：
 * <p>
 * 输入：costs = [[515,563],[451,713],[537,709],[343,819],[855,779],[457,60],[650,359],[631,42]]
 * 输出：3086
 *  
 * <p>
 * 提示：
 * <p>
 * 2 * n == costs.length
 * 2 <= costs.length <= 100
 * costs.length 为偶数
 * 1 <= aCosti, bCosti <= 1000
 * <p>
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/greedy/rvzzjj/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class TwoCitySchedCost {
    public int twoCitySchedCost(int[][] costs) {
        int n = costs.length / 2;
        int cost = 0;
        Arrays.sort(costs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return (o2[1] - o2[0]) - (o1[1] - o1[0]);
            }
        });
        for (int i = 0; i < costs.length; i++) {
            if (i < n) {
                cost += costs[i][0];
            } else {
                cost += costs[i][1];
            }
        }
        return cost;
    }

    public static void main(String[] args) {
        TwoCitySchedCost solution = new TwoCitySchedCost();
        int[][] costs = new int[][]{{10, 20}, {30, 200}, {400, 50}, {30, 20}};
        Assert.assertEquals(110, solution.twoCitySchedCost(costs));
        costs = new int[][]{{259, 770}, {448, 54}, {926, 667}, {184, 139}, {840, 118}, {577, 469}};
        Assert.assertEquals(1859, solution.twoCitySchedCost(costs));
        costs = new int[][]{{515, 563}, {451, 713}, {537, 709}, {343, 819}, {855, 779}, {457, 60}, {650, 359}, {631, 42}};
        Assert.assertEquals(3086, solution.twoCitySchedCost(costs));
    }
}
