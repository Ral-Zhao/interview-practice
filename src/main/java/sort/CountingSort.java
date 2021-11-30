package sort;

/**
 * 计数排序
 */
public class CountingSort {
    public static void sort(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int max = nums[0];
        int min = nums[0];
        for (int num : nums) {
            if (num > max) {
                max = num;
            }
            if (num < min) {
                min = num;
            }
        }
        int[] counting = new int[max - min + 1];
        for (int num : nums) {
            counting[num - min]++;
        }
        int preCount = 0;
        for (int i = 0; i < counting.length; i++) {
            preCount += counting[i];
            counting[i] = preCount - counting[i];
        }
        int[] result = new int[nums.length];
        for (int num : nums) {
            result[counting[num - min]] = num;
            counting[num - min]++;
        }
        for (int i = 0; i < result.length; i++) {
            nums[i] = result[i];
        }
    }
}
