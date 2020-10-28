package questions.offer;

import data.tree.common.TreeNode;

/**
 *  题目27 二叉树的镜像
 *
 *  输入一棵二叉树，输出它的镜像。
 */
public class MirrorOfBinaryTree {
    public static void mirror(TreeNode root){
        if (root == null){
            return;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.left = right;
        root.right = left;
        mirror(left);
        mirror(right);
    }
}
