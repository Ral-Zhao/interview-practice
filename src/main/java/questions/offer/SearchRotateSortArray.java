package questions.offer;

/**
 * 题目11 旋转数组中的最小数字
 * <p>
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如，数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，改数组的最小值为1.
 */
public class SearchRotateSortArray {

    public static int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int mid = 0;
        while (nums[left] >= nums[right]) {
            if (left == right - 1) {
                mid = right;
                break;
            }
            mid = left + (right - left) / 2;

            if (nums[left] == nums[right] && nums[mid] == nums[left]) {
                int min = nums[left];
                for (int i = left+1; i <=right ; i++) {
                    if (nums[i]<min){
                        min = nums[i];
                    }
                }
                return min;
            }

            if (nums[mid] >= nums[left]) {
                left = mid;
            } else if (nums[mid] <= nums[right]) {
                right = mid;
            }
        }
        return nums[mid];

    }
}
