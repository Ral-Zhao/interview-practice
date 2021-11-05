package questions.leetbook.top_interview_questions.sort;

import org.junit.Assert;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 给定一组非负整数 nums，重新排列每个数的顺序（每个数不可拆分）使之组成一个最大的整数。
 * <p>
 * 注意：输出结果可能非常大，所以你需要返回一个字符串而不是整数。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [10,2]
 * 输出："210"
 * 示例 2：
 * <p>
 * 输入：nums = [3,30,34,5,9]
 * 输出："9534330"
 * 示例 3：
 * <p>
 * 输入：nums = [1]
 * 输出："1"
 * 示例 4：
 * <p>
 * 输入：nums = [10]
 * 输出："10"
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 109
 * <p>
 * <p>
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions/xa1401/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class LargestNumber {
    public String largestNumber(int[] nums) {
        Queue<String> queue = new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String num1 = o1 + o2;
                String num2 = o2 + o1;
                for (int i = 0; i < num1.length(); i++) {
                    int n1 = num1.charAt(i) - '0';
                    int n2 = num2.charAt(i) - '0';
                    if (n1 > n2) {
                        return -1;
                    }
                    if (n1 < n2) {
                        return 1;
                    }
                }
                return 0;
            }
        });
        for (int num : nums) {
            queue.add(String.valueOf(num));
        }
        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            sb.append(queue.poll());
        }
        if (sb.charAt(0) == '0') {
            return "0";
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        LargestNumber solution = new LargestNumber();
        int[] nums = new int[]{3, 30, 34, 5, 9};
        Assert.assertEquals("9534330", solution.largestNumber(nums));
        nums = new int[]{10, 2};
        Assert.assertEquals("210", solution.largestNumber(nums));
        nums = new int[]{432, 43243};
        Assert.assertEquals("43243432", solution.largestNumber(nums));
        nums = new int[]{432, 43245};
        Assert.assertEquals("43245432", solution.largestNumber(nums));

    }
}
