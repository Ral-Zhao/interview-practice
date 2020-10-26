package questions.offer;

import org.junit.Assert;
import org.junit.Test;

public class ValidNumberStringTest {
    @Test
    public void test(){
        Assert.assertTrue(ValidNumberString.isValidNumberString("-123"));
        Assert.assertTrue(!ValidNumberString.isValidNumberString("-123a"));
        Assert.assertTrue(!ValidNumberString.isValidNumberString("-123e"));
        Assert.assertTrue(ValidNumberString.isValidNumberString("-123e5"));

        Assert.assertTrue(ValidNumberString.isValidNumberString("5e2"));
        Assert.assertTrue(ValidNumberString.isValidNumberString("3.14152"));
        Assert.assertTrue(ValidNumberString.isValidNumberString("-1E-16"));

        Assert.assertTrue(!ValidNumberString.isValidNumberString("12E"));
        Assert.assertTrue(!ValidNumberString.isValidNumberString("1a3.14"));
        Assert.assertTrue(!ValidNumberString.isValidNumberString("1.2.3"));
        Assert.assertTrue(!ValidNumberString.isValidNumberString("+-5"));
        Assert.assertTrue(!ValidNumberString.isValidNumberString("12e+5.1"));

    }
}
