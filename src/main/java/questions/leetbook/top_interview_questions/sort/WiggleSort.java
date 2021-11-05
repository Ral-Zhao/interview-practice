package questions.leetbook.top_interview_questions.sort;

import com.alibaba.fastjson.JSON;

/**
 * 给你一个整数数组 nums，将它重新排列成 nums[0] < nums[1] > nums[2] < nums[3]... 的顺序。
 * <p>
 * 你可以假设所有输入数组都可以得到满足题目要求的结果。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,5,1,1,6,4]
 * 输出：[1,6,1,5,1,4]
 * 解释：[1,4,1,5,1,6] 同样是符合题目要求的结果，可以被判题程序接受。
 * 示例 2：
 * <p>
 * 输入：nums = [1,3,2,2,3,1]
 * 输出：[2,3,1,3,1,2]
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 5 * 10^4
 * 0 <= nums[i] <= 5000
 * 题目数据保证，对于给定的输入 nums ，总能产生满足题目要求的结果
 *  
 * <p>
 * 进阶：你能用 O(n) 时间复杂度和 / 或原地 O(1) 额外空间来实现吗？
 * <p>
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions/xaygd7/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class WiggleSort {
    public void wiggleSort(int[] nums) {
        int midIndex = getMidIndex(nums, 0, nums.length - 1);
        int mid = nums[midIndex];
        int i = 0;
        int k = nums.length - 1;
        int j = 0;
        while (j < k) {
            if (nums[j] > mid) {
                swap(nums, j, k);
                k--;
            } else if (nums[j] < mid) {
                swap(nums, j, i);
                i++;
                j++;
            } else {
                j++;
            }
        }
        int[] copy = new int[nums.length];
        for (int l = 0; l <= midIndex; l++) {
            copy[2 * l] = nums[midIndex - l];
        }
        for (int l = 0; l < nums.length - midIndex - 1; l++) {
            copy[2 * l + 1] = nums[nums.length - 1 - l];
        }
        System.arraycopy(copy, 0, nums, 0, copy.length);
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private int getMidIndex(int[] nums, int left, int right) {
        int temp = nums[left];
        int start = left;
        int end = right;
        while (start < end) {
            while (start < end && nums[end] > temp) {
                end--;
            }
            if (start < end) {
                nums[start] = nums[end];
            }
            while (start < end && nums[start] <= temp) {
                start++;
            }
            if (start < end) {
                nums[end] = nums[start];
            }
        }
        nums[start] = temp;
        if (start == (nums.length - 1) / 2) {
            return start;
        } else if (start < (nums.length - 1) / 2) {
            return getMidIndex(nums, start + 1, right);
        } else {
            return getMidIndex(nums, left, start - 1);
        }
    }

    public static void main(String[] args) {
        WiggleSort solution = new WiggleSort();
        int[] nums = new int[]{1, 5, 1, 1, 6, 4};
        solution.wiggleSort(nums);
        System.out.println(JSON.toJSONString(nums));
        nums = new int[]{1, 3, 2, 2, 3, 1};
        solution.wiggleSort(nums);
        System.out.println(JSON.toJSONString(nums));
        nums = new int[]{2, 1};
        solution.wiggleSort(nums);
        System.out.println(JSON.toJSONString(nums));
        nums = new int[]{1, 5, 4, 4, 5, 1, 1, 5, 3, 4, 2, 4, 4, 1, 1, 1, 2, 4, 5};
        solution.wiggleSort(nums);
        System.out.println(JSON.toJSONString(nums));
    }
}
