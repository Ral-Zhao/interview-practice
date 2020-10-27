package questions.offer;

import questions.common.ListNode;

/**
 *  题目24 反转链表
 *
 *  输入一个链表的头结点，返回反转后的链表的头结点。
 */
public class ReverseList {
    public static ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode cur = head.next;
        ListNode pre = head;
        head.next = null;
        do {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        } while (cur != null);

        return pre;
    }
}
