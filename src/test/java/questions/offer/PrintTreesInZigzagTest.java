package questions.offer;

import data.tree.common.TreeNode;
import org.junit.Test;
import utils.TreeUtil;

public class PrintTreesInZigzagTest {
    @Test
    public void test(){
        TreeNode root = TreeUtil.buildTree();
        PrintTreesInZigzag.print(root);

        System.out.println();
        root = TreeUtil.buildTree2();
        PrintTreesInZigzag.print(root);
    }
}
