package questions.offer;

import org.junit.Test;

public class DeleteDuplicatedNodeTest {
    @Test
    public void testDeleteDuplicated() {
        DeleteDuplicatedNode.Node head = buildList(1, 2, 3, 3, 3, 4, 4, 5);
        printList(head);
        head = DeleteDuplicatedNode.deleteDuplicatedNode(head);
        printList(head);

        head = buildList(1, 2, 3, 3, 3, 4, 4, 5, 5);
        printList(head);
        head = DeleteDuplicatedNode.deleteDuplicatedNode(head);
        printList(head);

        head = buildList(1, 1, 3, 3, 3, 4, 4, 5, 5);
        printList(head);
        head = DeleteDuplicatedNode.deleteDuplicatedNode(head);
        printList(head);

        head = buildList(1, 1, 2, 3, 3, 3, 4, 4, 5, 5);
        printList(head);
        head = DeleteDuplicatedNode.deleteDuplicatedNode(head);
        printList(head);

    }

    private DeleteDuplicatedNode.Node buildList(int... values) {
        if (values == null || values.length == 0) {
            return null;
        }
        DeleteDuplicatedNode.Node head = new DeleteDuplicatedNode.Node(values[0]);
        DeleteDuplicatedNode.Node pre = head;
        for (int i = 1; i < values.length; i++) {
            DeleteDuplicatedNode.Node cur = new DeleteDuplicatedNode.Node(values[i]);
            pre.next = cur;
            pre = cur;
        }

        return head;
    }

    private void printList(DeleteDuplicatedNode.Node head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }
}
