package questions.offer;

import org.junit.Test;
import questions.common.ListNode;
import utils.ListUtil;

public class DeleteListNodeTest {
    @Test
    public void testDelete() {
        ListNode head = new ListNode(0);
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        head = DeleteListNode.deleteNode(head, node1);
        ListUtil.printList(head);
        head = DeleteListNode.deleteNode(head, node4);
        ListUtil.printList(head);

        head = new ListNode(54);
        head = DeleteListNode.deleteNode(head, head);
        ListUtil.printList(head);


    }
}
