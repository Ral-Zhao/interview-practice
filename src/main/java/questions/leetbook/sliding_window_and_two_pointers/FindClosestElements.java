package questions.leetbook.sliding_window_and_two_pointers;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个排序好的数组 arr ，两个整数 k 和 x ，从数组中找到最靠近 x（两数之差最小）的 k 个数。返回的结果必须要是按升序排好的。
 * <p>
 * 整数 a 比整数 b 更接近 x 需要满足：
 * <p>
 * |a - x| < |b - x| 或者
 * |a - x| == |b - x| 且 a < b
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：arr = [1,2,3,4,5], k = 4, x = 3
 * 输出：[1,2,3,4]
 * 示例 2：
 * <p>
 * 输入：arr = [1,2,3,4,5], k = 4, x = -1
 * 输出：[1,2,3,4]
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= k <= arr.length
 * 1 <= arr.length <= 10^4
 * 数组里的每个元素与 x 的绝对值不超过 10^4
 * <p>
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/sliding-window-and-two-pointers/odqjk7/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class FindClosestElements {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int left = 0;
        int right = arr.length;
        List<Integer> result = new ArrayList<>();
        while (left < right) {
            int mid = (left + right) / 2;
            if (arr[mid] == x) {
                left = mid;
                break;
            } else if (arr[mid] < x) {
                left = mid+1;
            } else {
                right = mid;
            }
        }
        if (left == right) {
            left--;
        }
        right = left + 1;
        while (k > 0) {
            if (left >= 0 && right < arr.length) {
                if (Math.abs(arr[left] - x) <= Math.abs(arr[right] - x)) {
                    result.add(0, arr[left]);
                    left--;
                } else {
                    result.add(arr[right]);
                    right++;
                }
            } else if (left >= 0) {
                result.add(0, arr[left]);
                left--;
            } else {
                result.add(arr[right]);
                right++;
            }
            k--;
        }
        return result;
    }

    public static void main(String[] args) {
        FindClosestElements solution = new FindClosestElements();
        int[] arr = new int[]{1, 2, 3, 4, 5};
        List<Integer> result;
        result = solution.findClosestElements(arr, 4, 3);
        System.out.println(JSON.toJSONString(result));
        arr = new int[]{1, 2, 3, 4, 5};
        result = solution.findClosestElements(arr, 4, -1);
        System.out.println(JSON.toJSONString(result));
        arr = new int[]{0, 0, 1, 2, 3, 3, 4, 7, 7, 8};
        result = solution.findClosestElements(arr, 3, 5);
        System.out.println(JSON.toJSONString(result));
    }
}
