package questions.offer;

import data.tree.common.TreeNode;

/**
 *  题目28 对称的二叉树
 *
 *  判断一课二叉树是不是对称的。
 *  如果一课二叉树和它的镜像相同即是对称的。
 */
public class SymmetricalBinaryTree {
    public static boolean isSymmetrical(TreeNode root) {
        return helper(root,root);
    }

    private static boolean helper(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) {
            return true;
        }
        if (node1 == null || node2 == null) {
            return false;
        }
        if (node1.value != node2.value) {
            return false;
        }

        return helper(node1.right,node2.left)&&helper(node1.left,node2.right);
    }
}
