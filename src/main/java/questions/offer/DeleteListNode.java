package questions.offer;

import questions.common.ListNode;

/**
 *  题目18-1 删除链表的节点
 *
 *  给定单链表的头结点和目标节点，在O(1)时间内删除该节点
 *
 */
public class DeleteListNode {

    public static ListNode deleteNode(ListNode head, ListNode target) {
        if (target.next != null) {
            ListNode next = target.next;
            target.value = next.value;
            target.next = next.next;
            next.next = null;
        } else if (target == head) {
            head = null;
        } else {
            ListNode pre = head;
            while (pre.next != target) {
                pre = pre.next;
            }
            pre.next = null;
        }
        return head;
    }
}
