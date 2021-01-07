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

    @Test
    public void testLongestCommonSubstring() {
        Assert.assertEquals("abc", StringAlgorithm.longestCommonSubstring("adefbfeic", "51auilybc1n"));
        Assert.assertEquals("abcn", StringAlgorithm.longestCommonSubstring("adefbfeicn", "51auilybc1n"));
        Assert.assertEquals("bgh", StringAlgorithm.longestCommonSubstring("a1b2e5g6h", "5n57bjtg978+h87e"));
    }
}
