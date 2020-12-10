package data.tree.common;

import org.junit.Test;
import utils.TreeUtil;

import java.util.List;

public class PathTest {
    @Test
    public void test() {
        TreeNode root = TreeUtil.buildTree();
        List<TreeNode> path = Path.findPath(root, root.left.left.right);
        printPath(path);
        root = TreeUtil.buildTree();
        path = Path.findPath(root, root.right.right.left);
        printPath(path);
        root = TreeUtil.buildTree();
        path = Path.findPath(root, root.left.right);
        printPath(path);
        root = TreeUtil.buildTree2();
        path = Path.findPath(root, root.left.left.left);
        printPath(path);
        root = new TreeNode(6);
        path = Path.findPath(root, root);
        printPath(path);
        TreeNode left = new TreeNode(4);
        root.left = left;
        path = Path.findPath(root, left);
        printPath(path);
        TreeNode right = new TreeNode(7);
        root.right = right;
        path = Path.findPath(root, right);
        printPath(path);
    }

    @Test
    public void test2() {
        /*  构建如下二叉树
         *
         *          2
         *         / \
         *        1   3
         *       / \   \
         *     22  45   5
         *     /       /
         *    23      9
         *     \
         *     66
         */
        TreeNode root = new TreeNode(2);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(22);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(45);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(23);
        TreeNode node7 = new TreeNode(9);
        TreeNode node8 = new TreeNode(66);
        root.left = node1;
        root.right = node3;
        node1.left = node2;
        node1.right = node4;
        node3.right = node5;
        node5.left = node7;
        node2.left = node6;
        node6.right = node8;
        List<TreeNode> path = Path.findPath(root, node8);
        printPath(path);
        path = Path.findPath(root, node7);
        printPath(path);
    }

    private void printPath(List<TreeNode> path) {
        for (TreeNode node : path) {
            System.out.print(node.value + " ");
        }
        System.out.println();
    }
}
