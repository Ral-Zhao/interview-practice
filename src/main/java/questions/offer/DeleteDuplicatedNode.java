package questions.offer;

import questions.common.ListNode;

/**
 *  题目18-2 删除链表中的重复节点
 *
 *  在一个排序的链表中，删除所有重复的节点
 */
public class DeleteDuplicatedNode {

    public static ListNode deleteDuplicatedNode(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode sp = new ListNode(-1);
        sp.next = head;
        ListNode pre = sp;

        while (pre.next != null) {
            ListNode cur = pre.next;
            if (cur.next != null && cur.next.value == cur.value) {
                while (cur.next != null && cur.next.value == cur.value) {
                    cur = cur.next;
                }
                ListNode temp = cur;
                pre.next = temp.next;
                temp.next = null;
            } else {
                pre = pre.next;
            }

        }

        return sp.next;
    }
}
