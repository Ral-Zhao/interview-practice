package questions.offer;

import data.tree.common.TreeNode;

import java.util.Stack;

/**
 *  题目36 二叉搜索树与双向链表
 *
 *  输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
 *  要求不能创建任何新的节点，只能调整树中节点指针指向。
 */
public class ConvertBinarySearchTree {
    public static TreeNode convert(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode head;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode temp;
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
        head = stack.peek();
        temp = head;
        while (!stack.isEmpty()) {
            TreeNode top = stack.pop();
            if (top != temp) {
                temp.right = top;
                top.left = temp;
                temp = top;
            }
            root = top.right;
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
        }
        return head;
    }

}
