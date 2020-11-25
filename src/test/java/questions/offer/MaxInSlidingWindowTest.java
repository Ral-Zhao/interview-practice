package questions.offer;

import com.alibaba.fastjson.JSON;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class MaxInSlidingWindowTest {
    @Test
    public void test() {
        int[] nums = new int[]{2, 3, 4, 2, 6, 2, 5, 1};
        List<Integer> list = MaxInSlidingWindow.getMax(nums, 3);
        Assert.assertNotNull(list);
        int[] result = new int[]{4, 4, 6, 6, 6, 5};
        assertList(result, list);

        nums = new int[]{2, 5, 5, 3, 3, 4};
        list = MaxInSlidingWindow.getMax(nums, 3);
        Assert.assertNotNull(list);
        result = new int[]{5, 5, 5, 4};
        assertList(result, list);

        nums = new int[]{2, 5, 4};
        list = MaxInSlidingWindow.getMax(nums, 3);
        Assert.assertNotNull(list);
        result = new int[]{5};
        assertList(result, list);

        nums = new int[]{2, 5, 4};
        list = MaxInSlidingWindow.getMax(nums, 5);
        Assert.assertNull(list);

        nums = new int[]{1, 2, 3};
        list = MaxInSlidingWindow.getMax(nums, 1);
        Assert.assertNotNull(list);
        result = new int[]{1, 2, 3};
        assertList(result, list);

    }

    private void assertList(int[] result, List<Integer> list) {
        Assert.assertEquals(result.length, list.size());
        for (int i = 0; i < result.length; i++) {
            Assert.assertEquals(result[i], list.get(i).intValue());
        }
    }
}
