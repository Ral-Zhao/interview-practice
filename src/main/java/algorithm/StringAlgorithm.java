package algorithm;

/**
 */
public class StringAlgorithm {

    /**
     * 编辑距离
     */
    public static int editDistance(String s1, String s2) {
        if (s1 == null && s2 == null) {
            return 0;
        } else if (s1 == null || s1.length() == 0) {
            return s2.length();
        } else if (s2 == null || s2.length() == 0) {
            return s1.length();
        }
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        for (int i = 0; i <= s1.length(); i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i <= s2.length(); i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1] + 1, Math.min(dp[i][j - 1] + 1, dp[i - 1][j] + 1));
                }
            }
        }
        return dp[s1.length()][s2.length()];
    }

    /**
     * KMP算法求子序列
     */
    public static int kmp(String s, String t) {
        if (s == null || t == null) {
            return -1;
        }
        int[] next = getNext(t);
        int i = 0;
        int j = 0;
        while (i < s.length() && j < t.length()) {
            if (j == -1 || s.charAt(i) == t.charAt(j)) {
                i++;
                j++;
            } else {
                j = next[j];
            }
        }
        if (j >= t.length()) {
            return i - t.length();
        }
        return -1;
    }

    private static int[] getNext(String t) {
        /*
            next数组的意思就是 next[i] = len; 长度为i的数组的前缀和后缀相等的最大长度。
            例如abcdabc就是 next[7] = 3; 相等的前缀和后缀最长是abc长度为3.
         */
        int[] next = new int[t.length() + 1];
        int i = 0;
        int k = -1;
        next[0] = -1;
        while (i < t.length()) {
            if (k == -1 || t.charAt(i) == t.charAt(k)) {
                k++;
                i++;
                next[i] = k;
            } else {
                k = next[k];
            }
        }
        return next;
    }
}
