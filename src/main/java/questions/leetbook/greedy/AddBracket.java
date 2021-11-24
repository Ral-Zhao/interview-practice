package questions.leetbook.greedy;

import org.junit.Assert;

import java.util.Stack;

/**
 * 给定一个由 '(' 和 ')' 括号组成的字符串 S，我们需要添加最少的括号（ '(' 或是 ')'，可以在任何位置），以使得到的括号字符串有效。
 * <p>
 * 从形式上讲，只有满足下面几点之一，括号字符串才是有效的：
 * <p>
 * 它是一个空字符串，或者
 * 它可以被写成 AB （A 与 B 连接）, 其中 A 和 B 都是有效字符串，或者
 * 它可以被写作 (A)，其中 A 是有效字符串。
 * 给定一个括号字符串，返回为使结果字符串有效而必须添加的最少括号数。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入："())"
 * 输出：1
 * 示例 2：
 * <p>
 * 输入："((("
 * 输出：3
 * 示例 3：
 * <p>
 * 输入："()"
 * 输出：0
 * 示例 4：
 * <p>
 * 输入："()))(("
 * 输出：4
 *  
 * <p>
 * 提示：
 * <p>
 * S.length <= 1000
 * S 只包含 '(' 和 ')' 字符。
 * <p>
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/greedy/rvgyhv/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class AddBracket {
    public int minAddToMakeValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (stack.isEmpty()) {
                stack.add(ch);
                continue;
            }
            if (ch == ')' && stack.peek() == '(') {
                stack.pop();
            } else {
                stack.add(ch);
            }
        }
        return stack.size();
    }

    public int method_2(String s) {
        int left = 0, ans = 0;
        int strLength = s.length();
        for (int i = 0; i < strLength; i++) {
            if (s.charAt(i) == '(')
                left++;
            else if (left > 0)
                left--;
            else
                ans++;
        }
        return ans + left;
    }

    public static void main(String[] args) {
        AddBracket solution = new AddBracket();
        Assert.assertEquals(1, solution.minAddToMakeValid("())"));
        Assert.assertEquals(3, solution.minAddToMakeValid("((("));
        Assert.assertEquals(0, solution.minAddToMakeValid("()"));
        Assert.assertEquals(4, solution.minAddToMakeValid("()))(("));
    }
}
