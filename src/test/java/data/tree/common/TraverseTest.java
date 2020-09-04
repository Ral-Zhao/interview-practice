package data.tree.common;

import org.junit.Test;

public class TraverseTest {

    @Test
    public void testPreOrderRecur() {
        TreeNode root = buildTree();
        Traverse.preOrderRecur(root);
    }

    @Test
    public void testInOrderRecur() {
        TreeNode root = buildTree();
        Traverse.inOrderRecur(root);
    }

    @Test
    public void testPostOrderRecur() {
        TreeNode root = buildTree();
        Traverse.postOrderRecur(root);
    }

    @Test
    public void testPreOrder() {
        TreeNode root = buildTree();
        Traverse.preOrder(root);
    }

    @Test
    public void testInOrder() {
        TreeNode root = buildTree();
        Traverse.inOrder(root);
    }

    @Test
    public void testPostOrder() {
        TreeNode root = buildTree();
        Traverse.postOrder(root);
    }

    @Test
    public void testLevelOrder() {
        TreeNode root = buildTree();
        Traverse.levelOrder(root);
    }

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
    private TreeNode buildTree() {
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
    private TreeNode buildTree2() {
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
        node4.right = node7;
        return root;
    }
}
