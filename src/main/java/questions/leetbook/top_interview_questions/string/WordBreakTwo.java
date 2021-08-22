package questions.leetbook.top_interview_questions.string;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，在字符串中增加空格来构建一个句子，使得句子中所有的单词都在词典中。返回所有这些可能的句子。
 * <p>
 * 说明：
 * <p>
 * 分隔时可以重复使用字典中的单词。
 * 你可以假设字典中没有重复的单词。
 * 示例 1：
 * <p>
 * 输入:
 * s = "catsanddog"
 * wordDict = ["cat", "cats", "and", "sand", "dog"]
 * 输出:
 * [
 *   "cats and dog",
 *   "cat sand dog"
 * ]
 * 示例 2：
 * <p>
 * 输入:
 * s = "pineapplepenapple"
 * wordDict = ["apple", "pen", "applepen", "pine", "pineapple"]
 * 输出:
 * [
 *   "pine apple pen apple",
 *   "pineapple pen apple",
 *   "pine applepen apple"
 * ]
 * 解释: 注意你可以重复使用字典中的单词。
 * 示例 3：
 * <p>
 * 输入:
 * s = "catsandog"
 * wordDict = ["cats", "dog", "sand", "and", "cat"]
 * 输出:
 * []
 * <p>
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions/xa9v8i/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class WordBreakTwo {
    private String s;

    public List<String> wordBreak(String s, List<String> wordDict) {
        this.s = s;
        List<String> result = new ArrayList<>();
        Set<String> set = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        helper(result, dp, set, 1);
        return result;
    }

    private void helper(List<String> result, boolean[] dp, Set<String> wordSet, int index) {
        if (index >= dp.length) {
            int start = 0;
            StringBuilder sb = new StringBuilder();
            for (int i = 1; i < dp.length; i++) {
                if (dp[i]) {
                    sb.append(s, start, i).append(" ");
                    start = i;
                }
            }
            result.add(sb.toString().trim());
            return;
        }
        for (int i = index; i < dp.length; i++) {
            for (int j = index-1; j < i; j++) {
                if (dp[j] && wordSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    helper(result, dp, wordSet, i + 1);
                    dp[i] = false;
                }
            }
        }
    }

    public static void main(String[] args) {
        WordBreakTwo solution = new WordBreakTwo();
        List<String> wordDict = Lists.newArrayList("cat", "cats", "and", "sand", "dog");
        List<String> result;
        result = solution.wordBreak("catsanddog", wordDict);
        System.out.println(JSON.toJSONString(result));
        wordDict = Lists.newArrayList("apple", "pen", "applepen", "pine", "pineapple");
        result = solution.wordBreak("pineapplepenapple", wordDict);
        System.out.println(JSON.toJSONString(result));
        wordDict = Lists.newArrayList("cats", "dog", "sand", "and", "cat");
        result = solution.wordBreak("catsandog", wordDict);
        System.out.println(JSON.toJSONString(result));

    }
}
