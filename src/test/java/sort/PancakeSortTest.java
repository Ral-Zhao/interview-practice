package sort;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.List;

public class PancakeSortTest {

    @Test
    public void testSort(){
        int[] nums = new int[]{5,2,1,6,3,8};
        List<Integer> result = PancakeSort.sort(nums);
        System.out.println(JSON.toJSONString(result));
        System.out.println(JSON.toJSONString(nums));
    }
}
