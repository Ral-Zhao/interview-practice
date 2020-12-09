package questions.offer;

/**
 *  题目65 不用加减乘除做加法
 *
 *  写一个函数，求两个整数之和，要求在函数体内不得使用"+"、"-"、"*"、"/"四则运算符。
 */
public class AddTwoNumbers {
    public static int add(int a, int b) {
        int bit = 1;
        int result = 0;
        boolean advance = false;
        for (int i = 0; i < 32; i++) {
            if (i != 0) {
                bit = bit << 1;
            }
            int aBit = (a & bit) == 0 ? 0 : 1;
            int bBit = (b & bit) == 0 ? 0 : 1;
            //一个为0一个为1且没有进位
            //或两个相同且有进位，这两种情况需置为1
            if ((aBit != bBit && !advance) || (aBit == bBit && advance)) {
                result = result ^ bit;
            }
            advance = (aBit == 1 && bBit == 1) || (aBit != bBit && advance);
        }
        return result;
    }
}
