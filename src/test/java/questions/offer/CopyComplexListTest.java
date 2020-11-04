package questions.offer;

import org.junit.Assert;
import org.junit.Test;
import questions.common.ComplexListNode;

public class CopyComplexListTest {
    @Test
    public void test() {
        ComplexListNode head = new ComplexListNode(2);
        ComplexListNode node1 = new ComplexListNode(4);
        ComplexListNode node2 = new ComplexListNode(6);
        ComplexListNode node3 = new ComplexListNode(7);
        ComplexListNode node4 = new ComplexListNode(8);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node1.random = node3;
        node2.random = node4;
        node3.random = node2;
        node4.random = head;
        ComplexListNode copy = CopyComplexList.copy(head);
        Assert.assertEquals(2, copy.value);
        Assert.assertNull(copy.random);
        Assert.assertEquals(4, copy.next.value);
        Assert.assertEquals(7, copy.next.random.value);
        Assert.assertEquals(6, copy.next.next.value);
        Assert.assertEquals(8, copy.next.next.random.value);
        Assert.assertEquals(7, copy.next.next.next.value);
        Assert.assertEquals(6, copy.next.next.next.random.value);
        Assert.assertEquals(8, copy.next.next.next.next.value);
        Assert.assertEquals(2, copy.next.next.next.next.random.value);
        Assert.assertEquals(2, head.value);
        Assert.assertNull(head.random);
        Assert.assertEquals(4, head.next.value);
        Assert.assertEquals(7, head.next.random.value);
        Assert.assertEquals(6, head.next.next.value);
        Assert.assertEquals(8, head.next.next.random.value);
        Assert.assertEquals(7, head.next.next.next.value);
        Assert.assertEquals(6, head.next.next.next.random.value);
        Assert.assertEquals(8, head.next.next.next.next.value);
        Assert.assertEquals(2, head.next.next.next.next.random.value);

        head = new ComplexListNode(4);
        copy = CopyComplexList.copy(head);
        Assert.assertEquals(4, copy.value);
        Assert.assertNull(copy.next);
        Assert.assertNull(copy.random);
    }
}
