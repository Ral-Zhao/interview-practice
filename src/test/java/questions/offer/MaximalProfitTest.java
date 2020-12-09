package questions.offer;

import org.junit.Assert;
import org.junit.Test;

public class MaximalProfitTest {
    @Test
    public void test() {
        int[] prices = new int[]{9, 11, 8, 5, 7, 12, 16, 14};
        Assert.assertEquals(11, MaximalProfit.maxProfit(prices));
        prices = new int[]{4, 2, 6, 8, 3, 4, 9, 12, 1, 18};
        Assert.assertEquals(17, MaximalProfit.maxProfit(prices));
    }
}
