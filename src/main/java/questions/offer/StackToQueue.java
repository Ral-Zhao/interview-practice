package questions.offer;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

/**
 * 题目9 用栈实现队列 用队列实现栈
 */
public class StackToQueue {
    private Stack<Integer> stack1 = new Stack<>();
    private Stack<Integer> stack2 = new Stack<>();

    private Queue<Integer> queue1 = new ArrayDeque<>();
    private Queue<Integer> queue2 = new ArrayDeque<>();

    public void appendTail(int item) {
        stack1.push(item);
    }

    public Integer deleteHead() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    public void push(int item) {
        queue1.add(item);
    }

    public Integer pop() {
        int size = queue1.size();
        if (size == 0) {
            return null;
        }
        while (size > 1) {
            queue2.add(queue1.poll());
            --size;
        }
        int result = queue1.poll();
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;
        return result;
    }
}
