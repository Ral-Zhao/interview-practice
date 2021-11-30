package sort;

import java.util.Arrays;

/**
 * 基数排序
 */
public class RadixSort {
    public static void radixSort(int[] arr) {
        if (arr == null) return;
        // 找出最大值
        int max = 0;
        for (int value : arr) {
            if (value > max) {
                max = value;
            }
        }
        // 计算最大数字的长度
        int maxDigitLength = 0;
        while (max != 0) {
            maxDigitLength++;
            max /= 10;
        }
        // 使用计数排序算法对基数进行排序
        int[] counting = new int[10];
        int[] result = new int[arr.length];
        int dev = 1;
        for (int i = 0; i < maxDigitLength; i++) {
            for (int value : arr) {
                int radix = value / dev % 10;
                counting[radix]++;
            }
            for (int j = 1; j < counting.length; j++) {
                counting[j] += counting[j - 1];
            }
            // 使用倒序遍历的方式完成计数排序
            for (int j = arr.length - 1; j >= 0; j--) {
                int radix = arr[j] / dev % 10;
                result[--counting[radix]] = arr[j];
            }
            // 计数排序完成后，将结果拷贝回 arr 数组
            System.arraycopy(result, 0, arr, 0, arr.length);
            // 将计数数组重置为 0
            Arrays.fill(counting, 0);
            dev *= 10;
        }
    }
}
