package questions.interview.microsoft;

import org.junit.Assert;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 给定一个数组，返回其子数组中，元素和不小于K的最短的子数组长度。
 * 如[2,1,1,3], k=4,满足要求的最短子数组是[1,3]，因此返回2；
 * 见leetcode 862
 */
public class ShortestSubArray {
    public static int shortestSubArray(int[] arr, int k) {
        if (arr[0] >= k) {
            return 1;
        }
        int[] sum = new int[arr.length];
        int min = arr.length + 1;
        sum[0] = arr[0];
        for (int i = 1; i < sum.length; i++) {
            sum[i] = arr[i] + sum[i - 1];
        }
        Deque<Integer> deque = new ArrayDeque<>();
        deque.addLast(0);
        for (int i = 1; i < sum.length; i++) {
            while (!deque.isEmpty() && sum[deque.peekLast()] >= sum[i]) {
                deque.pollLast();
            }
            while (!deque.isEmpty() && sum[i] - sum[deque.peekFirst()] >= k) {
                min = Math.min(min, i - deque.pollFirst());
            }
            deque.addLast(i);
        }

        return min == arr.length + 1 ? -1 : min;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2, 1, 1, 3};
        Assert.assertEquals(2, shortestSubArray(arr, 4));
        arr = new int[]{2, -3, 1, 3};
        Assert.assertEquals(2, shortestSubArray(arr, 4));
    }
}
