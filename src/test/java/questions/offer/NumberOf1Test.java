package questions.offer;

import org.junit.Assert;
import org.junit.Test;

public class NumberOf1Test {
    @Test
    public void test(){
        Assert.assertEquals(5,NumberOf1.getNumbers(12));
        Assert.assertEquals(15,NumberOf1.getNumbers(50));
        Assert.assertEquals(1776,NumberOf1.getNumbers(2352));
    }
}
