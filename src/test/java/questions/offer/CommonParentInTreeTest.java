package questions.offer;

import data.tree.common.TreeNode;
import org.junit.Assert;
import org.junit.Test;

public class CommonParentInTreeTest {
    @Test
    public void test() {
        /*  构建如下二叉树
         *
         *          5
         *         / \
         *        4   6
         *       / \
         *      45  3
         *       \
         *        7
         */
        TreeNode root = new TreeNode(5);
        TreeNode node1 = new TreeNode(4);
        TreeNode node2 = new TreeNode(6);
        TreeNode node3 = new TreeNode(45);
        TreeNode node4 = new TreeNode(3);
        TreeNode node5 = new TreeNode(7);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node3.right = node5;
        Assert.assertSame(node1, CommonParentInTree.commonParent(node5, node4, root));
        Assert.assertEquals(node1.value, CommonParentInTree.commonParent(node5, node4, root).value);
        Assert.assertSame(root, CommonParentInTree.commonParent(node1, node2, root));
        Assert.assertEquals(root.value, CommonParentInTree.commonParent(node1, node2, root).value);
    }

    @Test
    public void test2() {
        /*  构建如下二叉树
         *
         *          2
         *         / \
         *        1   3
         *       / \   \
         *     22  45   5
         *     /       /
         *    23      9
         *     \
         *     66
         */
        TreeNode root = new TreeNode(2);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(22);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(45);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(23);
        TreeNode node7 = new TreeNode(9);
        TreeNode node8 = new TreeNode(66);
        root.left = node1;
        root.right = node3;
        node1.left = node2;
        node1.right = node4;
        node3.right = node5;
        node5.left = node7;
        node2.left = node6;
        node6.right = node8;
        Assert.assertSame(node1, CommonParentInTree.commonParent(node8, node4, root));
        Assert.assertEquals(node1.value, CommonParentInTree.commonParent(node8, node4, root).value);
        Assert.assertSame(root, CommonParentInTree.commonParent(node6, node5, root));
        Assert.assertEquals(root.value, CommonParentInTree.commonParent(node6, node5, root).value);
        Assert.assertSame(node6, CommonParentInTree.commonParent(node6, node8, root));
        Assert.assertEquals(node6.value, CommonParentInTree.commonParent(node6, node8, root).value);
    }
}
