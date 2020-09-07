package data.tree.bst;

import data.tree.common.Traverse;
import data.tree.common.TreeNode;
import org.junit.Test;

public class BSTreeTest {

    @Test
    public void testDelete(){
        TreeNode root = buildTree();
        BSTree.deleteNode(root,4);
        Traverse.preOrder(root);
        System.out.println("=============");
        Traverse.inOrder(root);
    }


    /** 构建如下二叉树
     *
     *          10
     *         /  \
     *        6    15
     *       / \  /  \
     *      4  9 14   17
     *       \       /  \
     *        5     16  20
     */
    private TreeNode buildTree() {
        TreeNode root = new TreeNode(10);
        TreeNode node2 = new TreeNode(6);
        TreeNode node3 = new TreeNode(15);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(9);
        TreeNode node6 = new TreeNode(14);
        TreeNode node7 = new TreeNode(17);
        TreeNode node8 = new TreeNode(5);
        TreeNode node9 = new TreeNode(16);
        TreeNode node10 = new TreeNode(20);
        root.left = node2;
        root.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        node4.right = node8;
        node7.left = node9;
        node7.right = node10;
        return root;
    }
}
