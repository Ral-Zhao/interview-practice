package questions.offer;

/**
 *  题目48 最长不含重复字符的子字符串
 *
 *  请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
 *  假设字符串中只包含a~z的字符。
 */
public class LongestSubstringWithoutDup {
    public static int length(String string) {
        if (string == null || string.length() == 0) {
            return 0;
        }
        int len = string.length();
        int max = 1;
        int[] dp = new int[len];
        dp[0] = 1;
        int[] pos = new int[26];
        for (int i = 0; i < pos.length; i++) {
            pos[i] = -1;
        }
        pos[string.charAt(0) - 'a'] = 0;
        for (int i = 1; i < len; i++) {
            int charPos = string.charAt(i) - 'a';
            if (pos[charPos] == -1) {
                dp[i] = dp[i - 1]+1;
            } else {
                int distance = i - pos[charPos];
                if (distance > dp[i - 1]) {
                    dp[i] = dp[i - 1] + 1;
                } else {
                    dp[i] = distance;
                }
            }
            pos[charPos] = i;
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
