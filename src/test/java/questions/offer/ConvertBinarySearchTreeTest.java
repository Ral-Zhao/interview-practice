package questions.offer;

import data.tree.common.TreeNode;
import org.junit.Test;

public class ConvertBinarySearchTreeTest {
    @Test
    public void test(){
        /*
         *          7
         *         / \
         *        5   8
         *       / \   \
         *      2   6   10
         *       \     /
         *        3   9
         */
        TreeNode root = new TreeNode(7);
        TreeNode node2 = new TreeNode(5);
        TreeNode node3 = new TreeNode(8);
        TreeNode node4 = new TreeNode(2);
        TreeNode node5 = new TreeNode(6);
        TreeNode node6 = new TreeNode(10);
        TreeNode node7 = new TreeNode(3);
        TreeNode node8 = new TreeNode(9);
        root.left = node2;
        root.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.right = node6;
        node4.right = node7;
        node6.left = node8;
        TreeNode head = ConvertBinarySearchTree.convert(root);
        while (head!=null){
            System.out.println(head.value);
            head = head.right;
        }
    }
    @Test
    public void test2(){
        /*
         *          7
         *         / \
         *        5   8
         *       /     \
         *      2      10
         *     /         \
         *    1          11
         */
        TreeNode root = new TreeNode(7);
        TreeNode node2 = new TreeNode(5);
        TreeNode node3 = new TreeNode(8);
        TreeNode node4 = new TreeNode(2);
        TreeNode node5 = new TreeNode(10);
        TreeNode node6 = new TreeNode(1);
        TreeNode node7 = new TreeNode(11);
        root.left = node2;
        root.right = node3;
        node2.left = node4;
        node4.left = node6;
        node3.right = node5;
        node5.right = node7;
        TreeNode head = ConvertBinarySearchTree.convert(root);
        while (head!=null){
            System.out.println(head.value);
            head = head.right;
        }
    }
}
