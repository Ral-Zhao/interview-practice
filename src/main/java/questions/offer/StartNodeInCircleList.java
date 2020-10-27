package questions.offer;

import questions.common.ListNode;

/**
 *  题目23 链表中环的入口节点
 *
 *  如果一个链表中包含环，找出该节点。
 */
public class StartNodeInCircleList {
    public static ListNode getStartNode(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode quick = head;
        ListNode slow = head;
        int quickDistance = 0;
        int slowDistance = 0;
        do {
            if (quick == null || quick.next == null) {
                return null;
            }
            quick = quick.next.next;
            quickDistance += 2;
            slow = slow.next;
            slowDistance += 1;
        } while (slow != quick);

        int delta = quickDistance - slowDistance;
        ListNode first = head;
        ListNode second = head;
        while (delta > 0) {
            delta--;
            first = first.next;
        }
        while (first != second) {
            first = first.next;
            second = second.next;
        }
        return second;
    }
}
