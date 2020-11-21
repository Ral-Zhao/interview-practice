package questions.offer;

import data.tree.common.TreeNode;
import org.junit.Assert;
import org.junit.Test;
import utils.TreeUtil;

public class TreeDepthTest {
    @Test
    public void test(){
        TreeNode root = TreeUtil.buildTree();
        Assert.assertEquals(4,TreeDepth.depth(root));
        root = TreeUtil.buildTree2();
        Assert.assertEquals(4,TreeDepth.depth(root));
        root = new TreeNode(3);
        Assert.assertEquals(1,TreeDepth.depth(root));
        root.left = new TreeNode(6);
        root.left.left = new TreeNode(5);
        Assert.assertEquals(3,TreeDepth.depth(root));
    }
}
