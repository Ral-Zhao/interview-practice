package questions.offer;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

/**
 * 题目59-2 队列的最大值
 *
 *  定义一个队列并实现max获得队列中的最大值。
 *  要求pop()、push()和max()方法的时间复杂度都是O(1)。
 */
public class QueueWithMax {
    private Queue<Integer> data = new ArrayDeque<>();
    private Deque<Integer> maxQueue = new ArrayDeque<>();

    public void push(int element) {
        data.add(element);
        while (!maxQueue.isEmpty() && maxQueue.getLast() < element) {
            maxQueue.pollLast();
        }
        maxQueue.addLast(element);
    }

    public Integer max() {
        return maxQueue.getFirst();
    }

    public Integer pop() {
        Integer element = data.poll();
        if (element != null && element.equals(maxQueue.getFirst())) {
            maxQueue.pollFirst();
        }
        return element;
    }

}
