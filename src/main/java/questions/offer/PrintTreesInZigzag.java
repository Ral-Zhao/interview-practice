package questions.offer;

import data.tree.common.TreeNode;

import java.util.Stack;

/**
 *  题目32-2 之字形打印二叉树
 *
 *  按照之字形打印二叉树，即第一行从左到右的顺序打印，第二行从右到左，
 *  第三行从左到右，其他行照此类推。
 *
 */
public class PrintTreesInZigzag {
    public static void print(TreeNode root) {
        if (root == null) {
            return;
        }
        int current = 1;
        int next = 0;
        boolean back = false;
        Stack<TreeNode> stack = new Stack<>();
        Stack<TreeNode> backStack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            System.out.print(node.value + " ");
            current--;

            TreeNode left = node.left;
            TreeNode right = node.right;
            if (back) {
                TreeNode temp = right;
                right = left;
                left = temp;
            }
            if (left != null) {
                backStack.add(left);
                next++;
            }
            if (right != null) {
                backStack.add(right);
                next++;
            }

            if (current == 0) {
                System.out.println();
                current = next;
                next = 0;
                back = !back;
                Stack<TreeNode> temp = stack;
                stack = backStack;
                backStack = temp;
            }
        }
    }
}
