package sort;

import org.junit.Test;

public class SelectionSortTest {
    @Test
    public void test() {
        int[] nums = new int[]{5, 4, 9, 2, 1, 56, 8, 12, 0};
        SelectionSort.sort(nums);
        for (int n : nums) {
            System.out.print(n + " ");
        }
    }
}
