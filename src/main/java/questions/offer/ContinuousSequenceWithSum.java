package questions.offer;

/**
 *  题目57-2 和为s的连续正数序列
 *
 *  输入一个正数s，打印出所有和为s的连续正数序列（至少含有两个数）。
 *  例如，输入15，由于1+2+3+4+5=4+5+6=7+8=15，所以打印出3个连续序列1~5、4~6和7~8.
 */
public class ContinuousSequenceWithSum {
    public static void printSequence(int target) {
        if (target < 3) {
            return;
        }
        int small = 1;
        int big = 2;
        int sum = small + big;
        int middle = (target + 1) / 2;
        while (small < middle) {
            if (sum == target) {
                print(small, big);
            }
            if (sum <= target) {
                big++;
                sum += big;
            } else {
                sum -= small;
                small++;
            }
        }
    }

    private static void print(int start, int end) {
        int count = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = start; i <= end; i++) {
            sb.append(i).append("+");
            count += i;
        }
        sb.deleteCharAt(sb.length() - 1).append("=").append(count);
        System.out.println(sb.toString());
    }
}
