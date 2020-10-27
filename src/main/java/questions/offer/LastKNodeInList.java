package questions.offer;

import questions.common.ListNode;

/**
 * 题目22 链表中倒数第K个节点
 *
 * 输入链表，输出该链表中倒数第K个节点。
 */
public class LastKNodeInList {
    public static ListNode getLastKValue(ListNode head, int k) {
        if (head == null || k == 0) {
            return null;
        }
        ListNode first = head;
        ListNode second = head;
        while (k > 0 && first != null) {
            k--;
            first = first.next;
        }
        if (k > 0) {
            return null;
        }
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        return second;
    }
}
