package sort;

import org.junit.Test;

public class BubbleSortTest {
    @Test
    public void test() {
        int[] nums = new int[]{1, 5, 3, 20, 9, 2, 3, 4, 6};
        BubbleSort.sort(nums);
        for (int n : nums) {
            System.out.print(n + " ");
        }
    }
    @Test
    public void test2() {
        int[] nums = new int[]{1, 5, 3, 20, 9, 2, 3, 4, 6};
        BubbleSort.bestSort(nums);
        for (int n : nums) {
            System.out.print(n + " ");
        }
    }
}
