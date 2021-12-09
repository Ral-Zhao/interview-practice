package questions.leetbook.sliding_window_and_two_pointers;

import org.junit.Assert;

/**
 * 给你一个字符串 S，找出所有长度为 K 且不含重复字符的子串，请你返回全部满足要求的子串的 数目。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：S = "havefunonleetcode", K = 5
 * 输出：6
 * 解释：
 * 这里有 6 个满足题意的子串，分别是：'havef','avefu','vefun','efuno','etcod','tcode'。
 * 示例 2：
 * <p>
 * 输入：S = "home", K = 5
 * 输出：0
 * 解释：
 * 注意：K 可能会大于 S 的长度。在这种情况下，就无法找到任何长度为 K 的子串。
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= S.length <= 10^4
 * S 中的所有字符均为小写英文字母
 * 1 <= K <= 10^4
 * <p>
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/sliding-window-and-two-pointers/ride7h/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class NumKLenSubstrNoRepeats {
    public int numKLenSubstrNoRepeats(String s, int k) {
        if (k > s.length()) {
            return 0;
        }
        int left = 0;
        int right = 0;
        int count = 0;
        int repeatNum = 0;
        int[] counting = new int[26];
        while (right < s.length()) {
            while (right < s.length() && right - left < k) {
                int index = s.charAt(right) - 'a';
                if (counting[index] == 1) {
                    repeatNum++;
                }
                counting[index]++;
                right++;
            }
            if (repeatNum == 0) {
                count++;
            }
            int indexLeft = s.charAt(left) - 'a';
            if (--counting[indexLeft] == 1) {
                repeatNum--;
            }

            left++;
        }
        return count;
    }

    public static void main(String[] args) {
        NumKLenSubstrNoRepeats solution = new NumKLenSubstrNoRepeats();
        Assert.assertEquals(6, solution.numKLenSubstrNoRepeats("havefunonleetcode", 5));
    }
}
