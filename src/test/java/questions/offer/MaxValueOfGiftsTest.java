package questions.offer;

import org.junit.Assert;
import org.junit.Test;

public class MaxValueOfGiftsTest {
    @Test
    public void test() {
        int[][] gifts = new int[][]{
                {1, 10, 3, 8},
                {12, 2, 9, 6},
                {5, 7, 4, 11},
                {3, 7, 16, 5},
        };
        Assert.assertEquals(53, MaxValueOfGifts.maxValue(gifts));
        gifts = new int[][]{
                {1, 10, 3, 8},
                {12, 2, 9, 6},
        };
        Assert.assertEquals(30, MaxValueOfGifts.maxValue(gifts));
    }
}
