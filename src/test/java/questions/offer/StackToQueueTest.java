package questions.offer;

import org.junit.Test;

public class StackToQueueTest {

    @Test
    public void testQueue(){
        StackToQueue queue = new StackToQueue();
        queue.appendTail(1);
        queue.appendTail(2);
        queue.appendTail(3);
        int data = queue.deleteHead();
        System.out.println(data);
        queue.appendTail(5);
        data = queue.deleteHead();
        System.out.println(data);

    }

    @Test
    public void testStack(){
        StackToQueue stack = new StackToQueue();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        stack.push(5);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());

    }
}
