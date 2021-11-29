package questions.leetbook.sort;

import com.alibaba.fastjson.JSON;

/**
 * 输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：arr = [3,2,1], k = 2
 * 输出：[1,2] 或者 [2,1]
 * 示例 2：
 * <p>
 * 输入：arr = [0,1,2,1], k = 1
 * 输出：[0]
 *  
 * <p>
 * 限制：
 * <p>
 * 0 <= k <= arr.length <= 10000
 * 0 <= arr[i] <= 10000
 * <p>
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/sort-algorithms/os5lwi/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class LeastNumbers {
    public int[] getLeastNumbers(int[] arr, int k) {
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            fitDown(arr, i, arr.length - 1);
        }
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = arr[0];
            arr[0] = arr[arr.length - 1 - i];
            fitDown(arr, 0, arr.length - 1 - i);
        }
        return result;
    }

    private void fitDown(int[] arr, int index, int len) {
        while (index <= len) {
            int left = 2 * index + 1;
            int right = 2 * index + 2;
            if (left > len) {
                break;
            }
            int bigIndex = right > len ? left : arr[right] > arr[left] ? left : right;
            if (arr[bigIndex] < arr[index]) {
                int temp = arr[bigIndex];
                arr[bigIndex] = arr[index];
                arr[index] = temp;
            }
            index = bigIndex;
        }
    }

    public static void main(String[] args) {
        LeastNumbers solution = new LeastNumbers();
        int[] arr = new int[]{3, 2, 1};
        int[] result = solution.getLeastNumbers(arr, 2);
        System.out.println(JSON.toJSONString(result));
        arr = new int[]{4, 5, 1, 6, 2, 7, 3, 8};
        result = solution.getLeastNumbers(arr, 4);
        System.out.println(JSON.toJSONString(result));
        arr = new int[]{0, 1, 2, 1};
        result = solution.getLeastNumbers(arr, 1);
        System.out.println(JSON.toJSONString(result));
    }
}
