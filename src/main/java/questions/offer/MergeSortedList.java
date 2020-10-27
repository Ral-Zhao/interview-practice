package questions.offer;

import questions.common.ListNode;

/**
 *  题目25 合并两个排序的链表
 *
 *  输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
 */
public class MergeSortedList {
    public static ListNode merge(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        }
        ListNode sp = new ListNode();
        ListNode point = sp;
        while (list1 != null && list2 != null) {
            if (list1.value > list2.value) {
                ListNode temp = list2;
                point.next = list2;
                list2 = list2.next;
                temp.next = null;
            } else {
                ListNode temp = list1;
                point.next = list1;
                list1 = list1.next;
                temp.next = null;
            }
            point = point.next;
        }
        if (list1!=null){
            point.next = list1;
        }
        if (list2!=null){
            point.next =list2;
        }
        return sp.next;
    }
}
