package questions.offer;

import data.tree.common.TreeNode;

/**
 *  题目55-2 平衡二叉树
 *
 *  输入一棵二叉树的根节点，判断该树是不是平衡二叉树。
 *  如果二叉树中任意节点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树。
 */
public class BalancedBinaryTree {

    public static boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        Depth depth = new Depth(0);
        return balanced(root, depth);
    }

    private static boolean balanced(TreeNode node, Depth depth) {
        if (node == null) {
            depth.value = 0;
            return true;
        }
        Depth left = new Depth(0);
        Depth right = new Depth(0);
        if (balanced(node.left, left) && balanced(node.right, right)) {
            if (Math.abs(left.value - right.value) <= 1) {
                depth.value = 1 + Math.max(left.value, right.value);
                return true;
            }
        }
        return false;
    }

    private static class Depth {
        int value;

        Depth(int depth) {
            this.value = depth;
        }
    }
}
