package questions.offer;

import org.junit.Assert;
import org.junit.Test;

public class InversePairsTest {
    @Test
    public void test() {
        int[] nums = new int[]{7, 5, 6, 4};
        Assert.assertEquals(5, InversePairs.getInverseCount(nums));
        nums = new int[]{1, 2, 3, 4};
        Assert.assertEquals(0, InversePairs.getInverseCount(nums));
        nums = new int[]{5, 6, 3, 2};
        Assert.assertEquals(5, InversePairs.getInverseCount(nums));
        nums = new int[]{7, 6, 3, 2};
        Assert.assertEquals(6, InversePairs.getInverseCount(nums));
        nums = new int[]{8, 7, 6, 3, 2};
        Assert.assertEquals(10, InversePairs.getInverseCount(nums));
    }
}
