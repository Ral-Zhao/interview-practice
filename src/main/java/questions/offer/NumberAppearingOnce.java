package questions.offer;

/**
 *  题目56-2 数组中唯一出现一次的数字
 *
 *  在一个数组中除一个数字只出现一次之外，其他数字都出现了三次。找出只出现一次的数字。
 */
public class NumberAppearingOnce {
    public static int getNumber(int[] nums) {
        if (nums == null || nums.length < 4) {
            return -1;
        }
        int[] bits = new int[32];
        for (int num : nums) {
            int temp = num;
            for (int i = 0; i < 32; i++) {
                bits[31 - i] += temp & 1;
                temp = temp >>> 1;
            }
        }
        int result = 0;
        for (int i = 0; i < bits.length; i++) {
            result = result << 1;
            result = result ^ (bits[i] % 3 == 0 ? 0 : 1);
        }
        return result;
    }
}
