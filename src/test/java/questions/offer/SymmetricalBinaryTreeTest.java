package questions.offer;

import data.tree.common.TreeNode;
import org.junit.Assert;
import org.junit.Test;
import utils.TreeUtil;

public class SymmetricalBinaryTreeTest {
    @Test
    public void test(){
        TreeNode root = TreeUtil.buildTree();
        Assert.assertTrue(!SymmetricalBinaryTree.isSymmetrical(root));

        root = new TreeNode(7);
        TreeNode node1 = new TreeNode(7);
        TreeNode node2 = new TreeNode(7);
        TreeNode node3 = new TreeNode(7);
        TreeNode node4 = new TreeNode(7);
        TreeNode node5 = new TreeNode(7);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right= node4;
        node2.left = node5;
        Assert.assertTrue(!SymmetricalBinaryTree.isSymmetrical(root));

        TreeNode node6 = new TreeNode(7);
        node2.right = node6;
        Assert.assertTrue(SymmetricalBinaryTree.isSymmetrical(root));
        node5.value = 3;
        Assert.assertTrue(!SymmetricalBinaryTree.isSymmetrical(root));
        node4.value = 3;
        Assert.assertTrue(SymmetricalBinaryTree.isSymmetrical(root));

    }
}
