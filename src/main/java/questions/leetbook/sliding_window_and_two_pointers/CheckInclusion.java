package questions.leetbook.sliding_window_and_two_pointers;

import org.junit.Assert;

/**
 * 给你两个字符串 s1 和 s2 ，写一个函数来判断 s2 是否包含 s1 的排列。如果是，返回 true ；否则，返回 false 。
 * <p>
 * 换句话说，s1 的排列之一是 s2 的 子串 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：s1 = "ab" s2 = "eidbaooo"
 * 输出：true
 * 解释：s2 包含 s1 的排列之一 ("ba").
 * 示例 2：
 * <p>
 * 输入：s1= "ab" s2 = "eidboaoo"
 * 输出：false
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= s1.length, s2.length <= 104
 * s1 和 s2 仅包含小写字母
 * <p>
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/sliding-window-and-two-pointers/rioysi/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class CheckInclusion {
    public boolean checkInclusion(String s1, String s2) {
        int[] match = new int[26];
        int[] window = new int[26];
        int total = 0;
        int matchNum = 0;
        for (int i = 0; i < s1.length(); i++) {
            int index = s1.charAt(i) - 'a';
            if (match[index] == 0) {
                total++;
            }
            match[index]++;
        }
        int left = 0;
        int right = 0;
        while (right < s2.length()) {
            while (right < s2.length() && right - left < s1.length()) {
                int index = s2.charAt(right) - 'a';
                right++;
                if (match[index] > 0) {
                    window[index]++;
                    if (window[index] == match[index]) {
                        matchNum++;
                    }
                }
            }
            if (matchNum == total) {
                return true;
            }
            int index = s2.charAt(left) - 'a';
            if (match[index] > 0) {
                if (match[index] == window[index]) {
                    matchNum--;
                }
                window[index]--;
            }
            left++;
        }
        return false;
    }

    public static void main(String[] args) {
        CheckInclusion solution = new CheckInclusion();
        Assert.assertTrue(solution.checkInclusion("ab", "eidbaooo"));
        Assert.assertTrue(!solution.checkInclusion("ab", "eidboaoo"));
    }
}
