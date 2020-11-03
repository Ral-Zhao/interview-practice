package questions.offer;

import data.tree.common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 题目34 二叉树中和为某一值的路径
 * <p>
 * 输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。
 * 从树的根节点开始一直往下到叶节点所经过的节点形成一条路径。
 */
public class PathInTree {
    public static void findPath(TreeNode root, int sum) {
        if (root == null) {
            return;
        }
        List<List<TreeNode>> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        backTrace(result, stack, sum, root.value);
        for (List<TreeNode> list : result) {
            for (TreeNode node : list) {
                System.out.print(node.value + " ");
            }
            System.out.println();
        }
    }

    private static void backTrace(List<List<TreeNode>> result, Stack<TreeNode> stack, int sum, int count) {
        TreeNode top = stack.peek();
        if (top.left == null && top.right == null && sum == count) {
            List<TreeNode> list = new ArrayList<>();
            list.addAll(stack);
            result.add(list);
            return;
        }
        if (top.left != null) {
            stack.push(top.left);
            backTrace(result, stack, sum, count + top.left.value);
            stack.pop();
        }
        if (top.right != null) {
            stack.push(top.right);
            backTrace(result, stack, sum, count + top.right.value);
            stack.pop();
        }

    }
}
