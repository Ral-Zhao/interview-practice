package questions.offer;

import java.util.ArrayList;
import java.util.List;

/**
 *  题目56-1 数组中数字出现的次数
 *
 *  一个整型数组中除两个数字外，其他数字都出现了两次。请找出这两个数字。
 *  要求时间复杂度O(n)，空间复杂度O(1)。
 */
public class NumbersAppearOnce {
    public static List<Integer> getOnce(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        List<Integer> result = new ArrayList<>();
        int xor = 0;
        for (int i = 0; i < nums.length; i++) {
            xor = nums[i] ^ xor;
        }
        int pos = 0;
        //找到两个数异或结果中第一位为1的位置
        while ((xor & 1) != 1) {
            pos++;
            xor = xor >>> 1;
        }
        xor = 0;
        int xor2 = 0;
        for (int i = 0; i < nums.length; i++) {
            int temp = nums[i] >>> pos;
            //根据为1的位置分成两组，分别取异或操作。
            if ((temp & 1) == 1) {
                xor = nums[i] ^ xor;
            } else {
                xor2 = nums[i] ^ xor2;
            }
        }
        result.add(xor);
        result.add(xor2);
        return result;
    }
}
