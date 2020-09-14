package algorithm;

import java.util.Random;

/**
 * 洗牌算法
 * <p>
 * 分析洗牌算法正确性的准则：产生的结果必须有 n! 种可能，否则就是错误的。
 */
public class Shuffle {

    public static void shuffle(int[] nums) {
        /*
            第一种写法
         */
        for (int i = nums.length - 1; i > 0; i--) {
            int random = new Random().nextInt(i);
            int temp = nums[random];
            nums[random] = nums[i];
            nums[i] = temp;
        }
        /*
            第二种写法

        for (int i = nums.length - 1; i >= 0; i--) {
            int random = new Random().nextInt(i);
            int temp = nums[random];
            nums[random] = nums[i];
            nums[i] = temp;
        }
        */

        /*
            第三种写法

        for (int i = 0; i < nums.length; i--) {
            int random = new Random().nextInt(nums.length-i)+i;
            int temp = nums[random];
            nums[random] = nums[i];
            nums[i] = temp;
        }
        */
    }
}
