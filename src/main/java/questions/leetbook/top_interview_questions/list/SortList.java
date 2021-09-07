package questions.leetbook.top_interview_questions.list;

import questions.common.ListNode;
import util.ListNodeUtil;

/**
 * 给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
 * <p>
 * 进阶：
 * <p>
 * 你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：head = [4,2,1,3]
 * 输出：[1,2,3,4]
 * 示例 2：
 * <p>
 * <p>
 * 输入：head = [-1,5,3,4,0]
 * 输出：[-1,0,3,4,5]
 * 示例 3：
 * <p>
 * 输入：head = []
 * 输出：[]
 *  
 * <p>
 * 提示：
 * <p>
 * 链表中节点的数目在范围 [0, 5 * 104] 内
 * -105 <= Node.val <= 105
 * <p>
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions/xa262d/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class SortList {
    public ListNode sortList(ListNode head) {
        return sort(head);
    }

    private ListNode sort(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        ListNode first = head;
        ListNode last = head.next;
        while (last != null && last.next != null) {
            first = first.next;
            last = last.next.next;
        }
        last = first.next;
        first.next = null;
        first = sort(head);
        last = sort(last);
        return merge(first, last);
    }

    private ListNode merge(ListNode first, ListNode last) {
        ListNode sp = new ListNode();
        ListNode cur = sp;
        while (first != null && last != null) {
            ListNode temp;
            if (first.value >= last.value) {
                temp = last;
                last = last.next;
            } else {
                temp = first;
                first = first.next;
            }
            cur.next = temp;
            cur = temp;
            temp.next = null;
        }
        if (first != null) {
            cur.next = first;
        }
        if (last != null) {
            cur.next = last;
        }
        return sp.next;
    }

    public static void main(String[] args) {
        SortList sortList = new SortList();
        ListNode head = ListNodeUtil.buildList(4, 2, 1, 3);
        head = sortList.sortList(head);
        ListNodeUtil.printNode(head);
        head = ListNodeUtil.buildList(4, 2, 1);
        head = sortList.sortList(head);
        ListNodeUtil.printNode(head);
        head = ListNodeUtil.buildList(4, 1);
        head = sortList.sortList(head);
        ListNodeUtil.printNode(head);
        head = ListNodeUtil.buildList(4);
        head = sortList.sortList(head);
        ListNodeUtil.printNode(head);
        head = ListNodeUtil.buildList(-1, 5, 3, 4, 0);
        head = sortList.sortList(head);
        ListNodeUtil.printNode(head);
    }
}
