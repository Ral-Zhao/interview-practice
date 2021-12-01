package sort;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 桶排序
 */
public class BucketSort {
    public static void bucketSort(int[] arr) {
        // 判空及防止数组越界
        if (arr == null || arr.length <= 1) return;
        // 找到最大值，最小值
        int max = arr[0];
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) max = arr[i];
            else if (arr[i] < min) min = arr[i];
        }
        // 确定取值范围
        int range = max - min;
        // 设置桶的数量，这里我们设置为 100 个，可以任意修改。
        int bucketAmount = 100;
        // 桶和桶之间的间距
        double gap = range * 1.0 / (bucketAmount - 1);
        HashMap<Integer, Queue<Integer>> buckets = new HashMap<>();
        // 装桶
        for (int value : arr) {
            // 找到 value 属于哪个桶
            int index = (int) ((value - min) / gap);
            if (!buckets.containsKey(index)) {
                buckets.put(index, new LinkedList<>());
            }
            buckets.get(index).add(value);
        }
        int index = 0;
        // 对每个桶内的数字进行单独排序
        for (int i = 0; i < bucketAmount; i++) {
            Queue<Integer> bucket = buckets.get(i);
            if (bucket == null) continue;
            // 将链表转换为数组，提升排序性能
            int[] arrInBucket = bucket.stream().mapToInt(Integer::intValue).toArray();
            // 这里需要结合其他排序算法，例如：插入排序
            insertSort(arrInBucket);
            // 排序完成后将桶内的结果收集起来
            System.arraycopy(arrInBucket, 0, arr, index, arrInBucket.length);
            index += arrInBucket.length;
        }
    }
    // 插入排序
    public static void insertSort(int[] arr) {
        // 从第二个数开始，往前插入数字
        for (int i = 1; i < arr.length; i++) {
            int currentNumber = arr[i];
            int j = i - 1;
            // 寻找插入位置的过程中，不断地将比 currentNumber 大的数字向后挪
            while (j >= 0 && currentNumber < arr[j]) {
                arr[j + 1] = arr[j];
                j--;
            }
            // 两种情况会跳出循环：1. 遇到一个小于或等于 currentNumber 的数字，跳出循环，currentNumber 就坐到它后面。
            // 2. 已经走到数列头部，仍然没有遇到小于或等于 currentNumber 的数字，也会跳出循环，此时 j 等于 -1，currentNumber 就坐到数列头部。
            arr[j + 1] = currentNumber;
        }
    }
}
