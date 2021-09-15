package questions.leetbook.top_interview_questions.tree;

import data.tree.common.TreeNode;
import org.junit.Assert;
import util.TreeUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 * <p>
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，最近公共祖先表示为一个节点 x，
 * 满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 * <p>
 * 示例 1：
 * <p>
 * 输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * 输出：3
 * 解释：节点 5 和节点 1 的最近公共祖先是节点 3 。
 * 示例 2：
 * <p>
 * <p>
 * 输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * 输出：5
 * 解释：节点 5 和节点 4 的最近公共祖先是节点 5 。因为根据定义最近公共祖先节点可以为节点本身。
 * 示例 3：
 * <p>
 * 输入：root = [1,2], p = 1, q = 2
 * 输出：1
 *  
 * <p>
 * 提示：
 * <p>
 * 树中节点数目在范围 [2, 10^5] 内。
 * -10^9 <= Node.val <= 10^9
 * 所有 Node.val 互不相同 。
 * p != q
 * p 和 q 均存在于给定的二叉树中。
 * <p>
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions/xas5th/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class CommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> pList = new ArrayList<>();
        List<TreeNode> qList = new ArrayList<>();
        findPath(pList, root, p);
        findPath(qList, root, q);
        TreeNode common = root;
        int minLen = Math.min(pList.size(), qList.size());
        for (int i = 0; i < minLen; i++) {
            if (pList.get(i) != qList.get(i)) {
                break;
            }
            common = pList.get(i);
        }
        return common;
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

    public static void main(String[] args) {
        CommonAncestor solution = new CommonAncestor();
        TreeNode root = TreeUtil.buildTree(3, 5, 1, 6, 2, 0, 8, null, null, 7, 4);
        TreeNode p = root.left;
        TreeNode q = root.right;
        Assert.assertEquals(3, solution.lowestCommonAncestor(root, p, q).value);
        p = root.left;
        q = root.left.right.right;
        Assert.assertEquals(5, solution.lowestCommonAncestor(root, p, q).value);
    }
}
