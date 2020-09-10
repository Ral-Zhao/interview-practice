package algorithm;

/**
 * 有一副以二维数组表示的图画，每一个整数表示该图的像素大小，
 * 给你一个坐标（i,j）表示图像渲染开始的像素值（行，列）和一个新的颜色值newColor，
 * 将其相邻区域同样颜色的像素渲染成新的颜色。
 */
public class FloodFill {

    public static void fillColor(int[][] matrix, int i, int j, int newColor) {
        int oldColor = matrix[i][j];
        fill(matrix, i, j, oldColor, newColor);
    }

    private static void fill(int[][] matrix, int i, int j, int oldColor, int newColor) {
        if (!isArea(matrix, i, j)) {
            return;
        }
        if (matrix[i][j] != oldColor) {
            return;
        }

        //此处将访问过的位置置-1作为标志位，防止陷入死循环
        //思想类似回溯算法
        matrix[i][j] = -1;
        fill(matrix, i - 1, j, oldColor, newColor);
        fill(matrix, i + 1, j, oldColor, newColor);
        fill(matrix, i, j - 1, oldColor, newColor);
        fill(matrix, i, j + 1, oldColor, newColor);
        //访问结束后置为新值
        matrix[i][j] = newColor;
    }

    private static boolean isArea(int[][] matrix, int i, int j) {
        return i >= 0 && j >= 0 && i < matrix.length && j < matrix[0].length;
    }

    /**
     * 只将边界的元素渲染
     */
    public static void fillBound(int[][] matrix, int i, int j, int newColor) {
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        int oldColor = matrix[i][j];
        fill(matrix, visited, i, j, oldColor, newColor);
    }

    private static int fill(int[][] matrix, boolean[][] visited, int i, int j, int oldColor, int newColor) {
        if (!isArea(matrix, i, j)) {
            return 1;
        }
        if (visited[i][j]) {
            return 1;
        }
        if (matrix[i][j] != oldColor) {
            return 0;
        }

        visited[i][j] = true;

        int surround =
                fill(matrix, visited, i - 1, j, oldColor, newColor)
                        + fill(matrix, visited, i + 1, j, oldColor, newColor)
                        + fill(matrix, visited, i, j - 1, oldColor, newColor)
                        + fill(matrix, visited, i, j + 1, oldColor, newColor);
        if (surround < 4) {
            matrix[i][j] = newColor;
        }
        return 1;
    }
}
