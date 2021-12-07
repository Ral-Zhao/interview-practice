package questions.leetbook.sliding_window_and_two_pointers;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
 * <p>
 * 异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: s = "cbaebabacd", p = "abc"
 * 输出: [0,6]
 * 解释:
 * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
 * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
 *  示例 2:
 * <p>
 * 输入: s = "abab", p = "ab"
 * 输出: [0,1,2]
 * 解释:
 * 起始索引等于 0 的子串是 "ab", 它是 "ab" 的异位词。
 * 起始索引等于 1 的子串是 "ba", 它是 "ab" 的异位词。
 * 起始索引等于 2 的子串是 "ab", 它是 "ab" 的异位词。
 *  
 * <p>
 * 提示:
 * <p>
 * 1 <= s.length, p.length <= 3 * 10^4
 * s 和 p 仅包含小写字母
 * <p>
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/sliding-window-and-two-pointers/riej4c/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class FindAnagrams {
    public List<Integer> findAnagrams(String s, String p) {
        int[] match = new int[26];
        int[] window = new int[26];
        int total = 0;
        int matchNum = 0;
        for (int i = 0; i < p.length(); i++) {
            int index = p.charAt(i) - 'a';
            if (match[index] == 0) {
                total++;
            }
            match[index]++;
        }
        int left = 0;
        int right = 0;
        List<Integer> list = new ArrayList<>();
        while (right < s.length()) {
            while (right < s.length() && right - left < p.length()) {
                int index = s.charAt(right) - 'a';
                right++;
                if (match[index] > 0) {
                    window[index]++;
                    if (window[index] == match[index]) {
                        matchNum++;
                    }
                }
            }
            if (matchNum == total) {
                list.add(left);
            }
            int index = s.charAt(left) - 'a';
            if (match[index] > 0) {
                if (match[index] == window[index]) {
                    matchNum--;
                }
                window[index]--;
            }
            left++;
        }
        return list;
    }

    public static void main(String[] args) {
        FindAnagrams solution = new FindAnagrams();
        List<Integer> list = solution.findAnagrams("cbaebabacd", "abc");
        System.out.println(JSON.toJSONString(list));
        list = solution.findAnagrams("abab", "ab");
        System.out.println(JSON.toJSONString(list));

    }
}
