package questions.interview.bytedance;

import questions.common.ListNode;

/** 时间：2021-1-24
 *
 *  给定一个单链表，实现一个调整单链表的函数，使得每 K 个节点之间的值逆序，如果最后不够 K 个节点一组，则不调整最后几个节点。
 *  示例1
 *  输入
 *  [1,2,3,4,5],3
 *  输出
 *  {3,2,1,4,5}
 *
 */
public class ReverseLinkedList {
    public static ListNode reverseList(ListNode head, int k) {
        if (head == null || k < 2) {
            return head;
        }
        ListNode sp = new ListNode();
        ListNode endPoint;
        ListNode sn = sp;
        ListNode cur = head;

        while (cur != null) {
            int time = k - 1;
            endPoint = cur;
            while (time > 0 && endPoint != null) {
                endPoint = endPoint.next;
                time--;
            }
            if (endPoint == null) {
                sn.next = cur;
                return sp.next;
            }
            time = k;
            ListNode curEnd = cur;
            ListNode curHead = cur;
            while (time > 0) {
                time--;
                ListNode curNext = cur.next;
                if (cur != curEnd) {
                    cur.next = curHead;
                    curHead = cur;
                }
                cur = curNext;
            }
            sn.next = curHead;
            sn = curEnd;
            curEnd.next = null;

        }

        return sp.next;
    }
}
