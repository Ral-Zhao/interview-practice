package data.queue;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 单调队列，解决滑动窗口的最值问题。
 */
public class MonotonicQueue {
    //双向队列用来存储元素
    private Deque<Integer> deque = new ArrayDeque<>();

    public void push(int item) {
        //从队尾开始讲所以比该元素小的元素出队.
        while (!deque.isEmpty() && deque.peekLast() < item) {
            deque.pollLast();
        }
        deque.addLast(item);
    }

    public int max() {
        return deque.peekFirst();
    }

    public void pop(int item) {
        //只有当需要出队的元素与队首即最大值元素相等时才出队.
        if (deque.peekFirst() == item) {
            deque.pollFirst();
        }
    }
}
