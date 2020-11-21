package questions.offer;

import data.tree.common.TreeNode;

/**
 *  题目55-1 二叉树的深度
 *
 *  输入一棵二叉树的根节点，求该树的深度。
 *  从根节点到叶节点依次经过的节点形成树的一条路径，最长路径的长度为树的深度。
 */
public class TreeDepth {
    public static int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(depth(root.left), depth(root.right)) + 1;
    }
}
