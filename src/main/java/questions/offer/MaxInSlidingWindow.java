package questions.offer;

import java.util.*;

/**
 * 题目59-1 队列的最大值
 * <p>
 * 给定一个数组和滑动窗口的大小，请找出所有滑动窗口里的最大值。
 * 例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口大小3，则一共存在6个滑动窗口，
 * 它们的最大值分别是{4,4,6,6,6,5}
 */
public class MaxInSlidingWindow {
    public static List<Integer> getMax(int[] nums, int window) {
        if (nums == null || nums.length == 0 || window < 1 || window > nums.length) {
            return null;
        }
        Deque<Integer> deque = new ArrayDeque<>();
        List<Integer> list = new ArrayList<>();
        int left = 0;
        while (left < window - 1) {
            while (!deque.isEmpty() && deque.getLast() < nums[left]) {
                deque.pollLast();
            }
            deque.addLast(nums[left]);
            left++;
        }
        left = 0;
        for (int i = window - 1; i < nums.length; i++) {
            while (!deque.isEmpty() && deque.getLast() < nums[i]) {
                deque.pollLast();
            }
            deque.addLast(nums[i]);
            list.add(deque.getFirst());
            if (deque.getFirst() == nums[left]) {
                deque.pollFirst();
            }
            left++;
        }
        return list;
    }
}
