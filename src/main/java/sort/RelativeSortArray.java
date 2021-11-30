package sort;

import com.alibaba.fastjson.JSON;

/**
 * 给你两个数组，arr1 和 arr2，
 * <p>
 * arr2 中的元素各不相同
 * arr2 中的每个元素都出现在 arr1 中
 * 对 arr1 中的元素进行排序，使 arr1 中项的相对顺序和 arr2 中的相对顺序相同。
 * 未在 arr2 中出现过的元素需要按照升序放在 arr1 的末尾。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 输入：arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
 * 输出：[2,2,2,1,4,3,3,9,6,7,19]
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= arr1.length, arr2.length <= 1000
 * 0 <= arr1[i], arr2[i] <= 1000
 * arr2 中的元素 arr2[i] 各不相同
 * arr2 中的每个元素 arr2[i] 都出现在 arr1 中
 * <p>
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/sort-algorithms/o1zu22/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class RelativeSortArray {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        if (arr1 == null || arr1.length == 0) {
            return arr1;
        }
        int max = arr1[0];
        int min = arr1[0];
        for (int num : arr1) {
            if (num > max) {
                max = num;
            }
            if (num < min) {
                min = num;
            }
        }
        int[] counting = new int[max - min + 1];
        for (int num : arr1) {
            counting[num - min]++;
        }
        int[] result = new int[arr1.length];
        int index = 0;
        for (int n : arr2) {
            while (counting[n - min] > 0) {
                result[index++] = n;
                counting[n - min]--;
            }
        }
        for (int i = 0; i < counting.length; i++) {
            while (counting[i] > 0) {
                result[index++] = i + min;
                counting[i]--;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        RelativeSortArray solution = new RelativeSortArray();
        int[] arr1 = new int[]{2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19};
        int[] arr2 = new int[]{2, 1, 4, 3, 9, 6};
        int[] result = solution.relativeSortArray(arr1, arr2);
        System.out.println(JSON.toJSONString(result));
    }
}
