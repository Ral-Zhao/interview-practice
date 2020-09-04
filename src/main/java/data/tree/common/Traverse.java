package data.tree.common;


import java.util.*;

public class Traverse {
    //递归实现先序遍历
    public static void preOrderRecur(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.println(root.value);
        preOrderRecur(root.left);
        preOrderRecur(root.right);
    }

    //递归实现中序遍历
    public static void inOrderRecur(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrderRecur(root.left);
        System.out.println(root.value);
        inOrderRecur(root.right);
    }

    //递归实现后序遍历
    public static void postOrderRecur(TreeNode root) {
        if (root == null) {
            return;
        }
        postOrderRecur(root.left);
        postOrderRecur(root.right);
        System.out.println(root.value);
    }

    //非递归实现先序遍历
    public static void preOrder(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while (root != null || !stack.isEmpty()) {
            //对于一个节点，沿着左孩子一直向左走到底，每访问一个节点将其加入stack
            while (root != null) {
                stack.push(root);
                System.out.println(root.value);
                root = root.left;
            }
            //向左走到底后弹出栈顶节点，接着访问右孩子，重复上述操作
            root = stack.pop().right;
        }
    }

    //非递归实现中序遍历
    //思路和前序遍历类似，只不过是从栈里弹出元素访问
    public static void inOrder(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            System.out.println(root.value);
            root = root.right;
        }
    }

    //非递归实现后序遍历
    public static void postOrder(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        //set中的节点表示其右子树已经被访问
        Set<TreeNode> visited = new HashSet<>();
        //先从根节点向左走到底
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
        while (!stack.isEmpty()) {
            TreeNode node = stack.peek();
            //得到此时的栈顶节点，若没有右孩子则表示该节点是个叶子节点，执行访问；
            //若其右孩子已经被访问，则对该节点执行访问；
            //访问后将该节点出栈，
            if (node.right == null || visited.contains(node)) {
                System.out.println(node.value);
                stack.pop();
                continue;
            } else {
                //将该节点加入set，接下来访问其右孩子
                visited.add(node);
            }
            //对右孩子依然沿着左边走到底
            node = node.right;
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
        }
    }

    public static void levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<TreeNode>();
        if (root != null) {
            queue.add(root);
        }
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            System.out.println(node.value);
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
    }
}
