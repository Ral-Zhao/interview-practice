package questions.offer;

import org.junit.Assert;
import org.junit.Test;

public class SortArrayForMinNumberTest {
    @Test
    public void test() {
        int[] arr = new int[]{32, 3, 321};
        Assert.assertEquals("321323", SortArrayForMinNumber.minNumber(arr));
        arr = new int[]{5, 9, 3, 4, 4, 2, 8, 1};
        Assert.assertEquals("12344589", SortArrayForMinNumber.minNumber(arr));
    }
}
