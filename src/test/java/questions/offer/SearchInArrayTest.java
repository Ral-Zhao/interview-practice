package questions.offer;

import org.junit.Assert;
import org.junit.Test;

public class SearchInArrayTest {

    @Test
    public void testHasNumber(){
        int[][] nums = new int[][]{
                {1,2,4,6,8},
                {3,10,18,31,43},
                {5,11,25,33,46},
                {7,12,26,38,50},
                {9,13,30,40,60}
        };

        Assert.assertTrue(SearchInArray.hasNumber(nums,26));
        Assert.assertTrue(!SearchInArray.hasNumber(nums,20));
    }
}
