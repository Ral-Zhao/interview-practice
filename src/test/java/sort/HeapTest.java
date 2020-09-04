package sort;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

public class HeapTest {

    @Test
    public void test(){
        int[] arr = new int[]{4,5,8,2,3,9,7,10};
        Heap.sort(arr);
        System.out.println(JSON.toJSONString(arr));
    }
}
