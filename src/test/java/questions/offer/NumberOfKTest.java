package questions.offer;

import org.junit.Assert;
import org.junit.Test;

public class NumberOfKTest {
    @Test
    public void test() {
        int[] nums = new int[]{1, 2, 2, 3, 3, 3, 4, 7};
        Assert.assertEquals(3, NumberOfK.getNumber(nums, 3));
        Assert.assertEquals(2, NumberOfK.getNumber(nums, 2));
        Assert.assertEquals(1, NumberOfK.getNumber(nums, 4));
        Assert.assertEquals(0, NumberOfK.getNumber(nums, 6));
    }
}
