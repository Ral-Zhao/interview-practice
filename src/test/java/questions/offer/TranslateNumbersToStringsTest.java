package questions.offer;

import org.junit.Assert;
import org.junit.Test;

public class TranslateNumbersToStringsTest {
    @Test
    public void test() {
        Assert.assertEquals(5, TranslateNumbersToStrings.trasnlateNumbers("12258"));
        Assert.assertEquals(1, TranslateNumbersToStrings.trasnlateNumbers("8"));
        Assert.assertEquals(1, TranslateNumbersToStrings.trasnlateNumbers("38"));
        Assert.assertEquals(2, TranslateNumbersToStrings.trasnlateNumbers("18"));
        Assert.assertEquals(8, TranslateNumbersToStrings.trasnlateNumbers("231425"));
    }
}
