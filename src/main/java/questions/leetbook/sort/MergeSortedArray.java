package questions.leetbook.sort;

import com.alibaba.fastjson.JSON;

/**
 * 给定两个排序后的数组 A 和 B，其中 A 的末端有足够的缓冲空间容纳 B。 编写一个方法，将 B 合并入 A 并排序。
 * <p>
 * 初始化 A 和 B 的元素数量分别为 m 和 n。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * A = [1,2,3,0,0,0], m = 3
 * B = [2,5,6],       n = 3
 * <p>
 * 输出: [1,2,2,3,5,6]
 * 说明:
 * <p>
 * A.length == n + m
 * <p>
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/sort-algorithms/osomav/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class MergeSortedArray {
    public void merge(int[] A, int m, int[] B, int n) {
        int index = A.length - 1;
        m--;
        n--;
        while (m >= 0 && n >= 0) {
            if (A[m] > B[n]) {
                A[index--] = A[m--];
            } else {
                A[index--] = B[n--];
            }
        }
        while (n >= 0) {
            A[index--] = B[n--];
        }
    }

    public static void main(String[] args) {
        MergeSortedArray solution = new MergeSortedArray();
        int[] A = new int[]{1, 2, 3, 0, 0, 0};
        int[] B = new int[]{2, 5, 6};
        solution.merge(A, 3, B, 3);
        System.out.println(JSON.toJSONString(A));
    }
}
