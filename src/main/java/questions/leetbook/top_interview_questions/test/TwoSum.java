package questions.leetbook.top_interview_questions.test;

/**
 * 给你两个整数 a 和 b ，不使用 运算符 + 和 - ​​​​​​​，计算并返回两整数之和。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：a = 1, b = 2
 * 输出：3
 * 示例 2：
 *
 * 输入：a = 2, b = 3
 * 输出：5
 *  
 *
 * 提示：
 *
 * -1000 <= a, b <= 1000
 *
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions/xmqsae/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class TwoSum {
    /**
     * 设 a = 6 -> 0110
     *    b = 3 -> 0011
     *  a+b = 9 -> 1001
     *
     * a + b 可以转换为二进制加减，通过位运算 ^ 和 & 进行。
     * 1、通过 & 可知道两数相加后需要进位的部分（a & b -> 0010）然后我们进位 (a & b) << 1 -> 0100，记结果为 i
     * 2、通过 ^ 可知两数相加后无需进位的部分(a ^ b -> 0101)，记结果为 j
     *
     * 故 a + b 可转为 i + j，其中 i = 0100, j = 0101，重复前两步操作
     * 1、i & j -> 0100 & 0101 = 0100 , 当其不为 0 时, 进位 (i & j) << 1 -> 1000， 记结果为 i
     * 2、i ^ j -> 0100 ^ 0101 = 0001 , 记结果为 j
     *
     * 重复前两步操作，其中 i = 1000, j = 0001：
     * 1、i & j -> 1000 & 0001 = 0000 , 由于其为 0，跳出循环
     * 2、i ^ j -> 1000 ^ 0001 = 1001 , 结果为 9, 此为最终结果
     *
     * @param a
     * @param b
     * @return
     */
    public static int getSum(int a, int b) {
        // a ^ b 找出需要进位的点
        while ((a & b) != 0) {
            // 进位
            int t = (a & b) << 1;
            // 找出无需进位的点，相加
            b = a ^ b;
            a = t;
        }
        return a ^ b;
    }
}
