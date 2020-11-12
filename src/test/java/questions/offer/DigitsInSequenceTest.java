package questions.offer;

import org.junit.Assert;
import org.junit.Test;

public class DigitsInSequenceTest {
    @Test
    public void test() {
        Assert.assertEquals(DigitsInSequence.stupidMethod(2890), DigitsInSequence.getDigit(2890));
        Assert.assertEquals(DigitsInSequence.stupidMethod(2894), DigitsInSequence.getDigit(2894));
        Assert.assertEquals(DigitsInSequence.stupidMethod(280), DigitsInSequence.getDigit(280));
        Assert.assertEquals(DigitsInSequence.stupidMethod(18), DigitsInSequence.getDigit(18));
        Assert.assertEquals(DigitsInSequence.stupidMethod(375), DigitsInSequence.getDigit(375));
        Assert.assertEquals(DigitsInSequence.stupidMethod(258), DigitsInSequence.getDigit(258));
        Assert.assertEquals(DigitsInSequence.stupidMethod(1622), DigitsInSequence.getDigit(1622));
        Assert.assertEquals(DigitsInSequence.stupidMethod(780), DigitsInSequence.getDigit(780));
    }

    @Test
    public void testStupid() {
        System.out.println(DigitsInSequence.stupidMethod(280));
        System.out.println(DigitsInSequence.getDigit(280));
    }
}
