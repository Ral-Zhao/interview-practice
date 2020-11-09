package questions.offer;

import org.junit.Test;

public class KLeastNumbersTest {
    @Test
    public void test() {
        int[] nums = new int[]{5, 4, 6, 3, 2, 8, 16, 2, 1};
        int[] result = KLeastNumbers.getLeastNumbers(nums, 5);
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}
