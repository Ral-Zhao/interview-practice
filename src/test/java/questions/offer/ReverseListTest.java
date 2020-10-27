package questions.offer;

import org.junit.Test;
import questions.common.ListNode;
import utils.ListUtil;

public class ReverseListTest {
    @Test
    public void test() {
        ListNode head = ListUtil.buildList(1, 2, 3, 4, 5);
        head = ReverseList.reverse(head);
        ListUtil.printList(head);

        head = ListUtil.buildList(1, 2);
        head = ReverseList.reverse(head);
        ListUtil.printList(head);

        head = ListUtil.buildList(1);
        head = ReverseList.reverse(head);
        ListUtil.printList(head);
    }
}
