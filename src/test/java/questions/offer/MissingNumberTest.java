package questions.offer;

import org.junit.Assert;
import org.junit.Test;

public class MissingNumberTest {
    @Test
    public void test() {
        int[] nums = new int[]{0, 1, 2, 3, 5, 6, 7};
        Assert.assertEquals(4, MissingNumber.missingNumber(nums));
        nums = new int[]{0, 1, 2, 3, 4, 6, 7};
        Assert.assertEquals(5, MissingNumber.missingNumber(nums));
        nums = new int[]{0, 1, 2, 3, 4, 5, 6};
        Assert.assertEquals(7, MissingNumber.missingNumber(nums));
        nums = new int[]{1, 2, 3, 4, 5, 6, 7};
        Assert.assertEquals(0, MissingNumber.missingNumber(nums));
    }
}
