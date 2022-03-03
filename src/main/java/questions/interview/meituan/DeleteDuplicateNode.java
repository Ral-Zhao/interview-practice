package questions.interview.meituan;

import questions.common.ListNode;
import util.ListNodeUtil;

/**
 */
public class DeleteDuplicateNode {
    public static ListNode deleteDuplicate(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dump = new ListNode();
        ListNode cur = head.next;
        ListNode tail = dump;
        ListNode start = head;
        int count = 1;
        while (cur != null) {
            if (cur.value > start.value) {
                if (count == 1) {
                    tail.next = start;
                    start.next = null;
                    tail = start;
                }
                count = 1;
                start = cur;
            } else {
                count++;
            }
            cur = cur.next;
        }

        return dump.next;
    }

    public static void main(String[] args) {
        ListNode head = ListNodeUtil.buildList(1, 2, 2, 3, 4, 5, 5);
        head = deleteDuplicate(head);
        ListNodeUtil.printNode(head);
        head = ListNodeUtil.buildList( 2, 2, 3, 4, 5, 5);
        head = deleteDuplicate(head);
        ListNodeUtil.printNode(head);
    }
}
