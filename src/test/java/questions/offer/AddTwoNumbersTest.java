package questions.offer;

import org.junit.Assert;
import org.junit.Test;

public class AddTwoNumbersTest {
    @Test
    public void test() {
        Assert.assertEquals(12, AddTwoNumbers.add(5, 7));
        Assert.assertEquals(12, AddTwoNumbers.add(2, 10));
        Assert.assertEquals(4, AddTwoNumbers.add(2, 2));
        Assert.assertEquals(15, AddTwoNumbers.add(15, 0));
        Assert.assertEquals(100, AddTwoNumbers.add(52, 48));
    }
}
