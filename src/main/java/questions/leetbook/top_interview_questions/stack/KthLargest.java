package questions.leetbook.top_interview_questions.stack;

import org.junit.Assert;

/**
 * 给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
 * <p>
 * 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 * 示例 2:
 * <p>
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 * 输出: 4
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= k <= nums.length <= 10^4
 * -10^4 <= nums[i] <= 10^4
 * <p>
 * <p>
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions/xal9h6/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class KthLargest {
    public int findKthLargest(int[] nums, int k) {
        for (int i = (nums.length - 2) / 2; i >= 0; i--) {
            fitDown(nums, i, nums.length);
        }
        int max = 0;
        for (int i = 0; i < k; i++) {
            max = nums[0];
            nums[0] = nums[nums.length - 1 - i];
            fitDown(nums, 0, nums.length - i);
        }
        return max;
    }

    private void fitDown(int[] arr, int index, int len) {
        while (index < len) {
            int left = 2 * index + 1;
            int right = 2 * index + 2;
            if (left >= len) {
                break;
            }
            int bigger = right >= len ? left : arr[left] >= arr[right] ? left : right;
            if (arr[index] < arr[bigger]) {
                int temp = arr[index];
                arr[index] = arr[bigger];
                arr[bigger] = temp;
            }
            index = bigger;
        }
    }

    public static void main(String[] args) {
        KthLargest solution = new KthLargest();
        int[] nums = new int[]{3, 2, 1, 5, 6, 4};
        Assert.assertEquals(5, solution.findKthLargest(nums, 2));
        nums = new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6};
        Assert.assertEquals(4, solution.findKthLargest(nums, 4));
    }
}
