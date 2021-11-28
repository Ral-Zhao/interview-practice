package questions.leetbook.sort;

import org.junit.Assert;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 输入一个非负整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: [10,2]
 * 输出: "102"
 * 示例 2:
 * <p>
 * 输入: [3,30,34,5,9]
 * 输出: "3033459"
 *  
 * <p>
 * 提示:
 * <p>
 * 0 < nums.length <= 100
 * 说明:
 * <p>
 * 输出结果可能非常大，所以你需要返回一个字符串而不是整数
 * 拼接起来的数字可能会有前导 0，最后结果不需要去掉前导 0
 * <p>
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/sort-algorithms/oshq72/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class MinNumber {
    public String minNumber(int[] nums) {
        boolean hasSwap = true;
        for (int i = 0; i < nums.length - 1; i++) {
            if (!hasSwap) {
                break;
            }
            hasSwap = false;
            for (int j = 0; j < nums.length - 1 - i; j++) {
                String str1 = String.valueOf(nums[j]) + String.valueOf(nums[j + 1]);
                String str2 = String.valueOf(nums[j + 1]) + String.valueOf(nums[j]);
                for (int k = 0; k < str1.length(); k++) {
                    int n1 = str1.charAt(k) - '0';
                    int n2 = str2.charAt(k) - '0';
                    if (n1<n2){
                        break;
                    }else if (n2 < n1) {
                        int temp = nums[j];
                        nums[j] = nums[j + 1];
                        nums[j + 1] = temp;
                        hasSwap = true;
                        break;
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int num : nums) {
            sb.append(num);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        MinNumber solution = new MinNumber();
        int[] nums = new int[]{10, 2};
        Assert.assertEquals("102", solution.minNumber(nums));
        nums = new int[]{3,30,34,5,9};
        Assert.assertEquals("3033459", solution.minNumber(nums));
    }
}
