package questions.offer;

import org.junit.Assert;
import org.junit.Test;

public class NumberAppearingOnceTest {
    @Test
    public void test() {
        int[] nums = new int[]{1, 1, 1, 5, 5, 7, 5, 8, 8, 8};
        Assert.assertEquals(7, NumberAppearingOnce.getNumber(nums));
        nums = new int[]{2, 8, 8, 8};
        Assert.assertEquals(2, NumberAppearingOnce.getNumber(nums));
    }
}
