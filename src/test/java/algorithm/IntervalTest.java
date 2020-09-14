package algorithm;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

public class IntervalTest {

    @Test
    public void testIntervalSchedule(){
        int[][] interval = new int[][]{{1,3},{7,9},{3,5},{1,2},{4,6},{2,4}};
        System.out.println(Interval.intervalSchedule(interval));
    }

    @Test
    public void testMergeInterval(){
        int[][] interval = new int[][]{{1,3},{6,9},{4,5},{1,2},{4,6}};
        System.out.println(JSON.toJSONString(Interval.mergeInterval(interval)));
    }

    @Test
    public void testIntersection(){
        int[][] intervalA = new int[][]{{1,5},{6,8},{10,11}};
        int[][] intervalB = new int[][]{{1,2},{3,4},{7,9},{11,12}};

        System.out.println(JSON.toJSONString(Interval.intersection(intervalA,intervalB)));
    }
}
