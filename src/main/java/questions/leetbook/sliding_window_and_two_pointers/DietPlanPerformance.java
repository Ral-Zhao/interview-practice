package questions.leetbook.sliding_window_and_two_pointers;

import org.junit.Assert;

/**
 * 你的好友是一位健身爱好者。前段日子，他给自己制定了一份健身计划。现在想请你帮他评估一下这份计划是否合理。
 * <p>
 * 他会有一份计划消耗的卡路里表，其中 calories[i] 给出了你的这位好友在第 i 天需要消耗的卡路里总量。
 * <p>
 * 为了更好地评估这份计划，对于卡路里表中的每一天，你都需要计算他 「这一天以及之后的连续几天」 （共 k 天）内消耗的总卡路里 T：
 * <p>
 * 如果 T < lower，那么这份计划相对糟糕，并失去 1 分； 
 * 如果 T > upper，那么这份计划相对优秀，并获得 1 分；
 * 否则，这份计划普普通通，分值不做变动。
 * 请返回统计完所有 calories.length 天后得到的总分作为评估结果。
 * <p>
 * 注意：总分可能是负数。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：calories = [1,2,3,4,5], k = 1, lower = 3, upper = 3
 * 输出：0
 * 解释：calories[0], calories[1] < lower 而 calories[3], calories[4] > upper, 总分 = 0.
 * 示例 2：
 * <p>
 * 输入：calories = [3,2], k = 2, lower = 0, upper = 1
 * 输出：1
 * 解释：calories[0] + calories[1] > upper, 总分 = 1.
 * 示例 3：
 * <p>
 * 输入：calories = [6,5,0,0], k = 2, lower = 1, upper = 5
 * 输出：0
 * 解释：calories[0] + calories[1] > upper, calories[2] + calories[3] < lower, 总分 = 0.
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= k <= calories.length <= 10^5
 * 0 <= calories[i] <= 20000
 * 0 <= lower <= upper
 * <p>
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/sliding-window-and-two-pointers/ri0jwm/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class DietPlanPerformance {
    public int dietPlanPerformance(int[] calories, int k, int lower, int upper) {
        int left = 0;
        int right = 0;
        int score = 0;
        int sum = 0;
        while (right < calories.length) {
            while (right < calories.length && right - left < k) {
                sum += calories[right];
                right++;
            }
            if (sum < lower) {
                score -= 1;
            } else if (sum > upper) {
                score += 1;
            }
            sum -= calories[left];
            left++;
        }
        return score;
    }

    public static void main(String[] args) {
        DietPlanPerformance solution = new DietPlanPerformance();
        int[] calories = new int[]{1, 2, 3, 4, 5};
        Assert.assertEquals(0, solution.dietPlanPerformance(calories, 1, 3, 3));
        calories = new int[]{3, 2};
        Assert.assertEquals(1, solution.dietPlanPerformance(calories, 2, 0, 1));
        calories = new int[]{6, 5, 0, 0};
        Assert.assertEquals(0, solution.dietPlanPerformance(calories, 2, 1, 5));
    }
}
