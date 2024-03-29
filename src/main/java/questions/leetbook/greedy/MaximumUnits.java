package questions.leetbook.greedy;

import org.junit.Assert;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 请你将一些箱子装在 一辆卡车 上。给你一个二维数组 boxTypes ，其中 boxTypes[i] = [numberOfBoxesi, numberOfUnitsPerBoxi] ：
 * <p>
 * numberOfBoxesi 是类型 i 的箱子的数量。
 * numberOfUnitsPerBoxi 是类型 i 每个箱子可以装载的单元数量。
 * 整数 truckSize 表示卡车上可以装载 箱子 的 最大数量 。只要箱子数量不超过 truckSize ，你就可以选择任意箱子装到卡车上。
 * <p>
 * 返回卡车可以装载 单元 的 最大 总数。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：boxTypes = [[1,3],[2,2],[3,1]], truckSize = 4
 * 输出：8
 * 解释：箱子的情况如下：
 * - 1 个第一类的箱子，里面含 3 个单元。
 * - 2 个第二类的箱子，每个里面含 2 个单元。
 * - 3 个第三类的箱子，每个里面含 1 个单元。
 * 可以选择第一类和第二类的所有箱子，以及第三类的一个箱子。
 * 单元总数 = (1 * 3) + (2 * 2) + (1 * 1) = 8
 * 示例 2：
 * <p>
 * 输入：boxTypes = [[5,10],[2,5],[4,7],[3,9]], truckSize = 10
 * 输出：91
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= boxTypes.length <= 1000
 * 1 <= numberOfBoxesi, numberOfUnitsPerBoxi <= 1000
 * 1 <= truckSize <= 10^6
 * <p>
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/greedy/rvqpoc/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class MaximumUnits {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[1] - o1[1];
            }
        });
        int sum = 0;
        for (int i = 0; i < boxTypes.length && truckSize > 0; i++) {
            if (truckSize >= boxTypes[i][0]) {
                truckSize -= boxTypes[i][0];
                sum += boxTypes[i][0] * boxTypes[i][1];
            } else {
                sum += boxTypes[i][1] * truckSize;
                break;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        MaximumUnits solution = new MaximumUnits();
        int[][] boxTypes = new int[][]{{1, 3}, {2, 2}, {3, 1}};
        Assert.assertEquals(8, solution.maximumUnits(boxTypes, 4));
        boxTypes = new int[][]{{5, 10}, {2, 5}, {4, 7}, {3, 9}};
        Assert.assertEquals(91, solution.maximumUnits(boxTypes, 10));
    }
}
