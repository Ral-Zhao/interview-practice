package questions.offer;



/**
 * 题目13 机器人的运动范围
 *
 * 地上有一个m行n列的方格。一个机器人从坐标（0,0）的格子开始移动，
 * 它每次可以向左、右、上、下移动一格，但不能进入行坐标和列坐标的数位之和大于k的格子。
 * 求出该机器人能够到达多少个格子。
 */
public class RobotMoveRange {
    private int count = 0;

    public int rangeCount(int m, int n, int limit) {
        count = 0;
        int[][] area = new int[m][n];
        trace(area, 0, 0, limit);
        return count;
    }

    private void trace(int[][] area, int row, int col, int limit) {
        if (row < 0 || row >= area.length || col < 0 || col >= area[0].length) {
            return;
        }
        if (area[row][col] == -1) {
            return;
        }
        if (countIndex(row, col) <= limit) {
            count++;
        }
        area[row][col] = -1;
        trace(area, row - 1, col, limit);
        trace(area, row + 1, col, limit);
        trace(area, row, col - 1, limit);
        trace(area, row, col + 1, limit);
    }

    private static int countIndex(int row, int col) {
        int mod;
        int num = 0;
        do {
            mod = row % 10;
            num += mod;
            row = row / 10;
        } while (mod != 0);
        do {
            mod = col % 10;
            num += mod;
            col = col / 10;
        } while (mod != 0);
        return num;
    }

    //public static void main(String[] args) {
    //    int[][] arr = new int[10][10];
    //    int num = 0;
    //    for (int i = 0; i < arr.length; i++) {
    //        for (int j = 0; j < arr[0].length; j++) {
    //            if (countIndex(i, j) <= 8) {
    //                arr[i][j] = -1;
    //                num++;
    //            }
    //        }
    //    }
    //    for (int i = 0; i < arr.length; i++) {
    //        System.out.println(JSON.toJSONString(arr[i]));
    //    }
    //    System.out.println(num);
    //}

}
