package questions.offer;

import org.junit.Test;

public class DuplicationInArrayTest {

    @Test
    public void testDuplicate(){
        int[] nums = new int[]{0,4,2,3,5,6,1,3};
        System.out.println(DuplicationInArray.duplicate(nums));
    }

    @Test
    public void testDuplicate2(){
        int[] nums = new int[]{2,3,5,4,1,2,6,7};
        System.out.println(DuplicationInArray.duplicate2(nums));
    }
}
