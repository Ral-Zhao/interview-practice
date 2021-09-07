package questions.leetbook.top_interview_questions.list;

import questions.common.ListNode;
import util.ListNodeUtil;

/**
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：head = [1,2,3,4,5]
 * 输出：[5,4,3,2,1]
 * 示例 2：
 * <p>
 * <p>
 * 输入：head = [1,2]
 * 输出：[2,1]
 * 示例 3：
 * <p>
 * 输入：head = []
 * 输出：[]
 *  
 * <p>
 * 提示：
 * <p>
 * 链表中节点的数目范围是 [0, 5000]
 * -5000 <= Node.val <= 5000
 *  
 * <p>
 * 进阶：链表可以选用迭代或递归方式完成反转。你能否用两种方法解决这道题？
 * <p>
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions/xavip3/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class ReverseList {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode sp = new ListNode();
        ListNode cur = head;
        while (cur != null) {
            ListNode temp = cur;
            cur = cur.next;
            temp.next = sp.next;
            sp.next = temp;
        }
        return sp.next;
    }

    public static void main(String[] args) {
        ReverseList solution = new ReverseList();
        ListNode head = ListNodeUtil.buildList(1, 2, 3, 8, 6, 2);
        head = solution.reverseList(head);
        ListNodeUtil.printNode(head);
        head = ListNodeUtil.buildList(1, 2, 3, 4, 5);
        head = solution.reverseList(head);
        ListNodeUtil.printNode(head);
    }
}
