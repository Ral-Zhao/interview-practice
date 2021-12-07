package questions.leetbook.sliding_window_and_two_pointers;

import org.junit.Assert;

/**
 * 给你一个仅由大写英文字母组成的字符串，你可以将任意位置上的字符替换成另外的字符，总共可最多替换 k 次。
 * 在执行上述操作后，找到包含重复字母的最长子串的长度。
 * <p>
 * 注意：字符串长度 和 k 不会超过 10^4。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "ABAB", k = 2
 * 输出：4
 * 解释：用两个'A'替换为两个'B',反之亦然。
 * 示例 2：
 * <p>
 * 输入：s = "AABABBA", k = 1
 * 输出：4
 * 解释：
 * 将中间的一个'A'替换为'B',字符串变为 "AABBBBA"。
 * 子串 "BBBB" 有最长重复字母, 答案为 4。
 * <p>
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/sliding-window-and-two-pointers/rlbqoh/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class CharacterReplacement {
    public int characterReplacement(String s, int k) {
        int[] counting = new int[26];
        int right = 0;
        int left = 0;
        int max = 0;
        int maxIndex = 0;
        while (right < s.length()) {
            int index = s.charAt(right) - 'A';
            counting[index]++;
            right++;
            if (counting[index] > counting[maxIndex]) {
                maxIndex = index;
            }
            if (right - left - counting[maxIndex] > k) {
                int leftIndex = s.charAt(left) - 'A';
                counting[leftIndex]--;
                left++;
            }
            max = Math.max(max, right - left);
        }
        return max;
    }

    public static void main(String[] args) {
        CharacterReplacement solution = new CharacterReplacement();
        Assert.assertEquals(4, solution.characterReplacement("ABAB", 2));
        Assert.assertEquals(4, solution.characterReplacement("AABABBA", 1));
    }
}
