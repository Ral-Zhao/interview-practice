package questions.leetbook.top_interview_questions.stack;

import org.junit.Assert;

import java.util.*;

/**
 * 中位数是有序列表中间的数。如果列表长度是偶数，中位数则是中间两个数的平均值。
 * <p>
 * 例如，
 * <p>
 * [2,3,4] 的中位数是 3
 * <p>
 * [2,3] 的中位数是 (2 + 3) / 2 = 2.5
 * <p>
 * 设计一个支持以下两种操作的数据结构：
 * <p>
 * void addNum(int num) - 从数据流中添加一个整数到数据结构中。
 * double findMedian() - 返回目前所有元素的中位数。
 * 示例：
 * <p>
 * addNum(1)
 * addNum(2)
 * findMedian() -> 1.5
 * addNum(3)
 * findMedian() -> 2
 * 进阶:
 * <p>
 * 如果数据流中所有整数都在 0 到 100 范围内，你将如何优化你的算法？
 * 如果数据流中 99% 的整数都在 0 到 100 范围内，你将如何优化你的算法？
 * <p>
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions/xalff2/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class MedianFinder {
    private Queue<Integer> minQueue;
    private Queue<Integer> maxQueue;

    /**
     * initialize your data structure here.
     */
    public MedianFinder() {
        minQueue = new PriorityQueue<>();
        maxQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
    }

    public void addNum(int num) {
        if (maxQueue.size() == 0) {
            maxQueue.add(num);
        } else {
            if (minQueue.size() == maxQueue.size()) {
                int add = num;
                if (num > minQueue.element()) {
                    add = minQueue.poll();
                    minQueue.add(num);
                }
                maxQueue.add(add);
            } else {
                int add = num;
                if (num <= maxQueue.element()) {
                    add = maxQueue.poll();
                    maxQueue.add(num);
                }
                minQueue.add(add);
            }
        }
    }

    public double findMedian() {
        if (maxQueue.size() > minQueue.size()) {
            return maxQueue.element();
        } else {
            return (minQueue.element() + maxQueue.element()) / 2.0;
        }
    }


    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(6);
        Assert.assertEquals(6.0, medianFinder.findMedian(), 0.1);
        medianFinder.addNum(10);
        Assert.assertEquals(8.0, medianFinder.findMedian(), 0.1);
        medianFinder.addNum(2);
        Assert.assertEquals(6.0, medianFinder.findMedian(), 0.1);
        medianFinder.addNum(6);
        Assert.assertEquals(6.0, medianFinder.findMedian(), 0.1);
        medianFinder.addNum(5);
        Assert.assertEquals(6.0, medianFinder.findMedian(), 0.1);
        medianFinder.addNum(0);
        Assert.assertEquals(5.5, medianFinder.findMedian(), 0.1);
        medianFinder.addNum(6);
        Assert.assertEquals(6.0, medianFinder.findMedian(), 0.1);
        medianFinder.addNum(3);
        Assert.assertEquals(5.5, medianFinder.findMedian(), 0.1);
        medianFinder.addNum(1);
        Assert.assertEquals(5.0, medianFinder.findMedian(), 0.1);
        medianFinder.addNum(0);
        Assert.assertEquals(4.0, medianFinder.findMedian(), 0.1);
        medianFinder.addNum(0);
        Assert.assertEquals(3.0, medianFinder.findMedian(), 0.1);

    }
}
