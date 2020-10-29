package questions.offer;

import java.util.Stack;

/**
 *  题目30 包含Min函数的栈
 *
 *  定义栈的数据结构，请在该类型中实现一个能够得到栈最小元素的min函数。
 *  在该栈中，调用min、push和pop的时间复杂度都是O(1)。
 */
public class MinInStack {
    private Stack<Integer> stack = new Stack<>();
    private Stack<Integer> minStack = new Stack<>();

    public void push(int num) {
        stack.push(num);
        if (minStack.isEmpty() || minStack.peek() >= num) {
            minStack.push(num);
        }
    }

    public Integer pop() {
        Integer result = stack.pop();
        if (result != null && minStack.peek().intValue() == result.intValue()) {
            minStack.pop();
        }
        return result;
    }
    public int min(){
        return minStack.peek();
    }
}
