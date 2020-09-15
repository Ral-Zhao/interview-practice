package questions.offer;

import data.tree.common.TreeNode;

/**
 * 题目7 根据遍历结果重建二叉树
 */
public class RebuildTree {

    /**
     * 根据前序和中序遍历重建二叉树
     */
    public static TreeNode buildByPreAndOrder(int[] pre, int[] order) {
        return helperByPreAndOrder(pre, order, 0, pre.length - 1, 0, order.length - 1);
    }

    private static TreeNode helperByPreAndOrder(int[] pre, int[] order, int preStart, int preEnd, int orderStart, int orderEnd) {
        if (preStart > preEnd || orderStart > orderEnd) {
            return null;
        }
        int value = pre[preStart];
        TreeNode node = new TreeNode(value);
        int length = -1;
        int mid = -1;
        //找到中序数组中的位置，即为根节点；记录下其前面元素的个数，用于区分前序结果中的左右子树
        for (int i = orderStart; i <= orderEnd; i++) {
            if (value == order[i]) {
                length = i - orderStart;
                mid = i;
                break;
            }
        }
        if (mid == -1 || length == -1) {
            return null;
        }
        node.left = helperByPreAndOrder(pre, order, preStart + 1, preEnd + length , orderStart, mid - 1);
        node.right = helperByPreAndOrder(pre, order, preStart + length+1, preEnd, mid + 1, orderEnd);
        return node;
    }

}
