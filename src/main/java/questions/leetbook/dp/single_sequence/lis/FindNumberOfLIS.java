package questions.leetbook.dp.single_sequence.lis;

import org.junit.Assert;

import java.util.Arrays;

/**
 * 给定一个未排序的整数数组，找到最长递增子序列的个数。
 *
 * 示例 1:
 *
 * 输入: [1,3,5,4,7]
 * 输出: 2
 * 解释: 有两个最长递增子序列，分别是 [1, 3, 4, 7] 和[1, 3, 5, 7]。
 * 示例 2:
 *
 * 输入: [2,2,2,2,2]
 * 输出: 5
 * 解释: 最长递增子序列的长度是1，并且存在5个子序列的长度为1，因此输出5。
 * 注意: 给定的数组长度不超过 2000 并且结果一定是32位有符号整数。
 *
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/dynamic-programming-1-plus/5o6mrv/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class FindNumberOfLIS {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;int ans = 0;
        int[] dp = new int[n];
        int[] count = new int[n];
        Arrays.fill(dp, 1);
        Arrays.fill(count, 1);
        int maxNum = 1;
        for(int i=1; i<n; i++){
            for(int j=0; j<i; j++){
                if(nums[j] < nums[i]){
                    if(dp[j]+1 > dp[i]){ // i节点有1个最长序列
                        //dp[i] = dp[j]+1;
                        count[i] = count[j];
                    }else if(dp[j]+1 == dp[i]){// i节点有多个最长序列
                        count[i] = count[i] + count[j];
                    }
                    dp[i] = Math.max(dp[j]+1, dp[i]);
                }
            }
            maxNum = Math.max(dp[i], maxNum);
        }

        for(int i=0; i<n; i++){
            if(dp[i] == maxNum){
                ans += count[i];
            }
        }
        return ans;
    }

    public Value merge(Value v1, Value v2) {
        if (v1.length == v2.length) {
            if (v1.length == 0) return new Value(0, 1);
            return new Value(v1.length, v1.count + v2.count);
        }
        return v1.length > v2.length ? v1 : v2;
    }

    public void insert(Node node, int key, Value val) {
        if (node.range_left == node.range_right) {
            node.val = merge(val, node.val);
            return;
        } else if (key <= node.getRangeMid()) {
            insert(node.getLeft(), key, val);
        } else {
            insert(node.getRight(), key, val);
        }
        node.val = merge(node.getLeft().val, node.getRight().val);
    }

    public Value query(Node node, int key) {
        if (node.range_right <= key) return node.val;
        else if (node.range_left > key) return new Value(0, 1);
        else return merge(query(node.getLeft(), key), query(node.getRight(), key));
    }

    public int method_2(int[] nums) {
        if (nums.length == 0) return 0;
        int min = nums[0], max = nums[0];
        for (int num: nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        Node root = new Node(min, max);
        for (int num: nums) {
            Value v = query(root, num-1);
            insert(root, num, new Value(v.length + 1, v.count));
        }
        return root.val.count;
    }
}

class Node {
    int range_left, range_right;
    Node left, right;
    Value val;
    public Node(int start, int end) {
        range_left = start;
        range_right = end;
        left = null;
        right = null;
        val = new Value(0, 1);
    }
    public int getRangeMid() {
        return range_left + (range_right - range_left) / 2;
    }
    public Node getLeft() {
        if (left == null) left = new Node(range_left, getRangeMid());
        return left;
    }
    public Node getRight() {
        if (right == null) right = new Node(getRangeMid() + 1, range_right);
        return right;
    }
}

class Value {
    int length;
    int count;
    public Value(int len, int ct) {
        length = len;
        count = ct;
    }

    public static void main(String[] args) {
        FindNumberOfLIS solution = new FindNumberOfLIS();
        int[] nums = new int[]{1,3,5,4,7};
        Assert.assertEquals(2,solution.findNumberOfLIS(nums));
        nums = new int[]{2,2,2,2,2};
        Assert.assertEquals(5,solution.findNumberOfLIS(nums));

    }
}
