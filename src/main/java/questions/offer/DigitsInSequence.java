package questions.offer;

/**
 *  题目44 数字序列中某一位的数字
 *
 *  数字以0123456789101112131415…的格式序列化到一个字符序列中。
 *  在这个序列中，第5位（从0开始计数）是5，第13位是1，第19位是4，等待。
 *  请写一个函数，求任意第n位对应的数字。
 */
public class DigitsInSequence {
    public static int getDigit(int n) {
        if (n < 1) {
            return -1;
        }
        if (n < 10) {
            return n - 1;
        }
        int bitNum = 2;
        int temp = 0;
        int sum = 10;
        while (sum < n) {
            temp = (powerOfTen(bitNum) - powerOfTen(bitNum - 1)) * bitNum;
            sum = sum + temp;
            bitNum++;
        }
        bitNum--;
        int extra = n - (sum - temp);
        int sub = extra / bitNum;
        int mod = extra % bitNum;
        if (mod == 0) {
            return (powerOfTen(bitNum - 1) + sub - 1) % 10;
        }
        int num = powerOfTen(bitNum - 1) + sub;
        return String.valueOf(num).charAt(mod - 1) - '0';
    }

    private static int powerOfTen(int n) {
        int result = 1;
        for (int i = 0; i < n; i++) {
            result = result * 10;
        }
        return result;
    }

    public static int stupidMethod(int n) {
        if (n < 1) {
            return -1;
        }
        int count = 0;
        int num = 0;
        while (true) {
            String numStr = String.valueOf(num);
            for (int i = 0; i < numStr.length(); i++) {
                count++;
                if (count == n) {
                    System.out.println("number:" + numStr + ", i:" + i);
                    return numStr.charAt(i) - '0';
                }
            }
            num++;
        }
    }

}
