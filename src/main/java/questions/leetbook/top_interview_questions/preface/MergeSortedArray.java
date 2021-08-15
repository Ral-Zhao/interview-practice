package questions.leetbook.top_interview_questions.preface;

import com.alibaba.fastjson.JSON;

/**
 * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
 * <p>
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。
 * 你可以假设 nums1 的空间大小等于 m + n，这样它就有足够的空间保存来自 nums2 的元素。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
 * 输出：[1,2,2,3,5,6]
 * 示例 2：
 * <p>
 * 输入：nums1 = [1], m = 1, nums2 = [], n = 0
 * 输出：[1]
 *  
 * <p>
 * 提示：
 * <p>
 * nums1.length == m + n
 * nums2.length == n
 * 0 <= m, n <= 200
 * 1 <= m + n <= 200
 * -109 <= nums1[i], nums2[i] <= 109
 * <p>
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions/xmi2l7/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = 0;
        int p2 = 0;
        while (p1 < m && p2 < n) {
            if (nums1[p1] <= nums2[p2]) {
                p1++;
            } else {
                for (int i = m; i > p1; i--) {
                    nums1[i] = nums1[i - 1];
                }
                nums1[p1] = nums2[p2];
                p1++;
                p2++;
                m++;
            }
        }
        if (p2 != n) {
            while (p2 < n) {
                nums1[p1] = nums2[p2];
                p1++;
                p2++;
            }
        }
    }

    public static void main(String[] args) {
        MergeSortedArray solution = new MergeSortedArray();
        int[] nums1 = new int[]{1, 2, 3, 0, 0, 0};
        int[] nums2 = new int[]{2, 5, 6};
        solution.merge(nums1, 3, nums2, 3);
        System.out.println(JSON.toJSONString(nums1));
        nums1 = new int[]{1};
        nums2 = new int[]{};
        solution.merge(nums1, 1, nums2, 0);
        System.out.println(JSON.toJSONString(nums1));
        nums1 = new int[]{0};
        nums2 = new int[]{1};
        solution.merge(nums1, 0, nums2, 1);
        System.out.println(JSON.toJSONString(nums1));
    }
}
