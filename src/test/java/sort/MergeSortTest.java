package sort;

import org.junit.Test;

public class MergeSortTest {
    @Test
    public void test() {
        int[] nums = new int[]{5, 3, 1, 2, 8, 6, 4, 2, 3};
        MergeSort.sort(nums);
        for (int n : nums) {
            System.out.print(n + " ");
        }
    }
}
