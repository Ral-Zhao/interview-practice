package questions.leetbook.sliding_window_and_two_pointers;

import org.junit.Assert;

/**
 * 给你两个长度相同的字符串，s 和 t。
 * <p>
 * 将 s 中的第 i 个字符变到 t 中的第 i 个字符需要 |s[i] - t[i]| 的开销（开销可能为 0），也就是两个字符的 ASCII 码值的差的绝对值。
 * <p>
 * 用于变更字符串的最大预算是 maxCost。在转化字符串时，总开销应当小于等于该预算，这也意味着字符串的转化可能是不完全的。
 * <p>
 * 如果你可以将 s 的子字符串转化为它在 t 中对应的子字符串，则返回可以转化的最大长度。
 * <p>
 * 如果 s 中没有子字符串可以转化成 t 中对应的子字符串，则返回 0。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "abcd", t = "bcdf", maxCost = 3
 * 输出：3
 * 解释：s 中的 "abc" 可以变为 "bcd"。开销为 3，所以最大长度为 3。
 * 示例 2：
 * <p>
 * 输入：s = "abcd", t = "cdef", maxCost = 3
 * 输出：1
 * 解释：s 中的任一字符要想变成 t 中对应的字符，其开销都是 2。因此，最大长度为 1。
 * 示例 3：
 * <p>
 * 输入：s = "abcd", t = "acde", maxCost = 0
 * 输出：1
 * 解释：a -> a, cost = 0，字符串未发生变化，所以最大长度为 1。
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length, t.length <= 10^5
 * 0 <= maxCost <= 10^6
 * s 和 t 都只含小写英文字母。
 * <p>
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/sliding-window-and-two-pointers/rim36v/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class EqualSubstring {
    public int equalSubstring(String s, String t, int maxCost) {
        int left = 0;
        int right = 0;
        int cost = 0;
        int max = 0;
        while (right < s.length()) {
            while (right < s.length() && cost <= maxCost) {
                max = Math.max(max, right - left);
                cost += Math.abs(s.charAt(right) - t.charAt(right));
                right++;
            }
            while (left < right && cost > maxCost) {
                cost -= Math.abs(s.charAt(left) - t.charAt(left));
                left++;
            }
            max = Math.max(max, right - left);
        }

        return max;
    }

    public static void main(String[] args) {
        EqualSubstring solution = new EqualSubstring();
        Assert.assertEquals(3, solution.equalSubstring("abcd", "bcdf", 3));
        Assert.assertEquals(1, solution.equalSubstring("abcd", "cdef", 3));
        Assert.assertEquals(1, solution.equalSubstring("abcd", "acde", 0));
    }
}
