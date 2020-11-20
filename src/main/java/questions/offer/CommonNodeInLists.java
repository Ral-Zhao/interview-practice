package questions.offer;

import questions.common.ListNode;

import java.util.Stack;

/**
 *  题目52 两个链表的第一个公共节点
 *
 *  输入两个链表，找出它们的第一个公共节点。
 */
public class CommonNodeInLists {
    public static ListNode method1(ListNode list1, ListNode list2) {
        if (list1 == null || list2 == null) {
            return null;
        }
        Stack<ListNode> stack1 = new Stack<>();
        Stack<ListNode> stack2 = new Stack<>();
        while (list1 != null) {
            stack1.push(list1);
            list1 = list1.next;
        }
        while (list2 != null) {
            stack2.push(list2);
            list2 = list2.next;
        }
        ListNode pre = null;
        while (!stack1.isEmpty() && !stack2.isEmpty()) {
            if (stack1.peek() == stack2.peek()) {
                pre = stack1.pop();
                stack2.pop();
            } else {
                break;
            }
        }
        return pre;
    }

    public static ListNode method2(ListNode list1, ListNode list2) {
        if (list1 == null || list2 == null) {
            return null;
        }
        int len1 = 0;
        int len2 = 0;
        ListNode longList = list1;
        ListNode shortList = list2;
        while (longList != null) {
            len1++;
            longList = longList.next;
        }
        longList = list1;
        while (shortList != null) {
            len2++;
            shortList = shortList.next;
        }
        shortList = list2;
        if (len1 < len2) {
            ListNode temp = shortList;
            shortList = longList;
            longList = temp;
            int t = len1;
            len1 = len2;
            len2 = t;
        }
        int delta = len1 - len2;
        while (delta > 0) {
            longList = longList.next;
            delta--;
        }
        while (longList != null && shortList != null) {
            if (longList == shortList) {
                return longList;
            }
            longList = longList.next;
            shortList = shortList.next;
        }
        return null;
    }


}
