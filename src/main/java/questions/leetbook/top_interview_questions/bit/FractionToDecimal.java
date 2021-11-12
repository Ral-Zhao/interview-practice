package questions.leetbook.top_interview_questions.bit;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定两个整数，分别表示分数的分子 numerator 和分母 denominator，以 字符串形式返回小数 。
 * <p>
 * 如果小数部分为循环小数，则将循环的部分括在括号内。
 * <p>
 * 如果存在多个答案，只需返回 任意一个 。
 * <p>
 * 对于所有给定的输入，保证 答案字符串的长度小于 10^4 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：numerator = 1, denominator = 2
 * 输出："0.5"
 * 示例 2：
 * <p>
 * 输入：numerator = 2, denominator = 1
 * 输出："2"
 * 示例 3：
 * <p>
 * 输入：numerator = 2, denominator = 3
 * 输出："0.(6)"
 * 示例 4：
 * <p>
 * 输入：numerator = 4, denominator = 333
 * 输出："0.(012)"
 * 示例 5：
 * <p>
 * 输入：numerator = 1, denominator = 5
 * 输出："0.2"
 *  
 * <p>
 * 提示：
 * <p>
 * -2^31 <= numerator, denominator <= 2^31 - 1
 * denominator != 0
 * <p>
 * <p>
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions/x2vpk7/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class FractionToDecimal {
    public String fractionToDecimal(int numerator, int denominator) {
        boolean minus = (numerator < 0 && denominator > 0) || (numerator > 0 && denominator < 0);
        long numera = Math.abs((long) numerator);
        long denom = Math.abs((long) denominator);
        long integer = numera / denom;
        numera = numera % denom;
        Map<Long, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        int index = 0;
        while (numera != 0) {
            numera = numera * 10;
            int pos = map.getOrDefault(numera, -1);
            if (pos != -1) {
                sb.insert(pos, "(");
                sb.append(")");
                break;
            }
            map.put(numera, index++);
            sb.append(numera / denom);
            numera = numera % denom;

        }
        String decimal = sb.toString();
        String res = String.valueOf(integer);
        if (!decimal.isEmpty()) {
            res = res + "." + decimal;
        }
        if (!"0".equals(res) && minus) {
            res = "-" + res;
        }
        return res;
    }

    public static void main(String[] args) {
        FractionToDecimal solution = new FractionToDecimal();
        System.out.println(solution.fractionToDecimal(1, 2));
        System.out.println(solution.fractionToDecimal(2, 1));
        System.out.println(solution.fractionToDecimal(2, 3));
        System.out.println(solution.fractionToDecimal(4, 333));
        System.out.println(solution.fractionToDecimal(1, 5));
        System.out.println(solution.fractionToDecimal(-50, 8));
        System.out.println(solution.fractionToDecimal(7, -12));
        System.out.println(solution.fractionToDecimal(-1, -2147483648));
    }
}
