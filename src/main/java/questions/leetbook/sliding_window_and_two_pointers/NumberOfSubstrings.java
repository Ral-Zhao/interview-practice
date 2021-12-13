package questions.leetbook.sliding_window_and_two_pointers;

import org.junit.Assert;

/**
 * 给你一个字符串 s ，它只包含三种字符 a, b 和 c 。
 * <p>
 * 请你返回 a，b 和 c 都 至少 出现过一次的子字符串数目。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "abcabc"
 * 输出：10
 * 解释：包含 a，b 和 c 各至少一次的子字符串为 "abc", "abca", "abcab", "abcabc", "bca", "bcab", "bcabc", "cab", "cabc" 和 "abc" (相同字符串算多次)。
 * 示例 2：
 * <p>
 * 输入：s = "aaacb"
 * 输出：3
 * 解释：包含 a，b 和 c 各至少一次的子字符串为 "aaacb", "aacb" 和 "acb" 。
 * 示例 3：
 * <p>
 * 输入：s = "abc"
 * 输出：1
 *  
 * <p>
 * 提示：
 * <p>
 * 3 <= s.length <= 5 x 10^4
 * s 只包含字符 a，b 和 c 。
 * <p>
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/sliding-window-and-two-pointers/riz1yr/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class NumberOfSubstrings {
    public int numberOfSubstrings(String s) {
        int left = 0;
        int right = 0;
        int count = 0;
        int[] counting = new int[3];
        int charCount = 0;
        while (right < s.length()) {
            while (right < s.length() && charCount < 3) {
                int index = s.charAt(right) - 'a';
                counting[index]++;
                if (counting[index] == 1) {
                    charCount++;
                }
                right++;
            }
            while (charCount == 3) {
                count += s.length() - right+1;
                int index = s.charAt(left) - 'a';
                counting[index]--;
                if (counting[index] == 0) {
                    charCount--;
                }
                left++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        NumberOfSubstrings solution = new NumberOfSubstrings();
        Assert.assertEquals(10, solution.numberOfSubstrings("abcabc"));
        Assert.assertEquals(3, solution.numberOfSubstrings("aaacb"));
        Assert.assertEquals(1, solution.numberOfSubstrings("abc"));
        Assert.assertEquals(0, solution.numberOfSubstrings("abab"));
    }
}
