package questions.interview.bytedance;

/**
 * 2022-3-2
 *
 * 旋转数组查找
 * <p>
 * 题目描述
 * 整数数组 nums 按升序排列，数组中的值 互不相同 。​
 * 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，
 * 使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。
 * 例如， [0,1,2,4,5,6,7] 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2] 。​
 *
 * 给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回 -1 。
 */
public class FindReverseArray {
    public static int find(int[] arr, int k) {
        boolean atLeft = k >= arr[0];
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == k) {
                return mid;
            } else if (arr[mid] > k) {
                if (atLeft || arr[mid] < arr[0]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (atLeft || arr[mid] < arr[0]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{4, 5, 6, 7, 0, 1, 2};
        System.out.println(find(arr, 4));
        System.out.println(find(arr, 5));
        System.out.println(find(arr, 6));
        System.out.println(find(arr, 7));
        System.out.println(find(arr, 0));
        System.out.println(find(arr, 1));
        System.out.println(find(arr, 2));
    }
}
