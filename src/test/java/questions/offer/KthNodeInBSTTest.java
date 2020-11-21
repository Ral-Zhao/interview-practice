package questions.offer;

import data.tree.common.TreeNode;
import org.junit.Assert;
import org.junit.Test;

public class KthNodeInBSTTest {
    @Test
    public void test(){
        /*  构建如下二叉树
         *
         *          5
         *         / \
         *        3   7
         *       / \   \
         *      2   4   8
         *     /
         *    1
         */
        TreeNode root = new TreeNode(5);
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(7);
        TreeNode node3 = new TreeNode(2);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(1);
        TreeNode node6 = new TreeNode(8);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node3.left = node5;
        node2.right = node6;

        TreeNode result = KthNodeInBST.getKthNode(root,4);
        Assert.assertNotNull(result);
        Assert.assertEquals(4,result.value);
        result = KthNodeInBST.getKthNode(root,1);
        Assert.assertNotNull(result);
        Assert.assertEquals(1,result.value);
        result = KthNodeInBST.getKthNode(root,6);
        Assert.assertNotNull(result);
        Assert.assertEquals(7,result.value);
        result = KthNodeInBST.getKthNode(root,13);
        Assert.assertNull(result);

    }
}
