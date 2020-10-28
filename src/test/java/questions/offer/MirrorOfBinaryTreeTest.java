package questions.offer;

import data.tree.common.TreeNode;
import org.junit.Assert;
import org.junit.Test;
import utils.TreeUtil;

public class MirrorOfBinaryTreeTest {
    @Test
    public void test(){
        TreeNode root = TreeUtil.buildTree();
        MirrorOfBinaryTree.mirror(root);
        Assert.assertEquals(6,root.left.left.value);
        Assert.assertEquals(8,root.left.left.right.value);
        Assert.assertEquals(5,root.right.left.value);
        Assert.assertEquals(4,root.right.right.value);
        Assert.assertEquals(7,root.right.right.left.value);
    }
}
