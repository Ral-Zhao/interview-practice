package questions.offer;

import org.junit.Assert;
import org.junit.Test;

public class LastNumberInCircleTest {
    @Test
    public void test() {
        Assert.assertEquals(LastNumberInCircle.perfect(5, 3), LastNumberInCircle.lastNumber(5, 3));
        Assert.assertEquals(LastNumberInCircle.perfect(12, 6), LastNumberInCircle.lastNumber(12, 6));
        Assert.assertEquals(LastNumberInCircle.perfect(8, 6), LastNumberInCircle.lastNumber(8, 6));
        Assert.assertEquals(LastNumberInCircle.perfect(28, 15), LastNumberInCircle.lastNumber(28, 15));
        Assert.assertEquals(LastNumberInCircle.perfect(18, 20), LastNumberInCircle.lastNumber(18, 20));
    }
}
