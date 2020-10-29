package questions.offer;

import org.junit.Assert;
import org.junit.Test;

public class MinInStackTest {
    @Test
    public void test(){
        MinInStack stack = new MinInStack();
        stack.push(4);
        stack.push(6);
        stack.push(4);
        stack.push(7);
        Assert.assertEquals(4,stack.min());
        stack.pop();
        stack.pop();
        Assert.assertEquals(4,stack.min());
        stack.push(2);
        stack.push(3);
        Assert.assertEquals(2,stack.min());

    }
}
