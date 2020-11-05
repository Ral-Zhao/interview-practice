package questions.offer;

import data.tree.common.TreeNode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

/**
 *  题目37 序列化二叉树
 *
 *  实现两个函数，分别用来序列化和反序列化二叉树。
 *
 */
public class SerializeBinaryTrees {
    public static String serialize(TreeNode root) {
        if (root == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        serializeHelper(sb, root);
        sb = sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    private static void serializeHelper(StringBuilder sb, TreeNode node) {
        if (node == null) {
            sb.append("$,");
            return;
        }
        sb.append(node.value).append(",");
        serializeHelper(sb, node.left);
        serializeHelper(sb, node.right);

    }

    public static TreeNode deserialize(String string) {
        if (string == null || "".equals(string)) {
            return null;
        }
        String[] arr = string.split(",");
        Queue<String> queue = new ArrayDeque<String>(Arrays.asList(arr));
        return deserializeHelper(queue);
    }

    private static TreeNode deserializeHelper( Queue<String> queue) {
        String data = queue.poll();
        TreeNode newNode = null;
        if (data != null && !"$".equals(data)) {
            newNode = new TreeNode(Integer.parseInt(data));
            newNode.left = deserializeHelper(queue);
            newNode.right = deserializeHelper(queue);
        }
        return newNode;
    }
}
