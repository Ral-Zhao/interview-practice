package questions.leetbook.greedy;

import org.junit.Assert;

/**
 * 给你一个字符串 s 和一个整数 k 。请你用 s 字符串中 所有字符 构造 k 个非空 回文串 。
 * <p>
 * 如果你可以用 s 中所有字符构造 k 个回文字符串，那么请你返回 True ，否则返回 False 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "annabelle", k = 2
 * 输出：true
 * 解释：可以用 s 中所有字符构造 2 个回文字符串。
 * 一些可行的构造方案包括："anna" + "elble"，"anbna" + "elle"，"anellena" + "b"
 * 示例 2：
 * <p>
 * 输入：s = "leetcode", k = 3
 * 输出：false
 * 解释：无法用 s 中所有字符构造 3 个回文串。
 * 示例 3：
 * <p>
 * 输入：s = "true", k = 4
 * 输出：true
 * 解释：唯一可行的方案是让 s 中每个字符单独构成一个字符串。
 * 示例 4：
 * <p>
 * 输入：s = "yzyzyzyzyzyzyzy", k = 2
 * 输出：true
 * 解释：你只需要将所有的 z 放在一个字符串中，所有的 y 放在另一个字符串中。那么两个字符串都是回文串。
 * 示例 5：
 * <p>
 * 输入：s = "cr", k = 7
 * 输出：false
 * 解释：我们没有足够的字符去构造 7 个回文串。
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 10^5
 * s 中所有字符都是小写英文字母。
 * 1 <= k <= 10^5
 * <p>
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/greedy/rvkjxg/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class KPalindrome {
    public boolean canConstruct(String s, int k) {
        if (k > s.length()) {
            return false;
        }
        int[] nums = new int[26];
        for (int i = 0; i < s.length(); i++) {
            nums[s.charAt(i) - 'a']++;
        }
        int single = 0;
        for (int num : nums) {
            if (num % 2 == 1) {
                single++;
            }
        }
        return single <= k;
    }

    public static void main(String[] args) {
        KPalindrome solution = new KPalindrome();
        String s = "cxayrgpcctwlfupgzirmazszgfiusitvzsnngmivctprcotcuutfxdpbrdlqukhxkrmpwqqwdxxrptaftpnilfzcmknqljgbfkzuhksxzplpoozablefndimqnffrqfwgaixsovmmilicjwhppikryerkdidupvzdmoejzczkbdpfqkgpbxcrxphhnxfazovxbvaxyxhgqxcxirjsryqxtreptusvupsstylpjniezyfokbowpbgxbtsemzsvqzkbrhkvzyogkuztgfmrprz";
        Assert.assertTrue(!solution.canConstruct(s, 5));
        s = "annabelle";
        Assert.assertTrue(solution.canConstruct(s, 2));
        s = "leetcode";
        Assert.assertTrue(!solution.canConstruct(s, 3));
        s = "true";
        Assert.assertTrue(solution.canConstruct(s, 4));
        s = "yzyzyzyzyzyzyzy";
        Assert.assertTrue(solution.canConstruct(s, 2));
        s = "cr";
        Assert.assertTrue(!solution.canConstruct(s, 7));
    }
}
