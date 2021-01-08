package sort;

import org.junit.Test;

public class InsertSortTest {
    @Test
    public void test() {
        int[] nums = new int[]{4, 5, 9, 3, 12, 5, 6, 7};
        InsertSort.sort(nums);
        for (int n : nums) {
            System.out.print(n + " ");
        }
    }
}
