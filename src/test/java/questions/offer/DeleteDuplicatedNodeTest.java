package questions.offer;

import org.junit.Test;
import questions.common.ListNode;
import utils.ListUtil;

public class DeleteDuplicatedNodeTest {
    @Test
    public void testDeleteDuplicated() {
        ListNode head = ListUtil.buildList(1, 2, 3, 3, 3, 4, 4, 5);
        ListUtil.printList(head);
        head = DeleteDuplicatedNode.deleteDuplicatedNode(head);
        ListUtil.printList(head);

        head = ListUtil.buildList(1, 2, 3, 3, 3, 4, 4, 5, 5);
        ListUtil.printList(head);
        head = DeleteDuplicatedNode.deleteDuplicatedNode(head);
        ListUtil.printList(head);

        head = ListUtil.buildList(1, 1, 3, 3, 3, 4, 4, 5, 5);
        ListUtil.printList(head);
        head = DeleteDuplicatedNode.deleteDuplicatedNode(head);
        ListUtil.printList(head);

        head = ListUtil.buildList(1, 1, 2, 3, 3, 3, 4, 4, 5, 5);
        ListUtil.printList(head);
        head = DeleteDuplicatedNode.deleteDuplicatedNode(head);
        ListUtil.printList(head);
    }

}
