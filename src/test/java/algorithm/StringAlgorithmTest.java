package algorithm;

import org.junit.Assert;
import org.junit.Test;

public class StringAlgorithmTest {
    @Test
    public void testEditDistance() {
        Assert.assertEquals(2, StringAlgorithm.editDistance("egsf", "egfs"));
        Assert.assertEquals(3, StringAlgorithm.editDistance("egijae", "gfjas"));
    }

    @Test
    public void testKmp() {
        Assert.assertEquals(8, StringAlgorithm.kmp("absdabsgabsdfe", "absdf"));
    }
}
