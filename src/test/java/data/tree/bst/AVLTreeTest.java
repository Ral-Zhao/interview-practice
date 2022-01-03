package data.tree.bst;

import data.tree.common.TreeNode;
import org.junit.Test;
import questions.common.ListNode;
import util.ListNodeUtil;
import util.TreeUtil;

public class AVLTreeTest {
    @Test
    public void test() {
        ListNode list = ListNodeUtil.buildList(1, 2,3,4);
        TreeNode root = AVLTree.build(list);
        TreeUtil.levelOrderPrint(root);
    }
}
