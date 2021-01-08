package sort;

/**
 * 冒泡排序
 */
public class BubbleSort {
    public static void sort(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int count = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 0; j < nums.length - 1 - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
                count++;
            }
        }
        System.out.println("排序次数:" + count);
    }

    /**
     * 优化后的排序算法
     */
    public static void bestSort(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int count = 0;
        int len = nums.length - 1;
        int swapIndex = 0;//记录最后一次交换的下标
        boolean hasSwapped;//用来记录在比较过程中是否发生过交换
        for (int i = 0; i < nums.length - 1; i++) {
            hasSwapped = false;
            for (int j = 0; j < len; j++) {//只需要比较到最后一次发生交换的位置即可
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                    hasSwapped = true;
                    swapIndex = j;
                }
                count++;
            }
            len = swapIndex;

            //没有交换意味着已经有序
            if (!hasSwapped) {
                System.out.println("排序次数:" + count);
                return;
            }
        }
        System.out.println("排序次数:" + count);
    }
}
