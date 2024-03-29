package questions.leetbook.top_interview_questions.list;

import questions.common.ListNode;
import util.ListNodeUtil;

/**
 * 给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。
 * <p>
 * 请尝试使用原地算法完成。你的算法的空间复杂度应为 O(1)，时间复杂度应为 O(nodes)，nodes 为节点总数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1->2->3->4->5->NULL
 * 输出: 1->3->5->2->4->NULL
 * 示例 2:
 * <p>
 * 输入: 2->1->3->5->6->4->7->NULL
 * 输出: 2->3->6->7->1->5->4->NULL
 * 说明:
 * <p>
 * 应当保持奇数节点和偶数节点的相对顺序。
 * 链表的第一个节点视为奇数节点，第二个节点视为偶数节点，以此类推。
 * <p>
 * <p>
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions/xa0a97/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class OddEvenList {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode oddHead = new ListNode();
        ListNode oddTail = oddHead;
        ListNode evenHead = new ListNode();
        ListNode evenTail = evenHead;
        int count = 1;
        while (head != null) {
            ListNode next = head.next;
            if (count % 2 == 1) {
                oddTail.next = head;
                oddTail = head;
            } else {
                evenTail.next = head;
                evenTail = head;
            }
            head.next = null;
            head = next;
            count++;
        }
        oddTail.next = evenHead.next;
        evenHead.next = null;
        return oddHead.next;
    }

    public static void main(String[] args) {
        OddEvenList solution = new OddEvenList();
        ListNode head = ListNodeUtil.buildList(1, 2, 3, 4, 5);
        head = solution.oddEvenList(head);
        ListNodeUtil.printNode(head);
        head = ListNodeUtil.buildList(2, 1, 3, 5, 6, 4, 7);
        head = solution.oddEvenList(head);
        ListNodeUtil.printNode(head);
    }
}
