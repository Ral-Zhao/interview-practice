package questions.offer;

import org.junit.Assert;
import org.junit.Test;

public class SequenceOfBSTTest {
    @Test
    public void test(){
        int[] arr = new int[]{5,7,6,9,11,10,8};
        Assert.assertTrue(SequenceOfBST.isSequence(arr));

        arr = new int[]{7,6,5,4};
        Assert.assertTrue(SequenceOfBST.isSequence(arr));

        arr = new int[]{7,4,6,5};
        Assert.assertTrue(!SequenceOfBST.isSequence(arr));

        /*
         *
         *          8
         *         / \
         *        6   9
         *       / \   \
         *      3   7   11
         *     / \     /
         *    2   4   10
         */
        arr = new int[]{2,4,3,7,6,10,11,9,8};
        Assert.assertTrue(SequenceOfBST.isSequence(arr));
        /*
         *
         *          8
         *         /
         *        6
         *       /
         *      3
         *     /
         *    2
         */
        arr = new int[]{2,3,6,8};
        Assert.assertTrue(SequenceOfBST.isSequence(arr));
        /*
         *
         *          8
         *         / \
         *        6   9
         */
        arr = new int[]{6,9,8};
        Assert.assertTrue(SequenceOfBST.isSequence(arr));

        arr = new int[]{8,6,7};
        Assert.assertTrue(!SequenceOfBST.isSequence(arr));
    }
}
