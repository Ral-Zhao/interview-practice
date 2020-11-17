package questions.offer;

import java.util.HashMap;
import java.util.Map;

/**
 * 题目50-1 字符串中第一个只出现一次的字符
 * <p>
 * 在字符串中找出第一个只出现一次的字符。
 */
public class FirstNotRepeatingChar {
    public static char firstChar(String string) {
        if (string == null || string.length() == 0) {
            return ' ';
        }
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < string.length(); i++) {
            char ch = string.charAt(i);
            Integer pre = map.putIfAbsent(ch, 1);
            if (pre != null) {
                map.put(ch, pre + 1);
            }
        }
        for (int i = 0; i < string.length(); i++) {
            char ch = string.charAt(i);
            if (map.get(ch) == 1) {
                return ch;
            }
        }
        return ' ';
    }
}
