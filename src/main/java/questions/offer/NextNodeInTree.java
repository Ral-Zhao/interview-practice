package questions.offer;

import data.tree.common.TreeNode;

/**
 *  题目8 二叉树的下一个节点
 *
 *  给定一颗二叉树和其中一个节点，如何找出中序遍历序列的下一个节点。
 *  树中的节点除了左右节点指针外，还有指向其父节点的指针。
 */
public class NextNodeInTree {

    public static TreeNode findNextNode(TreeNode target){
        //如果其右孩子不为null，则后续节点为其右子树的最左节点。
        if (target.right!=null){
            target = target.right;
            while (target.left!=null){
                target =target.left;
            }
            return target;
        }
        TreeNode parent = target.parent;
        if (parent == null){
            return null;
        }
        //如果当前节点是其父节点的左孩子，则父节点即是后续节点。
        if (target==parent.left){
            return parent;
        }
        //如果如果当前节点是其父节点的右孩子
        //则循环向上查找，直到找到是其父节点左孩子的节点，它的父节点即为后续节点
        while (parent.parent!=null){
            if (parent == parent.parent.left){
                return parent.parent;
            }
            parent = parent.parent;
        }
        return null;
    }

    public static TreeNode findPreviousNode(TreeNode target){
        //如果其左孩子不为null，则后续节点为其左子树的最右节点。
        if (target.left!=null){
            target = target.left;
            while (target.right!=null){
                target =target.right;
            }
            return target;
        }
        TreeNode parent = target.parent;
        if (parent == null){
            return null;
        }
        //如果当前节点是其父节点的右孩子，则父节点即是后续节点。
        if (target==parent.right){
            return parent;
        }
        //如果如果当前节点是其父节点的左孩子
        //则循环向上查找，直到找到是其父节点右孩子的节点，它的父节点即为后续节点
        while (parent.parent!=null){
            if (parent == parent.parent.right){
                return parent.parent;
            }
            parent = parent.parent;
        }
        return null;
    }
}
