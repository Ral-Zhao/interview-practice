package data.tree.common;

import org.junit.Test;
import utils.TreeUtil;

public class TraverseTest {

    @Test
    public void testPreOrderRecur() {
        TreeNode root = TreeUtil.buildTree();
        Traverse.preOrderRecur(root);
    }

    @Test
    public void testInOrderRecur() {
        TreeNode root = TreeUtil.buildTree();
        Traverse.inOrderRecur(root);
        System.out.println("==============");
        root = TreeUtil.buildTree2();
        Traverse.inOrderRecur(root);
    }

    @Test
    public void testPostOrderRecur() {
        TreeNode root = TreeUtil.buildTree();
        Traverse.postOrderRecur(root);
        System.out.println("==============");
        root = TreeUtil.buildTree2();
        Traverse.postOrderRecur(root);
    }

    @Test
    public void testPreOrder() {
        TreeNode root = TreeUtil.buildTree();
        Traverse.preOrder(root);
        System.out.println("==============");
        root = TreeUtil.buildTree2();
        Traverse.preOrder(root);
    }

    @Test
    public void testInOrder() {
        TreeNode root = TreeUtil.buildTree();
        Traverse.inOrder(root);
        System.out.println("==============");
        root = TreeUtil.buildTree2();
        Traverse.inOrder(root);
    }

    @Test
    public void testPostOrder() {
        TreeNode root = TreeUtil.buildTree();
        Traverse.postOrder(root);
        System.out.println("==============");
        Traverse.postOrder_simple(root);
        System.out.println("=====simple method========");
        root = TreeUtil.buildTree2();
        Traverse.postOrder(root);
        System.out.println("=====simple method========");
        Traverse.postOrder_simple(root);

    }

    @Test
    public void testLevelOrder() {
        TreeNode root = TreeUtil.buildTree();
        Traverse.levelOrder(root);
        System.out.println("==============");
        root = TreeUtil.buildTree2();
        Traverse.levelOrder(root);
    }

   
}
