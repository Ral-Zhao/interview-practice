package questions.leetbook.greedy;

import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 给你一个以字符串表示的非负整数 num 和一个整数 k ，移除这个数中的 k 位数字，使得剩下的数字最小。请你以字符串形式返回这个最小的数字。
 * <p>
 *  
 * 示例 1 ：
 * <p>
 * 输入：num = "1432219", k = 3
 * 输出："1219"
 * 解释：移除掉三个数字 4, 3, 和 2 形成一个新的最小的数字 1219 。
 * 示例 2 ：
 * <p>
 * 输入：num = "10200", k = 1
 * 输出："200"
 * 解释：移掉首位的 1 剩下的数字为 200. 注意输出不能有任何前导零。
 * 示例 3 ：
 * <p>
 * 输入：num = "10", k = 2
 * 输出："0"
 * 解释：从原数字移除所有的数字，剩余为空就是 0 。
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= k <= num.length <= 10^5
 * num 仅由若干位数字（0 - 9）组成
 * 除了 0 本身之外，num 不含任何前导零
 * <p>
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/greedy/rvbag3/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class RemoveKdigits {
    public String removeKdigits(String num, int k) {
        if (k == num.length()) {
            return "0";
        }
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < num.length(); i++) {
            int cur = num.charAt(i) - '0';
            while (!stack.isEmpty() && k > 0 && (cur < stack.peek())) {
                stack.pop();
                k--;
            }
            stack.add(cur);
        }
        while (k > 0) {
            stack.pop();
            k--;
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.insert(0, stack.pop());
        }
        int zeroLen = 0;
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == '0') {
                zeroLen++;
            } else {
                break;
            }
        }
        if (zeroLen == sb.length()) {
            return "0";
        }
        if (zeroLen > 0) {
            sb.delete(0, zeroLen);
        }
        return sb.toString();
    }

    public String method_2(String num, int k) {
        StringBuilder strNum = new StringBuilder(num);
        int length = num.length();
        int index = 0;
        while (k > 0) {
            while (index < length - 1 && strNum.charAt(index) <= strNum.charAt(index + 1))
                index++;
            if (index >= length - 1) {
                if (k >= length)
                    return "0";
                else
                    return strNum.delete(length - k, length).toString();
            } else {
                strNum.delete(index, index + 1);
                length--;
                index--;
                k--;
            }
            while (index == -1 && strNum.charAt(0) == '0') {
                strNum.delete(0, 1);
                length--;
                if (length <= 0)
                    return "0";
            }
            if (index == -1)
                index = 0;
        }
        return strNum.toString();
    }

    public static void main(String[] args) {
        RemoveKdigits solution = new RemoveKdigits();
        Assert.assertEquals("1219", solution.removeKdigits("1432219", 3));
        Assert.assertEquals("200", solution.removeKdigits("10200", 1));
        Assert.assertEquals("0", solution.removeKdigits("10", 1));
        Assert.assertEquals("11", solution.removeKdigits("112", 1));
    }
}
