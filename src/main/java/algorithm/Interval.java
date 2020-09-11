package algorithm;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 区间调度问题
 */
public class Interval {

    /**
     * 给定很多形如[start,end]的闭区间，算出这些区间中最多有几个互不相交的区间。
     * <p>
     * 正确的思路分为以下三步：
     * <p>
     * 1、从区间集合 intvs 中选择一个区间 x，这个 x 是在当前所有区间中结束最早的（end 最小）。
     * 2、把所有与 x 区间相交的区间从区间集合 intvs 中删除。
     * 3、重复步骤 1 和 2，直到 intvs 为空为止。之前选出的那些 x 就是最大不相交子集。
     */
    public static int intervalSchedule(int[][] interval) {
        //按照区间结束的位置进行升序排序
        Arrays.sort(interval, new IntervalEndComparator());
        System.out.println("after sort: " + JSON.toJSONString(interval));
        int count = 1;
        int end = interval[0][1];
        for (int i = 1; i < interval.length; i++) {
            if (interval[i][0] >= end) {
                count++;
                end = interval[i][1];
            }
        }
        return count;
    }

    /**
     * 合并重叠的区间
     */
    public static List<int[]> mergeInterval(int[][] interval) {
        //按照区间起始的位置进行升序排序
        Arrays.sort(interval, new IntervalStartComparator());
        System.out.println("after sort: " + JSON.toJSONString(interval));
        int end = interval[0][1];
        int start = interval[0][0];
        List<int[]> result = new ArrayList<>();
        for (int i = 1; i < interval.length; i++) {
            if (interval[i][0] <= end) {
                end = interval[i][1] > end ? interval[i][1] : end;
            }else {
                result.add(new int[]{start,end});
                start = interval[i][0];
                end = interval[i][1];
            }
        }
        result.add(new int[]{start,end});
        return result;
    }


    private static class IntervalEndComparator implements Comparator<int[]> {
        @Override
        public int compare(int[] o1, int[] o2) {
            return o1[1] - o2[1];
        }
    }

    private static class IntervalStartComparator implements Comparator<int[]> {
        @Override
        public int compare(int[] o1, int[] o2) {
            return o1[0] - o2[0];
        }
    }
}
