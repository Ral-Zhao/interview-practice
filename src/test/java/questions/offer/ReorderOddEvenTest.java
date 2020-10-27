package questions.offer;

import org.junit.Test;

public class ReorderOddEvenTest {
    @Test
    public void testReorder() {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6};
        ReorderOddEven.reorder(arr);
        print(arr);

        arr = new int[]{4,2,5,3,8};
        ReorderOddEven.reorder(arr);
        print(arr);
    }

    private void print(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
