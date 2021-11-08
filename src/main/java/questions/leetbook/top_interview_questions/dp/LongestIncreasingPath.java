package questions.leetbook.top_interview_questions.dp;

import org.junit.Assert;

import java.util.*;

/**
 * 给定一个 m x n 整数矩阵 matrix ，找出其中 最长递增路径 的长度。
 * <p>
 * 对于每个单元格，你可以往上，下，左，右四个方向移动。 你 不能 在 对角线 方向上移动或移动到 边界外（即不允许环绕）。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：matrix = [[9,9,4],[6,6,8],[2,1,1]]
 * 输出：4
 * 解释：最长递增路径为 [1, 2, 6, 9]。
 * 示例 2：
 * <p>
 * <p>
 * 输入：matrix = [[3,4,5],[3,2,6],[2,2,1]]
 * 输出：4
 * 解释：最长递增路径是 [3, 4, 5, 6]。注意不允许在对角线方向上移动。
 * 示例 3：
 * <p>
 * 输入：matrix = [[1]]
 * 输出：1
 *  
 * <p>
 * 提示：
 * <p>
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 200
 * 0 <= matrix[i][j] <= 231 - 1
 * <p>
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions/x2osfr/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class LongestIncreasingPath {
    // 上下左右四个方向
    int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int longestIncreasingPath(int[][] matrix) {
        int max = 0;
        int[][] visited = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                max = Math.max(max, dfs(matrix, visited, i, j, Integer.MIN_VALUE));
            }
        }
        return max;
    }

    private int dfs(int[][] matrix, int[][] visited, int i, int j, int pre) {
        if (invalidBound(matrix, i, j) || matrix[i][j] <= pre) {
            return 0;
        }
        if (visited[i][j] > 0) {
            return visited[i][j];
        }
        int left = dfs(matrix, visited, i, j - 1, matrix[i][j]);
        int right = dfs(matrix, visited, i, j + 1, matrix[i][j]);
        int up = dfs(matrix, visited, i - 1, j, matrix[i][j]);
        int down = dfs(matrix, visited, i + 1, j, matrix[i][j]);
        visited[i][j] = 1 + Math.max(left, Math.max(right, Math.max(up, down)));
        return visited[i][j];
    }

    private boolean invalidBound(int[][] matrix, int i, int j) {
        return i >= matrix.length || i < 0 || j < 0 || j >= matrix[0].length;
    }

    /**
     * BFS
     */
    public int method_2(int[][] matrix) {
        // 把符合题目要求的点连起来就是有一张有向无环图
        // 所以我们可以使用多源BFS拓扑排序寻找最短路径的思想在这里寻找最长路径
        int m = matrix.length;
        int n = matrix[0].length;
        // 记录每个节点的出度
        int[][] outDegree = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int[] dir : dirs) {
                    int nextI = i + dir[0];
                    int nextJ = j + dir[1];
                    // 只要旁边节点的值比它大，它的出度就加1
                    if (nextI >= 0 && nextJ >= 0 && nextI < m && nextJ < n && matrix[nextI][nextJ] > matrix[i][j]) {
                        outDegree[i][j]++;
                    }
                }
            }
        }

        // 多源BFS（可以跟上面的循环合在一起）
        // 为了更清晰，这里单独写这个循环
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (outDegree[i][j] == 0) {
                    queue.offer(new int[] {i, j});
                }
            }
        }

        int ans = 0;
        while (!queue.isEmpty()) {
            ans++;
            // 一次遍历一批，每遍历一批，相当于最长路径又加了一
            int size = queue.size();
            for (int c = 0; c < size; c++) {
                int[] pos = queue.poll();
                int i = pos[0];
                int j = pos[1];
                for (int[] dir : dirs) {
                    int preI = i + dir[0];
                    int preJ = j + dir[1];
                    if (preI >= 0 && preI < m && preJ >= 0 && preJ < n && matrix[preI][preJ] < matrix[i][j]) {
                        // 指向当前元素的节点的出度减1，减到0了入队
                        if (--outDegree[preI][preJ] == 0) {
                            queue.offer(new int[] {preI, preJ});
                        }
                    }
                }
            }
        }

        return ans;
    }


    /**
     * 先排序，再从大的数字开始计算
     */
    public int method_3(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        // dp需要先算大的数，再算小的数才能转移，所以，我们先排序一下
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 节点的值及节点的坐标
                list.add(new int[] {matrix[i][j], i, j});
            }
        }

        // 按节点的值排序
        list.sort((a,b)->b[0]-a[0]);

        int ans = 0;
        int[][] dp = new int[m][n];
        // 初始状态全为1
        for (int i = 0; i < m; i++) {
            Arrays.fill(dp[i], 1);
        }

        for (int[] element : list) {
            int val = element[0];
            int i = element[1];
            int j = element[2];
            for (int[] dir : dirs) {
                int nextI = i + dir[0];
                int nextJ = j + dir[1];
                if (nextI >= 0 && nextJ >= 0 && nextI < m && nextJ < n && matrix[nextI][nextJ] > matrix[i][j]) {
                    // 没有越界且相邻的节点值比当前节点大，就可以从它转移而来
                    dp[i][j] = Math.max(dp[i][j], dp[nextI][nextJ] + 1);
                }
            }

            // 记录所有节点出发的最大值
            ans = Math.max(ans, dp[i][j]);
        }

        return ans;
    }

    public static void main(String[] args) {
        LongestIncreasingPath solution = new LongestIncreasingPath();
        int[][] matrix = new int[][]{{9, 9, 4}, {6, 6, 8}, {2, 1, 1}};
        Assert.assertEquals(4, solution.longestIncreasingPath(matrix));
        matrix = new int[][]{{3, 4, 5}, {3, 2, 6}, {2, 2, 1}};
        Assert.assertEquals(4, solution.longestIncreasingPath(matrix));
    }
}
