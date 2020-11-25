package questions.offer;

import org.junit.Assert;
import org.junit.Test;

public class QueueWithMaxTest {
    @Test
    public void test() {
        QueueWithMax queue = new QueueWithMax();
        queue.push(3);
        queue.push(2);
        queue.push(1);
        Assert.assertEquals(3, queue.max().intValue());
        queue.pop();
        Assert.assertEquals(2, queue.max().intValue());
        queue.push(5);
        Assert.assertEquals(5, queue.max().intValue());
    }
}
