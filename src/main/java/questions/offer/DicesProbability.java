package questions.offer;

import java.text.DecimalFormat;

/**
 *  题目60 n个骰子的点数
 *
 *  把n个骰子仍在地上，所有骰子朝上一面的点数之和为s。输入n，打印出s的所有可能的值出现的概率。
 */
public class DicesProbability {
    public static String[] calcProbability(int n) {
        if (n < 1) {
            return null;
        }
        int[] prob1 = new int[6 * n + 1];
        int[] prob2 = new int[6 * n + 1];
        for (int i = 1; i <= 6; i++) {
            prob1[i] = 1;
        }
        for (int i = 2; i <= n; i++) {
            int[] arr = prob1;
            prob1 = prob2;
            prob2 = arr;
            for (int j = 0; j <= i; j++) {
                prob1[j] = 0;
            }
            for (int j = i; j <= 6 * i; j++) {
                int temp = 0;
                for (int k = 1; k <= 6; k++) {
                    if (j - k < 0) {
                        continue;
                    }
                    temp += prob2[j - k];
                }
                prob1[j] = temp;
            }
        }
        int count = 0;
        for (int aProb1 : prob1) {
            count += aProb1;
        }
        String[] result = new String[prob1.length-n];
        for (int i = n; i < prob1.length; i++) {
            double prob = 1.0 * prob1[i] / count;
            DecimalFormat df = new DecimalFormat("0.000");
            result[i-n] = df.format(prob);
        }

        return result;
    }
}
