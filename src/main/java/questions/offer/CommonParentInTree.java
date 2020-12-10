package questions.offer;

import data.tree.common.TreeNode;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 *  题目68 树中两节点的最低公共祖先
 *
 *  输入两个树节点，求它们的最低公共祖先节点。
 */
public class CommonParentInTree {
    public static TreeNode commonParent(TreeNode node1, TreeNode node2, TreeNode root) {
        if (node1 == null || node2 == null || root == null) {
            return null;
        }
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        Stack<TreeNode> helper = new Stack<>();
        Set<TreeNode> visited = new HashSet<>();
        boolean find1 = false;
        boolean find2 = false;

        while (root != null || !helper.isEmpty()) {
            while (root != null) {
                helper.push(root);
                if (!find1 && root == node1) {
                    stack1.addAll(helper);
                    find1 = true;
                }
                if (!find2 && root == node2) {
                    stack2.addAll(helper);
                    find2 = true;
                }
                root = root.left;
            }
            if (find1 && find2) {
                break;
            }
            root = helper.peek();
            if (visited.contains(root)) {
                while (root != null && visited.contains(root)) {
                    helper.pop();
                    root = helper.peek();
                }
            }
            visited.add(root);
            if (root != null) {
                root = root.right;
            }

        }
        if (stack1.size() < stack2.size()) {
            Stack<TreeNode> temp = stack1;
            stack1 = stack2;
            stack2 = temp;
        }
        int delta = stack1.size() - stack2.size();
        while (delta > 0) {
            stack1.pop();
            delta--;
        }

        while (!stack1.isEmpty() && !stack2.isEmpty()) {
            TreeNode top = stack1.pop();
            if (top == stack2.pop()) {
                return top;
            }
        }
        return null;
    }
}
