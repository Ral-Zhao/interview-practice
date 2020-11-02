package questions.offer;

/**
 *  题目33 二叉搜索树的后序遍历序列
 *
 *  输入一个整数数组，判断该数组是不是某二叉搜索树的后续遍历结果。
 *  假设输入的数组的任意两个数字都互不相同。
 *
 */
public class SequenceOfBST {
    public static boolean isSequence(int[] sequence) {
        if (sequence == null || sequence.length == 0) {
            return false;
        }
        return helper(sequence, 0, sequence.length - 1);
    }

    private static boolean helper(int[] sequence, int start, int end) {
        if (end <= start) {
            return true;
        }
        int root = sequence[end];
        int rootIndex = -1;
        for (int i = start; i < end; i++) {
            if (sequence[i] > root) {
                rootIndex = i;
                break;
            }
        }
        //没有右子树
        if (rootIndex == -1) {
            return helper(sequence, start, end - 1);
        }
        for (int i = rootIndex; i < end; i++) {
            if (sequence[i] < root) {
                return false;
            }
        }
        return helper(sequence, start, rootIndex - 1) && helper(sequence, rootIndex, end - 1);

    }
}
