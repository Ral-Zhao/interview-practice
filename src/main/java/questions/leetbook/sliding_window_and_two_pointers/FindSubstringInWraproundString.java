package questions.leetbook.sliding_window_and_two_pointers;

import org.junit.Assert;

/**
 * 把字符串 s 看作是“abcdefghijklmnopqrstuvwxyz”的无限环绕字符串，所以 s 看起来是这样的："...zabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcd....". 
 * <p>
 * 现在我们有了另一个字符串 p 。你需要的是找出 s 中有多少个唯一的 p 的非空子串，尤其是当你的输入是字符串 p ，
 * 你需要输出字符串 s 中 p 的不同的非空子串的数目。 
 * <p>
 * 注意: p 仅由小写的英文字母组成，p 的大小可能超过 10000。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: "a"
 * 输出: 1
 * 解释: 字符串 S 中只有一个"a"子字符。
 *  
 * <p>
 * 示例 2:
 * <p>
 * 输入: "cac"
 * 输出: 2
 * 解释: 字符串 S 中的字符串“cac”只有两个子串“a”、“c”。.
 *  
 * <p>
 * 示例 3:
 * <p>
 * 输入: "zab"
 * 输出: 6
 * 解释: 在字符串 S 中有六个子串“z”、“a”、“b”、“za”、“ab”、“zab”。.
 * <p>
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/sliding-window-and-two-pointers/risz4s/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class FindSubstringInWraproundString {
    public int findSubstringInWraproundString(String p) {
        /*
         统计以每个字符作为结尾的最长连续序列(可以覆盖掉重复的短序列的情况), 他们的和即为所求
         例如:abcdbcd, 对于以d结尾的有abcd, bcd, cd和d, 而bcd产生的序列都会被abcd所覆盖
         总和即以a、b、c和d结尾的所有连续最长序列1 + 2 + 3 + 4 = 10
         **/
        int n = p.length();
        if(n < 1) return 0;
        int ret = 0;
        int[] count = new int[26];
        char[] str = p.toCharArray();
        int curMaxLen = 1;
        for(int i = 0; i < n; ++i) {
            if(i > 0 && (str[i]-str[i-1] == 1 || str[i-1]-str[i] == 25))
                curMaxLen++;
            else
                curMaxLen = 1;
            count[str[i]-'a'] = Math.max(count[str[i]-'a'], curMaxLen);
        }
        for(int temp : count)
            ret += temp;
        return ret;
    }


    public static void main(String[] args) {
        FindSubstringInWraproundString solution = new FindSubstringInWraproundString();
        Assert.assertEquals(2,solution.findSubstringInWraproundString("cac"));
        Assert.assertEquals(6,solution.findSubstringInWraproundString("zab"));
    }
}
