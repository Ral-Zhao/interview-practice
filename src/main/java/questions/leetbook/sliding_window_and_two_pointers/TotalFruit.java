package questions.leetbook.sliding_window_and_two_pointers;

import org.junit.Assert;

/**
 * 在一排树中，第 i 棵树产生 tree[i] 型的水果。
 * 你可以从你选择的任何树开始，然后重复执行以下步骤：
 * <p>
 * 把这棵树上的水果放进你的篮子里。如果你做不到，就停下来。
 * 移动到当前树右侧的下一棵树。如果右边没有树，就停下来。
 * 请注意，在选择一颗树后，你没有任何选择：你必须执行步骤 1，然后执行步骤 2，然后返回步骤 1，然后执行步骤 2，依此类推，直至停止。
 * <p>
 * 你有两个篮子，每个篮子可以携带任何数量的水果，但你希望每个篮子只携带一种类型的水果。
 * <p>
 * 用这个程序你能收集的水果树的最大总量是多少？
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：[1,2,1]
 * 输出：3
 * 解释：我们可以收集 [1,2,1]。
 * 示例 2：
 * <p>
 * 输入：[0,1,2,2]
 * 输出：3
 * 解释：我们可以收集 [1,2,2]
 * 如果我们从第一棵树开始，我们将只能收集到 [0, 1]。
 * 示例 3：
 * <p>
 * 输入：[1,2,3,2,2]
 * 输出：4
 * 解释：我们可以收集 [2,3,2,2]
 * 如果我们从第一棵树开始，我们将只能收集到 [1, 2]。
 * 示例 4：
 * <p>
 * 输入：[3,3,3,1,2,1,1,2,3,3,4]
 * 输出：5
 * 解释：我们可以收集 [1,2,1,1,2]
 * 如果我们从第一棵树或第八棵树开始，我们将只能收集到 4 棵水果树。
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= tree.length <= 40000
 * 0 <= tree[i] < tree.length
 * <p>
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/sliding-window-and-two-pointers/rigbct/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class TotalFruit {
    public int totalFruit(int[] fruits) {
        if (fruits.length < 2) {
            return fruits.length;
        }
        int left = 0;
        int right = 0;
        int max = 0;
        int[] counting = new int[fruits.length];
        int fruitCount = 0;
        while (right < fruits.length) {
            while (right < fruits.length && fruitCount < 3) {
                counting[fruits[right]]++;
                if (counting[fruits[right]] == 1) {
                    fruitCount++;
                }
                if (fruitCount < 3) {
                    max = Math.max(max, right - left + 1);
                }
                right++;
            }
            while (fruitCount >= 3) {
                counting[fruits[left]]--;
                if (counting[fruits[left]] == 0) {
                    fruitCount--;
                }
                left++;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        TotalFruit solution = new TotalFruit();
        int[] fruits = new int[]{1, 2, 1};
        Assert.assertEquals(3, solution.totalFruit(fruits));
        fruits = new int[]{0, 1, 2, 2};
        Assert.assertEquals(3, solution.totalFruit(fruits));
        fruits = new int[]{1, 2, 3, 2, 2};
        Assert.assertEquals(4, solution.totalFruit(fruits));
        fruits = new int[]{3, 3, 3, 1, 2, 1, 1, 2, 3, 3, 4};
        Assert.assertEquals(5, solution.totalFruit(fruits));
    }
}
