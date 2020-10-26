package questions.offer;

import org.junit.Assert;
import org.junit.Test;

public class RegexTest {
    @Test
    public void testMatch(){
        Assert.assertTrue(Regex.match("ab.*c","abedc"));
        Assert.assertTrue(!Regex.match("ab*c","abedc"));
        Assert.assertTrue(!Regex.match("ab.c","abedc"));
        Assert.assertTrue(Regex.match("ab*c","abbbc"));
        Assert.assertTrue(Regex.match("ab*c","ac"));
    }
}
