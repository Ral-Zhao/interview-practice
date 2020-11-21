package questions.offer;

import data.tree.common.TreeNode;

/**
 *  题目54 二叉搜索树的第K大节点
 *
 *  给定一棵二叉搜索树，请找出其中第K大的节点。
 *
 */
public class KthNodeInBST {
    private static int num = 0;

    public static TreeNode getKthNode(TreeNode root, int k) {
        if (root == null || k == 0) {
            return null;
        }
        num = k;
        return helper(root, k);
    }

    private static TreeNode helper(TreeNode node, Integer k) {
        TreeNode result = null;
        if (node.left != null) {
            result = helper(node.left, num);
        }
        if (result == null) {
            num--;
            if (num == 0) {
                result = node;
            }
        }
        if (result == null && node.right != null) {
            result = helper(node.right, num);
        }
        return result;
    }
}
