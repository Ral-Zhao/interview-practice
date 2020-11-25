package questions.offer;

import org.junit.Assert;
import org.junit.Test;

public class LeftRotateStringTest {
    @Test
    public void test(){
        Assert.assertEquals("cdefab",LeftRotateString.rotate("abcdef",2));
        Assert.assertEquals("bcdefa",LeftRotateString.rotate("abcdef",1));
        Assert.assertEquals("abc",LeftRotateString.rotate("abc",0));
        Assert.assertEquals("abc",LeftRotateString.rotate("abc",3));
    }
}
