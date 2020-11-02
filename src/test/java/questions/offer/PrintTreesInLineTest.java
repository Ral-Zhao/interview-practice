package questions.offer;

import data.tree.common.TreeNode;
import org.junit.Test;
import utils.TreeUtil;

public class PrintTreesInLineTest {
    @Test
    public void test(){
        TreeNode root = TreeUtil.buildTree();
        PrintTreesInLine.print(root);
        System.out.println();

        root = TreeUtil.buildTree2();
        PrintTreesInLine.print(root);
    }
}
