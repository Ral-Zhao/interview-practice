package questions.offer;

import org.junit.Assert;
import org.junit.Test;

public class StackPushPopOrderTest {
    @Test
    public void test() {
        int[] push = new int[]{1, 2, 3, 4, 5, 6};
        int[] pop = new int[]{2, 1, 4, 3, 5, 6};
        Assert.assertTrue(StackPushPopOrder.isValid(push, pop));

        push = new int[]{1, 2, 3, 4, 5};
        pop = new int[]{4, 5, 3, 2, 1};
        Assert.assertTrue(StackPushPopOrder.isValid(push, pop));

        push = new int[]{1, 2, 3, 4, 5};
        pop = new int[]{4, 3, 5, 1, 2};
        Assert.assertTrue(!StackPushPopOrder.isValid(push, pop));
    }
}
