package questions.leetbook.top_interview_questions.sort;

import com.alibaba.fastjson.JSON;

import java.util.*;

/**
 * 给你`一个整数数组 nums ，按要求返回一个新数组 counts 。数组 counts 有该性质： counts[i] 的值是  nums[i] 右侧小于 nums[i] 的元素的数量。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [5,2,6,1]
 * 输出：[2,1,1,0]
 * 解释：
 * 5 的右侧有 2 个更小的元素 (2 和 1)
 * 2 的右侧仅有 1 个更小的元素 (1)
 * 6 的右侧有 1 个更小的元素 (1)
 * 1 的右侧有 0 个更小的元素
 * 示例 2：
 * <p>
 * 输入：nums = [-1]
 * 输出：[0]
 * 示例 3：
 * <p>
 * 输入：nums = [-1,-1]
 * 输出：[0,0]
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 10^5
 * -10^4 <= nums[i] <= 10^4
 * <p>
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions/xajl22/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class SmallerNumber {
    public List<Integer> countSmaller(int[] nums) {
        return method_1(nums);
    }

    private void insertNode(TreeNode root, TreeNode node) {
        if (node.val > root.val) {
            node.count++;
            node.count += root.leftCount;
            if (root.right == null) {
                root.right = node;
                return;
            }
            insertNode(root.right, node);
        } else {
            root.leftCount++;
            if (root.left == null) {
                root.left = node;
                return;
            }
            insertNode(root.left, node);
        }
    }

    class TreeNode {
        int count = 0;
        int leftCount = 0;
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * 搜索二叉树 timeout
     */
    private List<Integer> method_1(int[] nums) {
        List<Integer> result = new ArrayList<>();
        result.add(0);
        if (nums.length == 1) {
            return result;
        }
        TreeNode root = new TreeNode(nums[nums.length - 1]);
        for (int i = nums.length - 2; i >= 0; i--) {
            TreeNode node = new TreeNode(nums[i]);
            insertNode(root, node);
            result.add(0, node.count);
        }
        return result;
    }

    /**
     * 线段树
     */
    public List<Integer> method_2(int[] nums) {
        LinkedList<Integer> res = new LinkedList<>();
        int len = nums.length;
        if (len == 0) return res;
        //获取区间范围
        int start = nums[0], end = nums[0];
        for (int i = 0; i < len; i++) {
            if (nums[i] < start) start = nums[i];
            if (nums[i] > end) end = nums[i];
        }
        //构建树
        SegmentTreeNode root = build(start, end);
        //从右向左，边插入边计数
        for (int i = len - 1; i >= 0; i--) {
            //计数小于该元素的区间，所以要减一
            res.addFirst(count(root, start, nums[i] - 1));
            insert(root, nums[i], 1);
        }
        return res;
    }

    //线段树节点，包含左右最值和该区间叶子节点数，子区间不断递减
    private class SegmentTreeNode {
        int start, end, count;
        SegmentTreeNode left, right;

        public SegmentTreeNode(int start, int end) {
            this.start = start;
            this.end = end;
            this.count = 0;
            left = null;
            right = null;
        }
    }

    //构建线段树，不断递减区间长度
    private SegmentTreeNode build(int start, int end) {
        if (start > end) return null;
        SegmentTreeNode root = new SegmentTreeNode(start, end);
        if (start != end) {
            int mid = start + (end - start) / 2;
            root.left = build(start, mid);
            root.right = build(mid + 1, end);
        }
        return root;
    }

    //插入并更新叶子节点
    private void insert(SegmentTreeNode root, int index, int val) {

        if (root.start == index && root.end == index) {
            root.count += val;
            return;
        }

        int mid = root.start + (root.end - root.start) / 2;
        if (index >= root.start && index <= mid)
            insert(root.left, index, val);
        if (index > mid && index <= root.end)
            insert(root.right, index, val);
        //更新父节点的统计数，便于正好落在区间上的查找
        root.count = root.left.count + root.right.count;
    }

    //根据区间统计
    private int count(SegmentTreeNode root, int start, int end) {
        //nums[i] - 1, 排除相等的情况
        if (start > end) return 0;
        //递归到叶子节点，获取计数值
        if (start == root.start && end == root.end) {
            return root.count;
        }
        int mid = root.start + (root.end - root.start) / 2;
        int leftcount = 0;
        int rightcount = 0;
        //统计左半区
        if (start <= mid) {
            if (mid < end)
                leftcount = count(root.left, start, mid);
            else
                leftcount = count(root.left, start, end);
        }
        //统计右半区
        if (mid < end) {
            if (start <= mid)
                rightcount = count(root.right, mid + 1, end);
            else
                rightcount = count(root.right, start, end);
        }
        return (leftcount + rightcount);
    }

    /**
     * 树状数组
     */
    public List<Integer> method_3(int[] nums) {
        LinkedList<Integer> res = new LinkedList<>();
        int len = nums.length;
        if (len == 0) return res;
        //将nums中的元素排序，记录每个元素对应的索引
        TreeSet<Integer> set = new TreeSet();
        for (int i = 0; i < len; i++) {
            set.add(nums[i]);
        }
        Map<Integer, Integer> map = new HashMap<>();
        int index = 1;
        for (Integer n : set) {
            map.put(n, index);
            index++;
        }
        //利用索引更新并统计
        FenwickTree fenwickTree = new FenwickTree(len + 1);
        for (int i = len - 1; i >= 0; i--) {
            index = map.get(nums[i]);
            //在索引位置添加计数1
            fenwickTree.update(index, 1);
            //统计比索引对应元素小的个数
            res.addFirst(fenwickTree.query(index - 1));
        }
        return res;
    }

    //线段树，O(logn)实现单点更新和前缀和计算
    private class FenwickTree {

        private int[] tree;
        private int len;

        public FenwickTree(int n) {
            this.len = n;
            tree = new int[n + 1];
        }

        //更新本节点和父节点
        public void update(int i, int delta) {
            while (i <= this.len) {
                tree[i] += delta;
                i += lowbit(i);
            }
        }

        //求和，找到对应树的节点
        public int query(int i) {
            int sum = 0;
            while (i > 0) {
                sum += tree[i];
                i -= lowbit(i);
            }
            return sum;
        }

        //计算第一个非0的位置，2的幂
        public int lowbit(int x) {
            return x & (-x);
        }
    }


    private int[] index;
    private int[] aux;
    private int[] counter;

    /**
     * 归并排序
     */
    public List<Integer> method_4(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int len = nums.length;
        if (len == 0) return res;
        aux = new int[len];
        counter = new int[len];
        index = new int[len];
        for (int i = 0; i < len; i++) index[i] = i;
        //归并排序并统计
        mergeAndCount(nums, 0, len - 1);
        //遍历获取统计结果
        for (int i = 0; i < len; i++) {
            res.add(counter[i]);
        }
        return res;
    }

    //归并排序入口
    private void mergeAndCount(int[] nums, int l, int r) {
        if (l == r) return;
        int m = l + (r - l) / 2;
        mergeAndCount(nums, l, m);
        mergeAndCount(nums, m + 1, r);
        //检查已排序的部分
        if (nums[index[m]] > nums[index[m + 1]]) {
            sortAndCount(nums, l, m, r);
        }
    }

    //子数组排序并统计
    private void sortAndCount(int[] nums, int l, int m, int r) {
        for (int i = l; i <= r; i++) aux[i] = index[i];
        int i = l, j = m + 1;
        for (int k = l; k <= r; k++) {
            if (i > m) {
                index[k] = aux[j++];
            } else if (j > r) {
                index[k] = aux[i++];
                //排序的是索引数组，仍然可以通过索引找到原来数组中的元素，并更新统计值
                //右边先走完，那么右边的都是逆序
                counter[index[k]] += (r - m);
            } else if (nums[aux[i]] <= nums[aux[j]]) {
                index[k] = aux[i++];
                //插入左边的元素时，统计已经产生的逆序部分
                counter[index[k]] += (j - m - 1);
            } else {
                index[k] = aux[j++];
            }
        }
    }


    public static void main(String[] args) {
        SmallerNumber solution = new SmallerNumber();
        int[] nums = new int[]{5, 2, 6, 1};
        List<Integer> result = null;
        result = solution.countSmaller(nums);
        System.out.println(JSON.toJSONString(result));
        nums = new int[]{-1};
        result = solution.countSmaller(nums);
        System.out.println(JSON.toJSONString(result));
        nums = new int[]{-1, -1};
        result = solution.countSmaller(nums);
        System.out.println(JSON.toJSONString(result));
        nums = new int[]{2, 0, 1};
        result = solution.countSmaller(nums);
        System.out.println(JSON.toJSONString(result));
        nums = new int[]{0, 2, 1};
        result = solution.countSmaller(nums);
        System.out.println(JSON.toJSONString(result));
        nums = new int[]{26, 78, 27, 100, 33, 67, 90, 23, 66, 5, 38, 7, 35, 23, 52, 22, 83, 51, 98, 69, 81, 32, 78, 28, 94, 13, 2, 97, 3, 76, 99, 51, 9, 21, 84, 66, 65, 36, 100, 41};
        result = solution.countSmaller(nums);
        System.out.println(JSON.toJSONString(result));
    }
}
