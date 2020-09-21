package questions.offer;

/**
 * 题目12 矩阵中的路径
 *
 * 判断一个矩阵中是否存在一条包含某字符串所有字符的路径。
 * 路径可以从矩阵中任意一格开始，每一步可以在矩阵中向左、右、上、下移动一格。
 * 如果一条路径经过了矩阵的某一格，那么该路径不能再次进入该格子。
 */
public class PathInMatrix {
    public static boolean hasPath(char[][] matrix, String target) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (trace(matrix, i, j, target, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean trace(char[][] matrix, int row, int col, String target, int len) {
        if (row < 0 || row >= matrix.length || col < 0 || col >= matrix[0].length || len >= target.length()) {
            return false;
        }
        if (matrix[row][col] == '\u0001') {
            return false;
        }
        if (matrix[row][col] != (target.charAt(len))) {
            return false;
        }
        if (len == target.length() - 1 && matrix[row][col] == (target.charAt(len))) {
            return true;
        }
        char old = matrix[row][col];
        matrix[row][col] = '\u0001';
        if (trace(matrix, row - 1, col, target, len + 1)) {
            matrix[row][col] = old;
            return true;
        }
        if (trace(matrix, row + 1, col, target, len + 1)) {
            matrix[row][col] = old;
            return true;
        }
        if (trace(matrix, row, col - 1, target, len + 1)) {
            matrix[row][col] = old;
            return true;
        }
        if (trace(matrix, row, col + 1, target, len + 1)) {
            matrix[row][col] = old;
            return true;
        }
        matrix[row][col] = old;
        return false;
    }
}
