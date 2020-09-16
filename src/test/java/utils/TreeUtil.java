package utils;

import data.tree.common.TreeNode;

public class TreeUtil {

    /** 构建如下二叉树
     *
     *          1
     *         / \
     *        2   3
     *       / \   \
     *      4  5    6
     *       \     /
     *        7   8
     */
    public static TreeNode buildTree() {
        TreeNode root = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(8);
        root.left = node2;
        root.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.right = node6;
        node4.right = node7;
        node6.left = node8;
        node2.parent = root;
        node3.parent = root;
        node4.parent = node2;
        node5.parent = node2;
        node7.parent = node4;
        node6.parent = node3;
        node8.parent = node6;
        return root;
    }
    /** 构建如下二叉树
     *
     *          1
     *         / \
     *        2   3
     *       /     \
     *      4       5
     *     /         \
     *    6           7
     */
    public static TreeNode buildTree2() {
        TreeNode root = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        root.left = node2;
        root.right = node3;
        node2.left = node4;
        node3.right = node5;
        node4.left = node6;
        node5.right = node7;
        return root;
    }
}
