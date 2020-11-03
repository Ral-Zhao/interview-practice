package questions.offer;

import data.tree.common.TreeNode;
import org.junit.Test;
import utils.TreeUtil;

public class PathInTreeTest {
    @Test
    public void test() {
        TreeNode root = TreeUtil.buildTree();
        PathInTree.findPath(root, 14);

        TreeNode node1 = new TreeNode(10);
        TreeNode node2 = new TreeNode(5);
        TreeNode node3 = new TreeNode(12);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(7);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        PathInTree.findPath(node1, 22);
        System.out.println();
        PathInTree.findPath(node1, 19);
    }
}
