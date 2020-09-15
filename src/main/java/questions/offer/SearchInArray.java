package questions.offer;

/**
 * 题目4 二维数组中的查找
 * <p>
 * 在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列按照从上到下递增排序。
 * 给定一个数字，查找二维数组中是否含有该数。
 */
public class SearchInArray {

    public static boolean hasNumber(int[][] nums, int target) {
        if (nums == null || nums.length == 0 || nums[0].length == 0) {
            return false;
        }
        int row = 0;
        int col = nums[0].length - 1;
        //从右上角开始逐渐缩小范围
        while (row < nums.length && col >= 0) {
            if (nums[row][col] == target) {
                return true;
            } else if (nums[row][col] > target) {
                col--;
            } else {
                row++;
            }
        }
        return false;
    }
}
