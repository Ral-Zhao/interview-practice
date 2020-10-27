package utils;

import questions.common.ListNode;

public class ListUtil {

    public static ListNode buildList(int... values){
        if (values == null || values.length == 0) {
            return null;
        }
        ListNode head = new ListNode(values[0]);
        ListNode pre = head;
        for (int i = 1; i < values.length; i++) {
            ListNode cur = new ListNode(values[i]);
            pre.next = cur;
            pre = cur;
        }

        return head;
    }

    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.value + " ");
            head = head.next;
        }
        System.out.println();
    }
}
