package questions.offer;

import org.junit.Assert;
import org.junit.Test;

public class LongestSubstringWithoutDupTest {
    @Test
    public void test() {
        Assert.assertEquals(4, LongestSubstringWithoutDup.length("arabcacfr"));
        Assert.assertEquals(6, LongestSubstringWithoutDup.length("abaegsbayse"));
        Assert.assertEquals(1, LongestSubstringWithoutDup.length("aaaa"));
        Assert.assertEquals(2, LongestSubstringWithoutDup.length("abba"));
    }
}
