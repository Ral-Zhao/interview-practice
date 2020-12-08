package questions.offer;

import org.junit.Assert;
import org.junit.Test;

public class ContinuousCardsTest {
    @Test
    public void test() {
        int[] cards = new int[]{3, 5, 7, 0, 0};
        Assert.assertTrue(ContinuousCards.isContinuous(cards));
        cards = new int[]{3, 5, 7, 6, 0};
        Assert.assertTrue(ContinuousCards.isContinuous(cards));
        cards = new int[]{5, 7, 8, 9, 10};
        Assert.assertTrue(!ContinuousCards.isContinuous(cards));
        cards = new int[]{5, 0, 0, 9, 10};
        Assert.assertTrue(!ContinuousCards.isContinuous(cards));
    }
}
