package questions.leetbook.sliding_window_and_two_pointers;

import org.junit.Assert;

/**
 * 给你字符串 s 和整数 k 。
 * <p>
 * 请返回字符串 s 中长度为 k 的单个子字符串中可能包含的最大元音字母数。
 * <p>
 * 英文中的 元音字母 为（a, e, i, o, u）。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "abciiidef", k = 3
 * 输出：3
 * 解释：子字符串 "iii" 包含 3 个元音字母。
 * 示例 2：
 * <p>
 * 输入：s = "aeiou", k = 2
 * 输出：2
 * 解释：任意长度为 2 的子字符串都包含 2 个元音字母。
 * 示例 3：
 * <p>
 * 输入：s = "leetcode", k = 3
 * 输出：2
 * 解释："lee"、"eet" 和 "ode" 都包含 2 个元音字母。
 * 示例 4：
 * <p>
 * 输入：s = "rhythms", k = 4
 * 输出：0
 * 解释：字符串 s 中不含任何元音字母。
 * 示例 5：
 * <p>
 * 输入：s = "tryhard", k = 4
 * 输出：1
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 10^5
 * s 由小写英文字母组成
 * 1 <= k <= s.length
 * <p>
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/sliding-window-and-two-pointers/rl45nj/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class MaxVowels {
    public int maxVowels(String s, int k) {
        int left = 0;
        int right = 0;
        int sum = 0;
        int max = 0;
        while (right < s.length()) {
            while (right < s.length() && right - left < k) {
                if (isVowel(s.charAt(right))) {
                    sum++;
                }
                right++;
            }
            max = Math.max(max, sum);
            if (isVowel(s.charAt(left))) {
                sum--;
            }
            left++;
        }
        return max;
    }

    private boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }

    public static void main(String[] args) {
        MaxVowels solution = new MaxVowels();
        Assert.assertEquals(3, solution.maxVowels("abciiidef", 3));
        Assert.assertEquals(2, solution.maxVowels("aeiou", 2));
        Assert.assertEquals(2, solution.maxVowels("leetcode", 3));
        Assert.assertEquals(0, solution.maxVowels("rhythms", 4));
        Assert.assertEquals(1, solution.maxVowels("tryhard", 4));
    }
}
