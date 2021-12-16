package questions.leetbook.sliding_window_and_two_pointers;

import com.sun.scenario.effect.impl.prism.PrImage;
import org.junit.Assert;

/**
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 * <p>
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * 解释："amanaplanacanalpanama" 是回文串
 * 示例 2:
 * <p>
 * 输入: "race a car"
 * 输出: false
 * 解释："raceacar" 不是回文串
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 2 * 105
 * 字符串 s 由 ASCII 字符组成
 * <p>
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/sliding-window-and-two-pointers/odz3uc/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class IsPalindrome {
    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            char leftChar = s.charAt(left);
            char rightChar = s.charAt(right);
            if (!isWord(leftChar) && !isDigital(leftChar)) {
                left++;
                continue;
            }
            if (!isWord(rightChar) && !isDigital(rightChar)) {
                right--;
                continue;
            }
            if (leftChar != rightChar) {
                if (isWord(leftChar) && isWord(rightChar) && Math.abs(rightChar - leftChar) == Math.abs('A' - 'a')) {
                    left++;
                    right--;
                    continue;
                }
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    private boolean isWord(char ch) {
        return (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z');
    }

    private boolean isDigital(char ch) {
        return ch >= '0' && ch <= '9';
    }

    public static void main(String[] args) {
        IsPalindrome solution = new IsPalindrome();
        Assert.assertTrue(solution.isPalindrome("A man, a plan, a canal: Panama"));
        Assert.assertTrue(!solution.isPalindrome("race a car"));
        Assert.assertTrue(!solution.isPalindrome("0P"));
    }
}
