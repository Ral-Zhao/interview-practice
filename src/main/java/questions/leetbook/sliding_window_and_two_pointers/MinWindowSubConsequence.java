package questions.leetbook.sliding_window_and_two_pointers;

import org.junit.Assert;

/**
 * 给定字符串 S and T，找出 S 中最短的（连续）子串 W ，使得 T 是 W 的 子序列 。
 * <p>
 * 如果 S 中没有窗口可以包含 T 中的所有字符，返回空字符串 ""。如果有不止一个最短长度的窗口，返回开始位置最靠左的那个。
 * <p>
 * 示例 1：
 * <p>
 * 输入：
 * S = "abcdebdde", T = "bde"
 * 输出："bcde"
 * 解释：
 * "bcde" 是答案，因为它在相同长度的字符串 "bdde" 出现之前。
 * "deb" 不是一个更短的答案，因为在窗口中必须按顺序出现 T 中的元素。
 *  
 * <p>
 * 注：
 * <p>
 * 所有输入的字符串都只包含小写字母。All the strings in the input will only contain lowercase letters.
 * S 长度的范围为 [1, 20000]。
 * T 长度的范围为 [1, 100]。
 * <p>
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/sliding-window-and-two-pointers/riwpld/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class MinWindowSubConsequence {
    public String minWindow(String s1, String s2) {
        int targetIndex = 0;
        int left = 0;
        int right = 0;
        int len = s1.length() + 1;
        int minLeft = 0;
        while (right < s1.length()) {
            while (right < s1.length() && targetIndex < s2.length()) {
                if (s1.charAt(right) == s2.charAt(targetIndex)) {
                    targetIndex++;
                }
                right++;
            }
            if (targetIndex == s2.length()) {
                left = right - 1;
                targetIndex--;
                while (left >= 0 && targetIndex >= 0) {
                    if (s1.charAt(left) == s2.charAt(targetIndex)) {
                        targetIndex--;
                    }
                    left--;
                }
                if (right - left - 1 < len) {
                    len = right - left - 1;
                    minLeft = left + 1;
                }
                targetIndex = 0;
                right = left + 2;
            }
        }
        if (len == s1.length() + 1) {
            return "";
        }
        return s1.substring(minLeft, minLeft + len);
    }

    public static void main(String[] args) {
        MinWindowSubConsequence solution = new MinWindowSubConsequence();
        Assert.assertEquals("bcde", solution.minWindow("abcdebdde", "bde"));
        Assert.assertEquals("czm", solution.minWindow("cnhczmccqouqadqtmjjzl", "cm"));
        Assert.assertEquals("mccqouqadqtm", solution.minWindow("cnhczmccqouqadqtmjjzl", "mm"));
        Assert.assertEquals("l", solution.minWindow("jmeqksfrsdcmsiwvaovztaqenprpvnbstl", "l"));
        Assert.assertEquals("fgrqsqsnodwmxzk", solution.minWindow("fgrqsqsnodwmxzkzxwqegkndaa", "fnok"));
        Assert.assertEquals("nevavyrpduigitmrimtaslzboauwbluvlfqquocxrzrbvvplsivujojscytmeyjolvvyzwizpuhejsdzkfwgqdbwinkxqypaph", solution.minWindow("ffynmlzesdshlvugsigobutgaetsnjlizvqjdpccdylclqcbghhixpjihximvhapymfkjxyyxfwvsfyctmhwmfjyjidnfryiyajmtakisaxwglwpqaxaicuprrvxybzdxunypzofhpclqiybgniqzsdeqwrdsfjyfkgmejxfqjkmukvgygafwokeoeglanevavyrpduigitmrimtaslzboauwbluvlfqquocxrzrbvvplsivujojscytmeyjolvvyzwizpuhejsdzkfwgqdbwinkxqypaphktonqwwanapouqyjdbptqfowhemsnsl", "ntimcimzah"));
    }
}
