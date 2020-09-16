package questions.offer;

import org.junit.Test;

public class SearchRotateSortArrayTest {
    @Test
    public void testFindMin(){
        int[] nums = new int[]{1,2,3,4,5,6};
        System.out.println(SearchRotateSortArray.findMin(nums));
        nums = new int[]{4,5,6,1,2,3};
        System.out.println(SearchRotateSortArray.findMin(nums));
        nums = new int[]{1,1,1,1,0,1,1,1};
        System.out.println(SearchRotateSortArray.findMin(nums));
    }
}
