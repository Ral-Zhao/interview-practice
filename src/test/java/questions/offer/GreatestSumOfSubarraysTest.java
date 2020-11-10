package questions.offer;

import org.junit.Assert;
import org.junit.Test;

public class GreatestSumOfSubarraysTest {
    @Test
    public void test() {
        int[] arr = new int[]{1, -2, 3, 10, -4, 7, 2, -5};
        Assert.assertEquals(18, GreatestSumOfSubarrays.greatestSum(arr));
    }
}
