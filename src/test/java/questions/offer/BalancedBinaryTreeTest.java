package questions.offer;

import data.tree.common.TreeNode;
import org.junit.Assert;
import org.junit.Test;
import utils.TreeUtil;

public class BalancedBinaryTreeTest {
    @Test
    public void test() {
        TreeNode root = TreeUtil.buildTree();
        Assert.assertTrue(!BalancedBinaryTree.isBalanced(root));
        root = TreeUtil.buildTree2();
        Assert.assertTrue(!BalancedBinaryTree.isBalanced(root));
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(1);
        TreeNode node3 = new TreeNode(1);
        TreeNode node4 = new TreeNode(1);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        Assert.assertTrue(BalancedBinaryTree.isBalanced(node1));
    }
}
