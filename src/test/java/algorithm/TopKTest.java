package algorithm;

import org.junit.Assert;
import org.junit.Test;

public class TopKTest {
    @Test
    public void testMethodOne() {
        TopK topK = new TopK();
        int[] nums = new int[]{5, 2, 3, 1, 9, 7, 6, 5};
        Assert.assertEquals(6, topK.method_1(nums, 3));
        Assert.assertEquals(5, topK.method_1(nums, 4));
        Assert.assertEquals(5, topK.method_1(nums, 5));
        Assert.assertEquals(2, topK.method_1(nums, 7));
    }

    @Test
    public void testMethodTwo() {
        TopK topK = new TopK();
        int[] nums = new int[]{5, 2, 3, 1, 9, 7, 6, 5};
        Assert.assertEquals(6, topK.method_2(nums, 3));
        Assert.assertEquals(5, topK.method_2(nums, 4));
        Assert.assertEquals(5, topK.method_2(nums, 5));
        Assert.assertEquals(2, topK.method_2(nums, 7));
        nums = new int[]{3, 2, 1, 5, 6, 4};
        Assert.assertEquals(5, topK.method_2(nums, 2));
        Assert.assertEquals(4, topK.method_2(nums, 3));
        Assert.assertEquals(3, topK.method_2(nums, 4));
        Assert.assertEquals(2, topK.method_2(nums, 5));
    }
}
