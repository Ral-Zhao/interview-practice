package questions.offer;

import data.tree.common.TreeNode;
import org.junit.Assert;
import org.junit.Test;

public class NextNodeInTreeTest {
    @Test
    public void testFindNextNode(){
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

        TreeNode node = NextNodeInTree.findNextNode(node2);
        Assert.assertEquals(5,node.value);
        node = NextNodeInTree.findNextNode(node5);
        Assert.assertEquals(1,node.value);
        node = NextNodeInTree.findNextNode(node6);
        Assert.assertNull(node);
        node = NextNodeInTree.findNextNode(node3);
        Assert.assertEquals(8,node.value);
    }
    @Test
    public void testFindPreviousNode(){
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

        TreeNode node = NextNodeInTree.findPreviousNode(node2);
        Assert.assertEquals(7,node.value);
        node = NextNodeInTree.findPreviousNode(node5);
        Assert.assertEquals(2,node.value);
        node = NextNodeInTree.findPreviousNode(node8);
        Assert.assertEquals(3,node.value);
        node = NextNodeInTree.findPreviousNode(node4);
        Assert.assertNull(node);
    }
}
