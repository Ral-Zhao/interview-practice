package algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 利用滑动窗口解决字符串子串匹配问题
 *
 * 滑动窗口算法的思路是这样：
 *
 * 1、我们在字符串 S 中使用双指针中的左右指针技巧，初始化 left = right = 0，把索引闭区间 [left, right] 称为一个「窗口」。
 *
 * 2、我们先不断地增加 right 指针扩大窗口 [left, right]，直到窗口中的字符串符合要求（包含了 T 中的所有字符）。
 *
 * 3、此时，我们停止增加 right，转而不断增加 left 指针缩小窗口 [left, right]，直到窗口中的字符串不再符合要求（不包含 T 中的所有字符了）。同时，每次增加 left，我们都要更新一轮结果。
 *
 * 4、重复第 2 和第 3 步，直到 right 到达字符串 S 的尽头。
 *
 *  *模式
 *  int left = 0, right = 0;
 *
 * while (right < s.size()) {
 *     window.add(s[right]);
 *     right++;
 *
 *     while (valid) {
 *         window.remove(s[left]);
 *         left++;
 *     }
 * }
 */
public class StringSlideWindow {

    /**
     * 给定字符串S、字符串T，在S中找出包含T的所有字母的最小子串。
     */
    public static String minSubStringCovered(String source, String target) {
        Map<Character, Integer> needs = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        for (int i = 0; i < target.length(); i++) {
            needs.put(target.charAt(i), needs.getOrDefault(target.charAt(i), 0) + 1);
        }
        int left = 0;
        int right = 0;
        int match = 0;
        int minLen = source.length();
        String result = "";
        while (right < source.length()) {
            Character rightChar = source.charAt(right);
            if (needs.containsKey(rightChar)) {
                window.put(rightChar, window.getOrDefault(rightChar, 0) + 1);
                if (needs.get(rightChar) == window.get(rightChar)) {
                    match++;
                }
            }
            right++;

            while (match == target.length()) {
                if (right - left < minLen) {
                    minLen = right - left;
                    result = source.substring(left, right);
                }
                Character ch = source.charAt(left);
                if (window.containsKey(ch)) {
                    window.put(ch, window.get(ch) - 1);
                    if (window.get(ch) < needs.get(ch)) {
                        match--;
                    }
                }
                left++;
            }
        }

        return result;
    }

    /**
     * 给定字符串S、字符串T，在S中找出所有是T的字母异位词的子串，返回这些子串的索引。
     * 字母异位词指字母相同，排列不同的字符串。
     */
    public static List<Integer> findAnagrams(String source, String target) {
        Map<Character, Integer> needs = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < target.length(); i++) {
            needs.put(target.charAt(i), needs.getOrDefault(target.charAt(i), 0) + 1);
        }
        int left = 0;
        int right = 0;
        int match = 0;
        while (right < source.length()) {
            Character rightChar = source.charAt(right);
            if (needs.containsKey(rightChar)) {
                window.put(rightChar, window.getOrDefault(rightChar, 0) + 1);
                if (needs.get(rightChar) == window.get(rightChar)) {
                    match++;
                }
            }
            right++;

            while (match == target.length()) {
                if (right - left == target.length()) {
                    result.add(left);
                }
                Character ch = source.charAt(left);
                if (window.containsKey(ch)) {
                    window.put(ch, window.get(ch) - 1);
                    if (window.get(ch) < needs.get(ch)) {
                        match--;
                    }
                }
                left++;
            }
        }

        return result;
    }

    /**
     * 给定字符串S，找出其中不含有重复字符的最长子串的长度.
     */
    public static int lengthOfLongestSubstring(String source) {
        Map<Character, Integer> window = new HashMap<>();
        int left = 0;
        int right = 0;
        int max = 0;
        while (right < source.length()) {
            Character rightChar = source.charAt(right);
            window.put(rightChar, window.getOrDefault(rightChar, 0) + 1);
            right++;

            while (window.get(rightChar) > 1) {
                Character leftChar = source.charAt(left);
                window.put(leftChar, window.get(leftChar) - 1);
                left++;
            }
            max = Math.max(max, right - left);
        }

        return max;
    }
}
