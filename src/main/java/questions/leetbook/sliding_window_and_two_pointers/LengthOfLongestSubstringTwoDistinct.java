package questions.leetbook.sliding_window_and_two_pointers;

import org.junit.Assert;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个字符串 s ，找出 至多 包含两个不同字符的最长子串 t ，并返回该子串的长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "eceba"
 * 输出: 3
 * 解释: t 是 "ece"，长度为3。
 * 示例 2:
 * <p>
 * 输入: "ccaabbb"
 * 输出: 5
 * 解释: t 是 "aabbb"，长度为5。
 * <p>
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/sliding-window-and-two-pointers/ritur2/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class LengthOfLongestSubstringTwoDistinct {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int right = 0;
        int left = 0;
        int charNum = 0;
        int max = 0;
        Map<Character, Integer> map = new HashMap<>();
        while (right < s.length()) {
            while (right < s.length() && charNum <= 2) {
                max = Math.max(max, right - left);
                char ch = s.charAt(right);
                int num = map.getOrDefault(ch, 0);
                map.put(ch, num + 1);
                if (num == 0) {
                    charNum++;
                }
                right++;
            }

            while (charNum > 2) {
                char ch = s.charAt(left);
                int num = map.getOrDefault(ch, 0);
                map.put(ch, num - 1);
                if (num == 1) {
                    charNum--;
                }
                left++;
            }
            max = Math.max(max, right - left);
        }
        return max;
    }

    public static void main(String[] args) {
        LengthOfLongestSubstringTwoDistinct solution = new LengthOfLongestSubstringTwoDistinct();
        Assert.assertEquals(3, solution.lengthOfLongestSubstringTwoDistinct("eceba"));
        Assert.assertEquals(5, solution.lengthOfLongestSubstringTwoDistinct("ccaabbb"));
    }
}
