package data.queue;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class MonotonicQueueTest {

    /**
     * 滑动窗口的最值问题
     */
    @Test
    public void maxSlidingWindow() {
        int[] nums = new int[]{1, 2, 6, 0, 8, -4, 1, 14, 8, 6, 4};
        MonotonicQueue queue = new MonotonicQueue();
        int k = 3;
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i < k - 1) {
                queue.push(nums[i]);
            } else {
                queue.push(nums[i]);
                result.add(queue.max());
                queue.pop(nums[i - k + 1]);
            }
        }
        System.out.println(JSON.toJSONString(result));
    }

}
