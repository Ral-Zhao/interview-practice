package sort;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

public class CountingSortTest {
    @Test
    public void test() {
        int[] nums = new int[]{2, 5, 3, 2, 4, 9, 2, 0};
        CountingSort.sort(nums);
        System.out.println(JSON.toJSONString(nums));
    }
}
