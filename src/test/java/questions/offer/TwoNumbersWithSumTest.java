package questions.offer;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class TwoNumbersWithSumTest {
    @Test
    public void test() {
        int[] nums = new int[]{1, 2};
        List<Integer> result = TwoNumbersWithSum.getNumbers(nums, 4);
        Assert.assertNull(result);
        nums = new int[]{1, 1, 2, 3, 4, 4, 5, 7};
        result = TwoNumbersWithSum.getNumbers(nums, 6);
        Assert.assertNotNull(result);
        Assert.assertEquals(2, result.size());
        Assert.assertTrue(result.contains(1));
        Assert.assertTrue(result.contains(5));
        result = TwoNumbersWithSum.getNumbers(nums, 7);
        Assert.assertNotNull(result);
        Assert.assertEquals(2, result.size());
        Assert.assertTrue(result.contains(2));
        Assert.assertTrue(result.contains(5));
    }
}
