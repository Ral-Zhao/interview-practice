package questions.leetbook.top_interview_questions.bit;

import org.junit.Assert;

import java.util.HashMap;
import java.util.Map;

/**
 * 给你一个数组 points ，其中 points[i] = [xi, yi] 表示 X-Y 平面上的一个点。求最多有多少个点在同一条直线上。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：points = [[1,1],[2,2],[3,3]]
 * 输出：3
 * 示例 2：
 * <p>
 * <p>
 * 输入：points = [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
 * 输出：4
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= points.length <= 300
 * points[i].length == 2
 * -10^4 <= xi, yi <= 10^4
 * points 中的所有点 互不相同
 * <p>
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions/x2n2g1/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class MaxPoints {
    public int maxPoints(int[][] points) {
        int max = 1;
        for (int i = 0; i < points.length - 1; i++) {
            int same = 0;
            int tempMax = 0;
            Map<String, Integer> map = new HashMap<>();
            for (int j = i + 1; j < points.length; j++) {
                int deltaX = points[i][0] - points[j][0];
                int deltaY = points[i][1] - points[j][1];
                if (deltaX == 0 && deltaY == 0) {
                    same++;
                    continue;
                }
                int gcd = gcd(deltaY, deltaX);
                String key;
                if (gcd != 0) {
                    deltaX = deltaX / gcd;
                    deltaY = deltaY / gcd;
                    key = String.valueOf(deltaY) + "/" + String.valueOf(deltaX);
                }else {
                    key = String.valueOf(points[i][0]);
                }
                int temp = map.getOrDefault(key, 0);
                temp++;
                map.put(key, temp);
                tempMax = Math.max(tempMax, temp);
            }
            max = Math.max(max, tempMax + same + 1);
        }
        return max;
    }

    private int gcd(int a, int b) {
        if (b == 0) {
            return 0;
        }
        if (a % b == 0) {
            return b;
        }
        return gcd(b, a % b);
    }

    public static void main(String[] args) {
        MaxPoints solution = new MaxPoints();
        int[][] points = new int[][]{{1, 1}, {2, 2}, {3, 3}};
        Assert.assertEquals(3, solution.maxPoints(points));
        points = new int[][]{{1, 1}, {3, 2}, {5, 3}, {4, 1}, {2, 3}, {1, 4}};
        Assert.assertEquals(4, solution.maxPoints(points));
        points = new int[][]{{0, 0}};
        Assert.assertEquals(1, solution.maxPoints(points));
        points = new int[][]{{4, 5}, {4, -1}, {4, 0}};
        Assert.assertEquals(3, solution.maxPoints(points));
    }
}
