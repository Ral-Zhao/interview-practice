package questions.offer;

/**
 *  题目40 最小的k个数
 *
 *  输入n个整数，找出其中最小的k个数。
 *
 */
public class KLeastNumbers {
    public static int[] getLeastNumbers(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0) {
            return new int[0];
        }
        if (nums.length <= k) {
            return nums;
        }
        int[] result = new int[k];
        //构造大顶堆
        System.arraycopy(nums, 0, result, 0, k);
        for (int i = (k - 2) / 2; i >= 0; i--) {
            fit(result, i, k);
        }
        for (int i = k; i < nums.length; i++) {
            if (nums[i] <= result[0]) {
                result[0] = nums[i];
                fit(result, 0, k);
            }
        }
        return result;

    }

    private static void fit(int[] arr, int index, int len) {
        //向下寻找直到叶子节点退出循环
        while (index * 2 + 1 < len) {
            int left = index * 2 + 1;
            int right = index * 2 + 2;
            //右孩子节点可能不存在，此时最大节点默认为左孩子
            int big = right < len && arr[left] < arr[right] ? right : left;
            //将比父节点大的子节点与父节点交换
            if (arr[index] < arr[big]) {
                int temp = arr[big];
                arr[big] = arr[index];
                arr[index] = temp;
            }
            //从交换的子节点开始向下重复上述过程
            index = big;
        }
    }
}
