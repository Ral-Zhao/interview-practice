package questions.offer;

import data.tree.common.Traverse;
import data.tree.common.TreeNode;
import org.junit.Test;

public class RebuildTreeTest {

    @Test
    public void testBuildByPreAndOrder(){
        int[] pre = new int[]{1,2,4,7,3,5,6,8};
        int[] order = new int[]{4,7,2,1,5,3,8,6};
        TreeNode node = RebuildTree.buildByPreAndOrder(pre,order);
        Traverse.postOrder(node);
    }
}
