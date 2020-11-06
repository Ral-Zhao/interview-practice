package questions.offer;

import org.junit.Assert;
import org.junit.Test;

public class MoreThanHalfNumberTest {
    @Test
    public void testMethod1(){
        int[] arr = new int[]{4,1,5,2,2,4,2,2,2};
        Assert.assertEquals(2,MoreThanHalfNumber.method1(arr));
        arr = new int[]{4,1,5,2,2,4,2,2};
        Assert.assertEquals(0,MoreThanHalfNumber.method1(arr));
        arr = new int[]{4,1,4};
        Assert.assertEquals(4,MoreThanHalfNumber.method1(arr));
    }
    @Test
    public void testMethod2(){
        int[] arr = new int[]{4,1,5,2,2,4,2,2,2};
        Assert.assertEquals(2,MoreThanHalfNumber.method2(arr));
        arr = new int[]{4,1,5,2,2,4,2,2};
        Assert.assertEquals(0,MoreThanHalfNumber.method2(arr));
        arr = new int[]{4,1,4};
        Assert.assertEquals(4,MoreThanHalfNumber.method2(arr));
    }
}
