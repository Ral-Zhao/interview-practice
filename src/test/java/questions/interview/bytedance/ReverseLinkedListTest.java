package questions.interview.bytedance;

import org.junit.Test;
import questions.common.ListNode;

import static utils.ListUtil.buildList;
import static utils.ListUtil.printList;

public class ReverseLinkedListTest {
    @Test
    public void test() {
        ListNode head = buildList(1, 2, 3, 4, 5, 6, 7);
        head = ReverseLinkedList.reverseList(head, 3);
        printList(head);
    }
}
