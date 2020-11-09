package questions.offer;


import java.io.InputStream;
import java.util.*;

/**
 *  题目41 数据流中的中位数
 *
 *  如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序后位于中间的数值。
 *  如果从数据流中读出偶数个数值，那么中位数就是所有数值排序后中间两个数的平均值。
 */
public class StreamMedian {
    public static void getMedian(InputStream inputStream) {
        Scanner scanner = new Scanner(inputStream);
        int count = 0;
        List<Integer> maxHeap = new ArrayList<>();
        List<Integer> minHeap = new ArrayList<>();
        while (scanner.hasNext()) {
            count++;
            int num = scanner.nextInt();

            if ((count & 1) == 1) {
                int temp = num;
                if (!minHeap.isEmpty() && num >= minHeap.get(0)) {
                    temp = minHeap.get(0);
                    minHeap.set(0, num);
                    fitHeap(minHeap, false);
                }
                maxHeap.add(temp);
                fitHeap(maxHeap, true);
                System.out.println("median: " + maxHeap.get(0));
            } else {
                int temp = num;
                if (!maxHeap.isEmpty() && num <= maxHeap.get(0)) {
                    temp = maxHeap.get(0);
                    maxHeap.set(0, num);
                    fitHeap(maxHeap, true);
                }
                minHeap.add( temp);
                fitHeap(minHeap, false);
                System.out.println("median: " + maxHeap.get(0) + " and " + minHeap.get(0));
            }
        }
    }

    private static void fitHeap(List<Integer> heap, boolean isGreater) {
        int len = heap.size();
        for (int i = (len - 2) / 2; i >= 0; i--) {
            int index = i;
            while (index * 2 + 1 < len) {
                int left = index * 2 + 1;
                int right = index * 2 + 2;
                int changeIndex;
                if (isGreater) {
                    changeIndex = right < len && heap.get(left) < heap.get(right) ? right : left;
                    if (heap.get(index) < heap.get(changeIndex)) {
                        int temp = heap.get(changeIndex);
                        heap.set(changeIndex, heap.get(index));
                        heap.set(index, temp);
                    }
                } else {
                    changeIndex = right < len && heap.get(left) > heap.get(right) ? right : left;
                    if (heap.get(index) > heap.get(changeIndex)) {
                        int temp = heap.get(changeIndex);
                        heap.set(changeIndex, heap.get(index));
                        heap.set(index, temp);
                    }
                }

                index = changeIndex;
            }
        }
    }

    public static void main(String[] args) {
        getMedian(System.in);
    }
}
