package data.tree.bst;

import data.tree.common.TreeNode;

public class BSTree {

    public static boolean isValidBSTree(TreeNode root) {
        return isValidBSTree(root, null, null);
    }

    private static boolean isValidBSTree(TreeNode root, TreeNode min, TreeNode max) {
        if (root == null) {
            return true;
        }
        if (min != null && root.value >= min.value) {
            return false;
        }
        if (max != null && root.value <= max.value) {
            return false;
        }
        return isValidBSTree(root.left, min, root) && isValidBSTree(root.right, root, max);
    }
}
