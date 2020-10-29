package questions.offer;

import org.junit.Test;

public class PrintMatrixTest {
    @Test
    public void test() {
        int[][] matrix = new int[][]{
                {1, 2, 3, 4},
                {11, 12, 13, 14},
                {21, 22, 23, 24},
                {31, 32, 33, 34}
        };
        PrintMatrix.printMatrix(matrix);

        matrix = new int[][]{
                {1, 2, 3, 4, 5, 6, 7},
                {11, 12, 13, 14, 15, 16, 17},
                {21, 22, 23, 24, 25, 26, 27},
                {31, 32, 33, 34, 35, 36, 37}
        };
        PrintMatrix.printMatrix(matrix);

        matrix = new int[][]{
                {1, 2, 3, 4, 5, 6, 7},
                {11, 12, 13, 14, 15, 16, 17},
                {21, 22, 23, 24, 25, 26, 27}
        };
        PrintMatrix.printMatrix(matrix);

        matrix = new int[][]{
                {1, 2, 3},
                {11, 12, 13},
                {21, 22, 23},
                {31, 32, 33}
        };
        PrintMatrix.printMatrix(matrix);

        matrix = new int[][]{
                {1, 2, 3},
                {11, 12, 13},
                {21, 22, 23},
        };
        PrintMatrix.printMatrix(matrix);


    }
}
