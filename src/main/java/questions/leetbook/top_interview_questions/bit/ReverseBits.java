package questions.leetbook.top_interview_questions.bit;

import org.junit.Assert;

/**
 * 颠倒给定的 32 位无符号整数的二进制位。
 * <p>
 * 提示：
 * <p>
 * 请注意，在某些语言（如 Java）中，没有无符号整数类型。在这种情况下，输入和输出都将被指定为有符号整数类型，
 * 并且不应影响您的实现，因为无论整数是有符号的还是无符号的，其内部的二进制表示形式都是相同的。
 * 在 Java 中，编译器使用二进制补码记法来表示有符号整数。因此，在 示例 2 中，输入表示有符号整数 -3，输出表示有符号整数 -1073741825。
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 00000010100101000001111010011100
 * 输出：964176192 (00111001011110000010100101000000)
 * 解释：输入的二进制串 00000010100101000001111010011100 表示无符号整数 43261596，
 * 因此返回 964176192，其二进制表示形式为 00111001011110000010100101000000。
 * 示例 2：
 * <p>
 * 输入：n = 11111111111111111111111111111101
 * 输出：3221225471 (10111111111111111111111111111111)
 * 解释：输入的二进制串 11111111111111111111111111111101 表示无符号整数 4294967293，
 *   因此返回 3221225471 其二进制表示形式为 10111111111111111111111111111111 。
 *  
 * <p>
 * 提示：
 * <p>
 * 输入是一个长度为 32 的二进制字符串
 *  
 * <p>
 * 进阶: 如果多次调用这个函数，你将如何优化你的算法？
 * <p>
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions/x2dx36/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class ReverseBits {
    public int reverseBits(int n) {
        String input = String.valueOf(Integer.toBinaryString(n));
        int result = 0;
        for (int i = input.length() - 1; i >= 0; i--) {
            result = result << 1;
            if (input.charAt(i) == '1') {
                result = result ^ 1;
            }
        }
        int len = input.length();
        while (len < 32) {
            result <<= 1;
            len++;
        }
        return result;
    }

    public static void main(String[] args) {
        ReverseBits solution = new ReverseBits();
        Assert.assertEquals(964176192,solution.reverseBits(43261596));
        Assert.assertEquals(-1073741825,solution.reverseBits(-3));
    }
}
