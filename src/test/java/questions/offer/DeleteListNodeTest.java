package questions.offer;

import org.junit.Test;

public class DeleteListNodeTest {
    @Test
    public void testDelete() {
        DeleteListNode.Node head = new DeleteListNode.Node(0);
        DeleteListNode.Node node1 = new DeleteListNode.Node(1);
        DeleteListNode.Node node2 = new DeleteListNode.Node(2);
        DeleteListNode.Node node3 = new DeleteListNode.Node(3);
        DeleteListNode.Node node4 = new DeleteListNode.Node(4);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        head = DeleteListNode.deleteNode(head, node1);
        printList(head);
        head = DeleteListNode.deleteNode(head, node4);
        printList(head);

        head = new DeleteListNode.Node(54);
        head = DeleteListNode.deleteNode(head, head);
        printList(head);


    }

    private void printList(DeleteListNode.Node head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }
}
