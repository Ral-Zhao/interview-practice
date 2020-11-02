package questions.offer;

import data.tree.common.TreeNode;
import org.junit.Test;
import utils.TreeUtil;

public class PrintTreeFromTopToBottomTest {
    @Test
    public void test(){
        TreeNode root = TreeUtil.buildTree2();
        PrintTreeFromTopToBottom.print(root);
    }
}
