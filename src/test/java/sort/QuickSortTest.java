package sort;

import org.junit.Test;

public class QuickSortTest {
    @Test
    public void test() {
        int[] nums = new int[]{8, 6, 2, 4, 3, 0, 5, 9};
        QuickSort.sort(nums);
        for (int n : nums) {
            System.out.print(n + " ");
        }
    }
}
