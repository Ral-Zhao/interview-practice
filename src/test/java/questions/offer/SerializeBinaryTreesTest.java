package questions.offer;

import data.tree.common.Traverse;
import data.tree.common.TreeNode;
import org.junit.Test;
import utils.TreeUtil;

public class SerializeBinaryTreesTest {
    @Test
    public void testSerialize(){
        TreeNode root = TreeUtil.buildTree();
        String tree = SerializeBinaryTrees.serialize(root);
        System.out.println(tree);
    }
    @Test
    public void testDeSerialize(){
        String string = "1,2,4,$,7,$,$,5,$,$,3,$,6,8,$,$,$";
        TreeNode root = SerializeBinaryTrees.deserialize(string);
        Traverse.preOrder(root);
        System.out.println();
        Traverse.inOrder(root);
    }
}
