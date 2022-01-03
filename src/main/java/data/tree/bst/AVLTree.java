package data.tree.bst;

import data.tree.common.TreeNode;
import questions.common.ListNode;

/**
 * 平衡二叉搜索树
 */
public class AVLTree {

    public static TreeNode build(ListNode list) {
        if (list == null) {
            return null;
        }
        if (list.next == null) {
            return new TreeNode(list.value);
        }
        ListNode fast = list.next;
        ListNode slow = list;
        ListNode pre = null;
        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        TreeNode root = new TreeNode(slow.value);
        fast = slow.next;
        slow.next = null;
        if (pre != null) {
            pre.next = null;
            pre = list;
        }
        root.left = build(pre);
        root.right = build(fast);
        return root;
    }


}
