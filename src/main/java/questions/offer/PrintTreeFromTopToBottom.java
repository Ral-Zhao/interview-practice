package questions.offer;

import data.tree.common.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 *  题目32-1 从上到下打印二叉树
 *
 *  从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
 */
public class PrintTreeFromTopToBottom {
    public static void print(TreeNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            System.out.print(node.value);
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
    }
}
