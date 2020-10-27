package questions.offer;

import org.junit.Assert;
import org.junit.Test;
import questions.common.ListNode;

public class StartNodeInCircleListTest {
    @Test
    public void test(){
        ListNode head = new ListNode(0);
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node4;
        ListNode joint = StartNodeInCircleList.getStartNode(head);
        Assert.assertNotNull(joint);
        Assert.assertEquals(4,joint.value);

        node6.next = null;
        joint = StartNodeInCircleList.getStartNode(head);
        Assert.assertNull(joint);

    }
}
