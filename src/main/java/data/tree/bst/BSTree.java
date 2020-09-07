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

    public static TreeNode deleteNode(TreeNode root, int value) {
        if (root == null) {
            return null;
        }
        if (root.value == value) {
            if (root.right == null && root.left == null) {
                return null;
            } else if (root.right == null) {
                return root.left;
            } else if (root.left == null) {
                return root.right;
            } else {
                TreeNode temp = root.right;
                while (temp.left!=null){
                    temp = temp.left;
                }
                root.value = temp.value;
                root.right = deleteNode(root.right,temp.value);
            }
        } else if (root.value < value) {
            root.right = deleteNode(root.right, value);
        } else {
            root.left = deleteNode(root.left, value);
        }
        return root;
    }
}
