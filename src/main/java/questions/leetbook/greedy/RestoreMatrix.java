package questions.leetbook.greedy;

import com.alibaba.fastjson.JSON;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 给你两个非负整数数组 rowSum 和 colSum ，其中 rowSum[i] 是二维矩阵中第 i 行元素的和， colSum[j] 是第 j 列元素的和。
 * 换言之你不知道矩阵里的每个元素，但是你知道每一行和每一列的和。
 * <p>
 * 请找到大小为 rowSum.length x colSum.length 的任意 非负整数 矩阵，且该矩阵满足 rowSum 和 colSum 的要求。
 * <p>
 * 请你返回任意一个满足题目要求的二维矩阵，题目保证存在 至少一个 可行矩阵。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：rowSum = [3,8], colSum = [4,7]
 * 输出：[[3,0],
 * [1,7]]
 * 解释：
 * 第 0 行：3 + 0 = 3 == rowSum[0]
 * 第 1 行：1 + 7 = 8 == rowSum[1]
 * 第 0 列：3 + 1 = 4 == colSum[0]
 * 第 1 列：0 + 7 = 7 == colSum[1]
 * 行和列的和都满足题目要求，且所有矩阵元素都是非负的。
 * 另一个可行的矩阵为：[[1,2],
 * [3,5]]
 * 示例 2：
 * <p>
 * 输入：rowSum = [5,7,10], colSum = [8,6,8]
 * 输出：[[0,5,0],
 * [6,1,0],
 * [2,0,8]]
 * 示例 3：
 * <p>
 * 输入：rowSum = [14,9], colSum = [6,9,8]
 * 输出：[[0,9,5],
 * [6,0,3]]
 * 示例 4：
 * <p>
 * 输入：rowSum = [1,0], colSum = [1]
 * 输出：[[1],
 * [0]]
 * 示例 5：
 * <p>
 * 输入：rowSum = [0], colSum = [0]
 * 输出：[[0]]
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= rowSum.length, colSum.length <= 500
 * 0 <= rowSum[i], colSum[i] <= 10^8
 * sum(rows) == sum(columns)
 * <p>
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/greedy/rvs6bt/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class RestoreMatrix {
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int[][] result = new int[rowSum.length][colSum.length];
        int[][] rowIndex = new int[rowSum.length][2];
        for (int i = 0; i < rowSum.length; i++) {
            rowIndex[i][0] = rowSum[i];
            rowIndex[i][1] = i;
        }
        int[][] colIndex = new int[colSum.length][2];
        for (int i = 0; i < colSum.length; i++) {
            colIndex[i][0] = colSum[i];
            colIndex[i][1] = i;
        }
        Arrays.sort(rowIndex, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        Arrays.sort(colIndex, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        int iCol = 0;
        int iRow = 0;
        while (iCol < colSum.length && iRow < rowSum.length) {
            int[] colArr = colIndex[iCol];
            int[] rowArr = rowIndex[iRow];
            int num = Math.min(colArr[0], rowArr[0]);
            result[rowArr[1]][colArr[1]] = num;
            colArr[0] -= num;
            rowArr[0] -= num;
            if (colArr[0] == 0) {
                iCol++;
            }
            if (rowArr[0] == 0) {
                iRow++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        RestoreMatrix solution = new RestoreMatrix();
        int[] rowSum = new int[]{5, 7, 10};
        int[] colSum = new int[]{8, 6, 8};
        int[][] result = solution.restoreMatrix(rowSum, colSum);
        System.out.println(JSON.toJSONString(result));
        rowSum = new int[]{14, 9};
        colSum = new int[]{6, 9, 8};
        result = solution.restoreMatrix(rowSum, colSum);
        System.out.println(JSON.toJSONString(result));
        rowSum = new int[]{1, 0};
        colSum = new int[]{1};
        result = solution.restoreMatrix(rowSum, colSum);
        System.out.println(JSON.toJSONString(result));
        rowSum = new int[]{0};
        colSum = new int[]{0};
        result = solution.restoreMatrix(rowSum, colSum);
        System.out.println(JSON.toJSONString(result));
    }
}
