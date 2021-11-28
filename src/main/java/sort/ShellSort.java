package sort;

/**
 * Created by zhaozhezijian on 2021/11/28.
 */
public class ShellSort {
    public static void shellSort(int[] nums) {
        // 间隔序列，在希尔排序中我们称之为增量序列
        for (int gap = nums.length / 2; gap > 0; gap /= 2) {
            // 从 gap 开始，按照顺序将每个元素依次向前插入自己所在的组
            for (int i = gap; i < nums.length; i++) {
                // currentNumber 站起来，开始找位置
                int currentNumber = nums[i];
                // 该组前一个数字的索引
                int preIndex = i - gap;
                while (preIndex >= 0 && currentNumber < nums[preIndex]) {
                    // 向后挪位置
                    nums[preIndex + gap] = nums[preIndex];
                    preIndex -= gap;
                }
                // currentNumber 找到了自己的位置，坐下
                nums[preIndex + gap] = currentNumber;
            }
        }
    }
}
