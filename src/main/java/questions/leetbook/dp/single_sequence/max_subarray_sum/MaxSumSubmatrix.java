package questions.leetbook.dp.single_sequence.max_subarray_sum;

import org.junit.Assert;

/**
 * 给你一个 m x n 的矩阵 matrix 和一个整数 k ，找出并返回矩阵内部矩形区域的不超过 k 的最大数值和。
 * <p>
 * 题目数据保证总会存在一个数值和不超过 k 的矩形区域。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：matrix = [[1,0,1],[0,-2,3]], k = 2
 * 输出：2
 * 解释：蓝色边框圈出来的矩形区域 [[0, 1], [-2, 3]] 的数值和是 2，且 2 是不超过 k 的最大数字（k = 2）。
 * 示例 2：
 * <p>
 * 输入：matrix = [[2,2,-1]], k = 3
 * 输出：3
 *  
 * <p>
 * 提示：
 * <p>
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 100
 * -100 <= matrix[i][j] <= 100
 * -10^5 <= k <= 10^5
 *  
 * <p>
 * 进阶：如果行数远大于列数，该如何设计解决方案？
 * <p>
 * 作者：FennelDumplings
 * 链接：https://leetcode-cn.com/leetbook/read/dynamic-programming-1-plus/5rvxrm/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class MaxSumSubmatrix {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] prefix = new int[m + 1][n];

        for (int i = 1; i <= m; i++) {
            for (int j = 0; j < n; j++) {
                prefix[i][j] = prefix[i - 1][j] + matrix[i - 1][j];
            }
        }

        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= m; i++) {
            for (int j = i; j <= m; j++) {
                int[] sub = new int[n];
                for (int l = 0; l < n; l++) {
                    sub[l] = prefix[j][l] - prefix[i - 1][l];
                }
                for (int l = 0; l < n; l++) {
                    int sum = 0;
                    for (int o = l; o < n; o++) {
                        sum += sub[o];
                        if (sum <= k) {
                            max = Math.max(max, sum);
                        }
                    }
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        MaxSumSubmatrix solution = new MaxSumSubmatrix();
        int[][] matrix = new int[][]{{1, 0, 1}, {0, -2, 3}};
        Assert.assertEquals(2, solution.maxSumSubmatrix(matrix, 2));
        matrix = new int[][]{{2, 2, -1}};
        Assert.assertEquals(3, solution.maxSumSubmatrix(matrix, 3));
        matrix = new int[][]{{2, 2, -1}};
        Assert.assertEquals(2, solution.maxSumSubmatrix(matrix, 2));
        matrix = new int[][]{{2, 2, -1}};
        Assert.assertEquals(-1, solution.maxSumSubmatrix(matrix, 0));
    }
}
