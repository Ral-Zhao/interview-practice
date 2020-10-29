package questions.offer;

/**
 *  题目29 顺时针打印矩阵
 *
 *  输入一个矩阵，按照从外向里以顺时针次序依次打印每一个数字。
 */
public class PrintMatrix {
    public static void printMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return;
        }
        int startX = 0;
        int startY = 0;
        int rowBound = matrix.length;
        int colBound = matrix[0].length;
        while (startX * startX < rowBound && startY * startY < colBound) {
            int xRoundEnd = rowBound - 1 - startX;
            int yRoundEnd = colBound - 1 - startY;
            int currentY = startY;
            int currentX = startX;
            for (; currentY <= yRoundEnd; currentY++) {
                System.out.print(matrix[currentX][currentY] + " ");
            }
            currentX = currentX + 1;
            currentY--;
            for (; currentX <= xRoundEnd; currentX++) {
                System.out.print(matrix[currentX][currentY] + " ");
            }
            currentX--;
            currentY = currentY - 1;
            for (; currentY >= startY && currentX > startX; currentY--) {
                System.out.print(matrix[currentX][currentY] + " ");
            }
            currentY++;
            currentX = currentX - 1;
            for (; currentX > startX; currentX--) {
                System.out.print(matrix[currentX][currentY] + " ");
            }

            startX++;
            startY++;
        }
        System.out.println();
    }
}
