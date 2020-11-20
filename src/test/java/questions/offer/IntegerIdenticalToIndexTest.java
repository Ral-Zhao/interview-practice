package questions.offer;

import org.junit.Assert;
import org.junit.Test;

public class IntegerIdenticalToIndexTest {
    @Test
    public void test() {
        int[] nums = new int[]{-5, -3, 0, 2, 4, 6, 8};
        Assert.assertEquals(4, IntegerIdenticalToIndex.getNumber(nums));
        nums = new int[]{-5, -3, 0, 2, 5, 6, 8};
        Assert.assertEquals(-1, IntegerIdenticalToIndex.getNumber(nums));
        nums = new int[]{0, 2, 5, 6, 8};
        Assert.assertEquals(0, IntegerIdenticalToIndex.getNumber(nums));
        nums = new int[]{-5, 0, 1, 2, 4};
        Assert.assertEquals(4, IntegerIdenticalToIndex.getNumber(nums));
        nums = new int[]{-5, 0, 1, 2, 5};
        Assert.assertEquals(-1, IntegerIdenticalToIndex.getNumber(nums));
    }
}
