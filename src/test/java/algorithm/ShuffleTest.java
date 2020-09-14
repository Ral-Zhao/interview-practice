package algorithm;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

public class ShuffleTest {

    @Test
    public void testShuffle(){
        int[] nums = new int[]{1,2,5,6,9,32,11,25};
        Shuffle.shuffle(nums);
        System.out.println(JSON.toJSONString(nums));
    }
}
