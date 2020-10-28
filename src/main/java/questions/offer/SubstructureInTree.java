package questions.offer;


import data.tree.common.TreeNode;

/**
 *  题目26 树的子结构
 *
 *  输入两棵二叉树A和B，判断B是不是A的子结构。
 */
public class SubstructureInTree {
    public static boolean isSubstructure(TreeNode root, TreeNode sub) {
        if (root == null && sub == null) {
            return true;
        } else if (root == null || sub == null) {
            return false;
        }
        if (root.value != sub.value) {
            return isSubstructure(root.left, sub) || isSubstructure(root.right, sub);
        } else {
            return isSubstructure(root.left, sub.left) && isSubstructure(root.right, sub.right);
        }

    }
}
