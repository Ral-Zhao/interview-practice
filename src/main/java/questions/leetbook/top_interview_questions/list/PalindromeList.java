package questions.leetbook.top_interview_questions.list;

import org.junit.Assert;
import questions.common.ListNode;
import util.ListNodeUtil;

/**
 * 给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：head = [1,2,2,1]
 * 输出：true
 * 示例 2：
 * <p>
 * <p>
 * 输入：head = [1,2]
 * 输出：false
 *  
 * <p>
 * 提示：
 * <p>
 * 链表中节点数目在范围[1, 105] 内
 * 0 <= Node.val <= 9
 *  
 * <p>
 * 进阶：你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 * <p>
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions/xaw0rm/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class PalindromeList {
    public boolean isPalindrome(ListNode head) {
        if (head.next == null) {
            return true;
        }
        ListNode sp = new ListNode();
        ListNode cur = head;
        int count = 0;
        while (cur != null) {
            count++;
            cur = cur.next;
        }
        cur = head;
        int tempCount = count / 2 - 1;
        while (tempCount > 0) {
            cur = cur.next;
            tempCount--;
        }
        ListNode headB = cur.next;
        cur.next = null;
        if (count % 2 == 1) {
            headB = headB.next;
        }
        cur = headB;
        while (cur != null) {
            headB = cur.next;
            cur.next = sp.next;
            sp.next = cur;
            cur = headB;
        }
        cur = sp.next;
        while (cur != null && head != null) {
            if (cur.value != head.value) {
                return false;
            }
            cur = cur.next;
            head = head.next;
        }
        return true;
    }

    public static void main(String[] args) {
        PalindromeList solution = new PalindromeList();
        ListNode head = ListNodeUtil.buildList(1, 2, 2, 1);
        Assert.assertTrue(solution.isPalindrome(head));
        head = ListNodeUtil.buildList(1, 2, 3, 2, 1);
        Assert.assertTrue(solution.isPalindrome(head));
        head = ListNodeUtil.buildList(1, 2);
        Assert.assertTrue(!solution.isPalindrome(head));
        head = ListNodeUtil.buildList(1, 2, 3);
        Assert.assertTrue(!solution.isPalindrome(head));
        head = ListNodeUtil.buildList(1);
        Assert.assertTrue(solution.isPalindrome(head));
    }
}
