package questions.offer;

import data.tree.common.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 *  题目32-2 分行从上到下打印二叉树
 *
 *  从上到下打印出二叉树，同一层的节点按照从左到右的顺序打印，
 *  每一层打印到一行。
 */
public class PrintTreesInLine {
    public static void print(TreeNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        int current = 1;
        int next = 0;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            System.out.print(node.value + " ");
            current--;
            if (node.left != null) {
                next++;
                queue.add(node.left);
            }
            if (node.right != null) {
                next++;
                queue.add(node.right);
            }
            if (current == 0) {
                System.out.println();
                current = next;
                next = 0;
            }
        }
    }
}
