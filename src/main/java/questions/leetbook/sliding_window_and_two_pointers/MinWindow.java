package questions.leetbook.sliding_window_and_two_pointers;

import org.junit.Assert;

/**
 * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
 * <p>
 *  
 * <p>
 * 注意：
 * <p>
 * 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。
 * 如果 s 中存在这样的子串，我们保证它是唯一的答案。
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "ADOBECODEBANC", t = "ABC"
 * 输出："BANC"
 * 示例 2：
 * <p>
 * 输入：s = "a", t = "a"
 * 输出："a"
 * 示例 3:
 * <p>
 * 输入: s = "a", t = "aa"
 * 输出: ""
 * 解释: t 中两个字符 'a' 均应包含在 s 的子串中，
 * 因此没有符合条件的子字符串，返回空字符串。
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length, t.length <= 10^5
 * s 和 t 由英文字母组成
 *  
 * <p>
 * 进阶：你能设计一个在 o(n) 时间内解决此问题的算法吗？
 * <p>
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/sliding-window-and-two-pointers/rly4ps/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class MinWindow {
    public String minWindow(String s, String t) {
        if (t.length() > s.length()) {
            return "";
        }
        int[] match = new int[100];
        int[] window = new int[100];
        int total = 0;
        for (int i = 0; i < t.length(); i++) {
            int index = t.charAt(i) - 'A';
            if (match[index] == 0) {
                total++;
            }
            match[index]++;
        }
        int right = 0;
        int left = 0;
        int leftMin = 0;
        int matchNum = 0;
        int min = s.length() + 1;
        while (right < s.length()) {
            int index = s.charAt(right) - 'A';
            if (match[index] > 0) {
                window[index]++;
                if (window[index] == match[index]) {
                    matchNum++;
                }
            }
            right++;

            while (left < right && matchNum == total) {
                if (right - left < min) {
                    leftMin = left;
                    min = right - left;
                }
                int leftIndex = s.charAt(left) - 'A';
                if (match[leftIndex] > 0) {
                    window[leftIndex]--;
                    if (window[leftIndex]<match[leftIndex]){
                        matchNum--;
                    }
                }
                left++;
            }
        }
        return min == s.length() + 1 ? "" : s.substring(leftMin, leftMin + min);
    }

    public static void main(String[] args) {
        MinWindow solution = new MinWindow();
        Assert.assertEquals("BANC", solution.minWindow("ADOBECODEBANC", "ABC"));
        Assert.assertEquals("a", solution.minWindow("a", "a"));
    }
}
