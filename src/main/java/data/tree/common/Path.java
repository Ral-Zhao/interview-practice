package data.tree.common;

import java.util.*;

/**
 * 二叉树中查找到某节点的路径
 */
public class Path {
    public static List<TreeNode> findPath(TreeNode root, TreeNode target) {
        if (root == null || target == null) {
            return null;
        }
        List<TreeNode> path = new ArrayList<>();
        Stack<TreeNode> helper = new Stack<>();
        Set<TreeNode> visited = new HashSet<>();
        boolean find = false;
        while (root != null || !helper.isEmpty()) {
            while (root != null) {
                helper.push(root);
                if (root == target) {
                    path.addAll(helper);
                    find = true;
                    break;
                }
                root = root.left;
            }
            if (find) {
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
        return path;
    }

    private boolean findPath(List<TreeNode> list, TreeNode root, TreeNode target) {
        list.add(root);
        if (target == root) {
            return true;
        }
        if (root.left != null && findPath(list, root.left, target)) {
            return true;
        }
        if (root.right != null && findPath(list, root.right, target)) {
            return true;
        }
        list.remove(list.size() - 1);
        return false;
    }
}
