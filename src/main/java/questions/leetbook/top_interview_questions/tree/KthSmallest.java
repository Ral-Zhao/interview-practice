package questions.leetbook.top_interview_questions.tree;

import data.tree.common.TreeNode;
import org.junit.Assert;
import util.TreeUtil;

import java.util.Stack;

/**
 * 给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 个最小元素（从 1 开始计数）。
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [3,1,4,null,2], k = 1
 * 输出：1
 * 示例 2：
 * <p>
 * <p>
 * 输入：root = [5,3,6,2,4,null,null,1], k = 3
 * 输出：3
 *  
 * <p>
 * 提示：
 * <p>
 * 树中的节点数为 n 。
 * 1 <= k <= n <= 10^4
 * 0 <= Node.val <= 10^4
 *  
 * <p>
 * 进阶：如果二叉搜索树经常被修改（插入/删除操作）并且你需要频繁地查找第 k 小的值，你将如何优化算法？
 * <p>
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions/xazo8d/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class KthSmallest {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        int result = -1;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            TreeNode node = stack.pop();
            result = node.value;
            k--;
            if (k == 0) {
                break;
            }
            root = node.right;
        }
        return result;
    }

    public static void main(String[] args) {
        KthSmallest solution = new KthSmallest();
        TreeNode root = TreeUtil.buildTree(3, 1, 4, null, 2);
        Assert.assertEquals(1, solution.kthSmallest(root, 1));
        Assert.assertEquals(3, solution.kthSmallest(root, 3));
        root = TreeUtil.buildTree(5, 3, 6, 2, 4, null, null, 1);
        Assert.assertEquals(3, solution.kthSmallest(root, 3));
    }
}
