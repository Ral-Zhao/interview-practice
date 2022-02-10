package questions.leetbook.dp.single_sequence.max_subarray_sum;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**
 * 给定一个正整数、负整数和 0 组成的 N × M 矩阵，编写代码找出元素总和最大的子矩阵。
 * <p>
 * 返回一个数组 [r1, c1, r2, c2]，其中 r1, c1 分别代表子矩阵左上角的行号和列号，r2, c2 分别代表右下角的行号和列号。
 * 若有多个满足条件的子矩阵，返回任意一个均可。
 * <p>
 * 注意：本题相对书上原题稍作改动
 * <p>
 * 示例：
 * <p>
 * 输入：
 * [
 *    [-1,0],
 *    [0,-1]
 * ]
 * 输出：[0,1,0,1]
 * 解释：输入中标粗的元素即为输出所表示的矩阵
 *  
 * <p>
 * 说明：
 * <p>
 * 1 <= matrix.length, matrix[0].length <= 200
 * <p>
 * 作者：FennelDumplings
 * 链接：https://leetcode-cn.com/leetbook/read/dynamic-programming-1-plus/5rnep3/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class GetMaxMatrix {
    public int[] getMaxMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] prefix = new int[m + 1][n];
        for (int i = 1; i <= m; i++) {
            for (int j = 0; j < n; j++) {
                prefix[i][j] = prefix[i - 1][j] + matrix[i - 1][j];//记录前i行的前缀和
            }
        }

        int max = matrix[0][0];
        int leftRow = 0;
        int leftCol = 0;
        int rightRow = 0;
        int rightCol = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = i; j <= m; j++) {
                int[] subArray = new int[n];
                for (int k = 0; k < n; k++) {
                    subArray[k] = prefix[j][k] - prefix[i - 1][k];
                }

                int ans = subArray[0];
                int start = 0;
                for (int k = 1; k < n; k++) {
                    if (ans >= 0) {
                        ans += subArray[k];
                    } else {
                        ans = subArray[k];
                        start = k;
                    }
                    if (ans > max) {
                        max = ans;
                        leftRow = i - 1;
                        rightRow = j - 1;
                        leftCol = start;
                        rightCol = k;
                    }
                }
            }
        }
        return new int[]{leftRow, leftCol, rightRow, rightCol};
    }

    public static void main(String[] args) {
        GetMaxMatrix solution = new GetMaxMatrix();
        int[][] matrix = new int[][]{{-1, 0}, {0, -1}};
        int[] result = solution.getMaxMatrix(matrix);
        System.out.println(JSON.toJSONString(result));
        matrix = new int[][]{{9, -8, 1, 3, -2}, {-3, 7, 6, -2, 4}, {6, -4, -4, 8, -7}};
        result = solution.getMaxMatrix(matrix);
        System.out.println(JSON.toJSONString(result));
    }
}
