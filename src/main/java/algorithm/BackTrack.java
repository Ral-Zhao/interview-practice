package algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * 回溯算法举例
 *
 * * 基本思想
 *
 * for 选择 in 选择列表:
 *      # 做选择
 *      将该选择从选择列表移除
 *      路径.add(选择)
 *      backtrack(路径, 选择列表)
 *      # 撤销选择
 *      路径.remove(选择)
 *      将该选择再加入选择列表
 *
 * * 典型问题：排列组合，子集，八皇后问题
 */
public class BackTrack {

    /**
     * 求数组的全排列
     */
    public static List<List<Integer>> permute(int[] nums) {
        //用来保存结果
        List<List<Integer>> result = new ArrayList<>();
        //用来记录访问过的元素
        List<Integer> trace = new ArrayList<>();
        //用来记录访问过的元素在数组中的下标。
        List<Integer> index = new ArrayList<>();
        backTrace(result, index, nums, trace);
        return result;
    }

    private static void backTrace(List<List<Integer>> result, List<Integer> index, int[] nums, List<Integer> trace) {
        if (trace.size() == nums.length) {
            result.add(new ArrayList<>(trace));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            //如果下标访问过就不再访问
            if (index.contains(i)) {
                continue;
            }
            trace.add(nums[i]);
            index.add(i);
            backTrace(result, index, nums, trace);
            trace.remove(trace.size() - 1);
            index.remove(index.size() - 1);
        }
    }

    /**
     * n皇后问题
     *
     * @param n 棋盘的大小
     * @return 所有符合规则的解法
     */
    public static List<int[][]> nQueen(int n) {
        List<int[][]> result = new ArrayList<>();
        int[][] board = new int[n][n];
        backTrace(result, board, 0);
        return result;
    }

    private static void backTrace(List<int[][]> result, int[][] trace, int row) {
        if (trace.length == row) {
            result.add(copyArray(trace));
            return;
        }
        for (int i = 0; i < trace[row].length; i++) {
            if (!isValid(trace, row, i)) {
                continue;
            }
            trace[row][i] = 1;
            backTrace(result, trace, row + 1);
            trace[row][i] = 0;
        }
    }

    private static boolean isValid(int[][] board, int row, int col) {
        int n = board.length;
        // 检查列是否有皇后互相冲突
        for (int i = 0; i < n; i++) {
            if (board[i][col] == 1)
                return false;
        }
        // 检查右上方是否有皇后互相冲突
        for (int i = row - 1, j = col + 1;
             i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 1)
                return false;
        }
        // 检查左上方是否有皇后互相冲突
        for (int i = row - 1, j = col - 1;
             i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1)
                return false;
        }
        return true;
    }

    private static int[][] copyArray(int[][] arr) {
        int[][] res = new int[arr.length][arr[0].length];
        for (int i = 0; i < arr.length; i++) {
            System.arraycopy(arr[i], 0, res[i], 0, arr[0].length);
        }
        return res;
    }

    /**
     * 求一个数组的所有子集
     */
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> trace = new ArrayList<>();
        backTrace(result, trace, nums, 0);
        return result;
    }

    private static void backTrace(List<List<Integer>> result, List<Integer> trace, int[] nums, int index) {
        result.add(new ArrayList<>(trace));
        for (int i = index; i < nums.length; i++) {
            trace.add(nums[i]);
            backTrace(result, trace, nums, i + 1);
            trace.remove(trace.size() - 1);
        }
    }

    /**
     * 组合问题。
     * 输入两个数字 n, k，算法输出 [1..n] 中 k 个数字的所有组合。
     */
    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> trace = new ArrayList<>();
        backTrace(result, trace, 1, n, k);
        return result;
    }

    private static void backTrace(List<List<Integer>> result, List<Integer> trace, int start, int end, int limit) {
        if (trace.size() == limit) {
            result.add(new ArrayList<>(trace));
            return;
        }
        for (int i = start; i <= end; i++) {
            trace.add(i);
            backTrace(result, trace, i + 1, end, limit);
            trace.remove(trace.size() - 1);
        }
    }
}
