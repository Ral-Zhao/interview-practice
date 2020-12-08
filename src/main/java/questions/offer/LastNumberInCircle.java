package questions.offer;

import questions.common.ListNode;

/**
 *  题目62 圆圈中最后剩下的数字
 *
 *  0,1,…,n-1这n个数字排成一个圆圈，从数字0开始，每次从这个圆圈里删除第m个数字。
 *  求出这个圆圈里剩下的最后一个数字。
 */
public class LastNumberInCircle {
    public static int lastNumber(int n, int m) {
        if (n < 1 || m < 1) {
            return -1;
        }
        ListNode head = null;
        ListNode pre = null;
        for (int i = 0; i < n; i++) {
            ListNode node = new ListNode(i);
            if (head == null) {
                head = node;
            } else {
                pre.next = node;
            }
            pre = node;
        }
        pre.next = head;

        while (head.next != head) {
            int temp = m;
            while (temp - 1 > 1) {
                temp--;
                head = head.next;
            }
            ListNode delete = head.next;
            ListNode next = delete.next;
            delete.next = null;
            head.next = next;
            head = next;
        }
        return head.value;
    }

    public static int perfect(int n, int m) {
        if (n < 1 || m < 1) {
            return -1;
        }
        int last = 0;
        for (int i = 2; i <= n; i++) {
            last = (last + m) % i;
        }
        return last;
    }
}
