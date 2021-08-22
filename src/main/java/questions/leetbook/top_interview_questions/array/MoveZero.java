package questions.leetbook.top_interview_questions.array;

import com.alibaba.fastjson.JSON;

/**
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * <p>
 * 示例:
 * <p>
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 说明:
 * <p>
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 * <p>
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions/xmy9jh/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class MoveZero {
    public void moveZeroes(int[] nums) {
        int count = 0;
        for (int num : nums) {
            if (num != 0) {
                count++;
            }
        }
        if (count == nums.length) {
            return;
        }
        int nonZero = 0;
        int next = 0;
        while (count > 0) {
            while (nums[nonZero] == 0) {
                nonZero++;
            }
            nums[next] = nums[nonZero];
            if (next != nonZero) {
                nums[nonZero] = 0;
            }
            nonZero++;
            next++;
            count--;
        }
    }

    public static void main(String[] args) {
        MoveZero solution = new MoveZero();
        int[] nums = new int[]{0, 1, 0, 3, 12};
        solution.moveZeroes(nums);
        System.out.println(JSON.toJSONString(nums));
        nums = new int[]{1, 0};
        solution.moveZeroes(nums);
        System.out.println(JSON.toJSONString(nums));
        nums = new int[]{1, 0, 1};
        solution.moveZeroes(nums);
        System.out.println(JSON.toJSONString(nums));
    }
}
