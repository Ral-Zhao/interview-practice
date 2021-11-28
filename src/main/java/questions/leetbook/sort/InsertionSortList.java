package questions.leetbook.sort;


/**
 * 对链表进行插入排序。
 *
 *
 * 插入排序的动画演示如上。从第一个元素开始，该链表可以被认为已经部分排序（用黑色表示）。
 * 每次迭代时，从输入数据中移除一个元素（用红色表示），并原地将其插入到已排好序的链表中。
 *
 *  
 *
 * 插入排序算法：
 *
 * 插入排序是迭代的，每次只移动一个元素，直到所有元素可以形成一个有序的输出列表。
 * 每次迭代中，插入排序只从输入数据中移除一个待排序的元素，找到它在序列中适当的位置，并将其插入。
 * 重复直到所有输入数据插入完为止。
 *  
 *
 * 示例 1：
 *
 * 输入: 4->2->1->3
 * 输出: 1->2->3->4
 * 示例 2：
 *
 * 输入: -1->5->3->4->0
 * 输出: -1->0->3->4->5
 *
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/sort-algorithms/euvypr/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class InsertionSortList {
    public ListNode insertionSortList(ListNode head) {
        if (head==null||head.next==null){
            return head;
        }
        ListNode cur = head.next;
        ListNode pre = head;
        while (cur!=null){
            ListNode next = cur.next;
            if (cur.val<head.val){
                pre.next = next;
                cur.next = head;
                head = cur;
                cur = next;
            }else {
                ListNode tmp = head;
                while (tmp.next!=cur&&tmp.next.val<cur.val){
                    tmp = tmp.next;
                }
                if (tmp.next == cur){
                    pre = cur;
                    cur = cur.next;
                }else {
                    ListNode tNext = tmp.next;
                    pre.next = next;
                    cur.next = tNext;
                    tmp.next = cur;
                    cur = next;
                }
            }
        }
        return head;
    }


    class ListNode { int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }}
}
