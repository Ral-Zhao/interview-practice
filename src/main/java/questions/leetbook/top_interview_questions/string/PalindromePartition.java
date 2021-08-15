package questions.leetbook.top_interview_questions.string;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。
 * <p>
 * 回文串 是正着读和反着读都一样的字符串。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "aab"
 * 输出：[["a","a","b"],["aa","b"]]
 * 示例 2：
 * <p>
 * 输入：s = "a"
 * 输出：[["a"]]
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 16
 * s 仅由小写英文字母组成
 * <p>
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions/xaxi62/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class PalindromePartition {
    public List<List<String>> partition(String s) {
        List<String> list = new ArrayList<>();
        List<List<String>> result = new ArrayList<>();
        helper(result, list, s);
        return result;
    }

    private void helper(List<List<String>> result, List<String> list, String target) {
        if (target.isEmpty()) {
            List<String> newList = new ArrayList<>(list);
            result.add(newList);
            return;
        }
        String temp = "";
        for (int i = 0; i < target.length(); i++) {
            temp += target.charAt(i);
            if (isPalindrome(temp)) {
                list.add(temp);
                helper(result, list, target.substring(i + 1));
                list.remove(list.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String target) {
        if (target.isEmpty()) {
            return false;
        }
        if (target.length() == 1) {
            return true;
        }
        int left = 0;
        int right = target.length() - 1;
        while (left < right) {
            if (target.charAt(left) != target.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    /**
     * DP
     */
    public List<List<String>> partition_2(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int i = dp.length; i >= 0; i--) {
            for (int j = i; j < dp[0].length; j++) {
                if (i == j) {
                    dp[i][j] = true;
                    continue;
                }
                if (s.charAt(i) == s.charAt(j)) {
                    if (i + 1 == j) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
            }
        }
        List<String> list = new ArrayList<>();
        List<List<String>> result = new ArrayList<>();
        helper(result, list, dp, 0, s);
        return result;
    }

    private void helper(List<List<String>> result, List<String> list, boolean[][] dp, int index, String s) {
        if (index >= dp.length) {
            List<String> newList = new ArrayList<>(list);
            result.add(newList);
            return;
        }
        for (int i = index; i < dp.length; i++) {
            if (dp[index][i]) {
                list.add(s.substring(index, i + 1));
                helper(result, list, dp, i + 1, s);
                list.remove(list.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        PalindromePartition solution = new PalindromePartition();
        List<List<String>> result = solution.partition("aab");
        System.out.println(JSON.toJSONString(result));
        result = solution.partition("a");
        System.out.println(JSON.toJSONString(result));
        List<List<String>> result2 = solution.partition_2("aab");
        System.out.println(JSON.toJSONString(result2));
        result2 = solution.partition_2("a");
        System.out.println(JSON.toJSONString(result2));
    }
}
