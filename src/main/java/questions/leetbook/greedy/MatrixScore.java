package questions.leetbook.greedy;

import org.junit.Assert;

/**
 * 有一个二维矩阵 A 其中每个元素的值为 0 或 1 。
 * <p>
 * 移动是指选择任一行或列，并转换该行或列中的每一个值：将所有 0 都更改为 1，将所有 1 都更改为 0。
 * <p>
 * 在做出任意次数的移动后，将该矩阵的每一行都按照二进制数来解释，矩阵的得分就是这些数字的总和。
 * <p>
 * 返回尽可能高的分数。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 输入：[[0,0,1,1],[1,0,1,0],[1,1,0,0]]
 * 输出：39
 * 解释：
 * 转换为 [[1,1,1,1],[1,0,0,1],[1,1,1,1]]
 * 0b1111 + 0b1001 + 0b1111 = 15 + 9 + 15 = 39
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= A.length <= 20
 * 1 <= A[0].length <= 20
 * A[i][j] 是 0 或 1
 * <p>
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/greedy/rvjrkm/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class MatrixScore {
    public int matrixScore(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            if (grid[i][0] == 0) {
                for (int j = 0; j < grid[0].length; j++) {
                    grid[i][j] = 1 - grid[i][j];
                }
            }
        }
        for (int i = 1; i < grid[0].length; i++) {
            int zero = 0;
            int one = 0;
            for (int j = 0; j < grid.length; j++) {
                if (grid[j][i] == 1) {
                    one++;
                } else {
                    zero++;
                }
            }
            if (zero > one) {
                for (int j = 0; j < grid.length; j++) {
                    grid[j][i] = 1 - grid[j][i];
                }
            }
        }

        int result = 0;
        for (int i = 0; i < grid.length; i++) {
            int temp = 0;
            for (int j = 0; j < grid[0].length; j++) {
                temp = temp * 2 + grid[i][j];
            }
            result += temp;
        }
        return result;
    }

    public static void main(String[] args) {
        MatrixScore solution = new MatrixScore();
        int[][] grid = new int[][]{{0, 0, 1, 1}, {1, 0, 1, 0}, {1, 1, 0, 0}};
        Assert.assertEquals(39, solution.matrixScore(grid));
        grid = new int[][]{{0, 1, 1}, {1, 1, 1}, {0, 1, 0}};
        Assert.assertEquals(18, solution.matrixScore(grid));
    }
}
