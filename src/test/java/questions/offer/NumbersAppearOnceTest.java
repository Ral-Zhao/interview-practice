package questions.offer;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class NumbersAppearOnceTest {
    @Test
    public void test() {
        int[] nums = new int[]{2, 3, 2, 6, 4, 4, 8, 8};
        List<Integer> result = NumbersAppearOnce.getOnce(nums);
        Assert.assertNotNull(result);
        Assert.assertEquals(2, result.size());
        Assert.assertTrue(result.contains(3));
        Assert.assertTrue(result.contains(6));
        nums = new int[]{2, 4};
        result = NumbersAppearOnce.getOnce(nums);
        Assert.assertNotNull(result);
        Assert.assertEquals(2, result.size());
        Assert.assertTrue(result.contains(2));
        Assert.assertTrue(result.contains(4));
        nums = new int[]{1, 5, 3, 3};
        result = NumbersAppearOnce.getOnce(nums);
        Assert.assertNotNull(result);
        Assert.assertEquals(2, result.size());
        Assert.assertTrue(result.contains(1));
        Assert.assertTrue(result.contains(5));

    }
}
