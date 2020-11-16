package questions.offer;

import org.junit.Assert;
import org.junit.Test;

public class UglyNumberTest {
    @Test
    public void test(){
        Assert.assertEquals(4,UglyNumber.getNumber(4));
        Assert.assertEquals(5,UglyNumber.getNumber(5));
        Assert.assertEquals(8,UglyNumber.getNumber(7));
        Assert.assertEquals(12,UglyNumber.getNumber(10));
        Assert.assertEquals(15,UglyNumber.getNumber(11));
        Assert.assertEquals(16,UglyNumber.getNumber(12));
        Assert.assertEquals(18,UglyNumber.getNumber(13));
    }
}
