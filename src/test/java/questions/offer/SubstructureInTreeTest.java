package questions.offer;

import data.tree.common.TreeNode;
import org.junit.Assert;
import org.junit.Test;
import utils.TreeUtil;

public class SubstructureInTreeTest {
    @Test
    public void test() {
        TreeNode root = TreeUtil.buildTree();
        TreeNode sub = new TreeNode(3);
        TreeNode node1 = new TreeNode(6);
        TreeNode node2 = new TreeNode(8);
        sub.right = node1;
        node1.left = node2;
        Assert.assertTrue(SubstructureInTree.isSubstructure(root, sub));

        sub = new TreeNode(2);
        node1 = new TreeNode(4);
        node2 = new TreeNode(5);
        TreeNode node3 = new TreeNode(7);
        sub.left = node1;
        sub.right = node2;
        node1.right = node3;
        Assert.assertTrue(SubstructureInTree.isSubstructure(root, sub));
    }
}
