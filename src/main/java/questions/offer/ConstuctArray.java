package questions.offer;

/**
 *  题目66 构建乘积数组
 *
 *  给定一个数组A[0,1,…,n-1]，请构建一个数组B[0,1,…,n-1]，
 *  其中B的元素B[i] = A[0]*A[1]*…*A[i-1]*A[i+1]*…*A[n-1]。不能使用除法。
 */
public class ConstuctArray {
    public static int[] getArray(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        int[] before = new int[arr.length];
        int[] after = new int[arr.length];
        before[0] = arr[0];
        after[arr.length - 1] = arr[arr.length - 1];
        for (int i = 1; i < arr.length; i++) {
            before[i] = before[i - 1] * arr[i];
            after[arr.length - 1 - i] = after[arr.length - i] * arr[arr.length - 1 - i];
        }
        int[] result = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            int beforeSum = 1;
            int afterSum = 1;
            if (i > 0) {
                beforeSum = before[i - 1];
            }
            if (i < arr.length - 1) {
                afterSum = after[i + 1];
            }
            result[i] = beforeSum * afterSum;
        }
        return result;
    }
}
