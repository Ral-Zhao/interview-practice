package questions.offer;

import java.util.Arrays;

/**
 *  题目61 扑克牌中的顺子
 *
 *  从扑克牌中随机抽5张牌，判断是不是一个顺子，即这五张牌是不是连续的。
 *  2~10为数字本身，A为1，J为11，Q为12，K为13，而大、小王可以看成任意数字。
 */
public class ContinuousCards {
    public static boolean isContinuous(int[] cards) {
        if (cards == null || cards.length == 0) {
            return false;
        }
        Arrays.sort(cards);
        int zeroNum = 0;
        for (int i = 0; i < cards.length; i++) {
            if (cards[i] == 0) {
                zeroNum++;
                continue;
            }
            if (i < cards.length - 1) {
                int post = i + 1;
                if (cards[post] == cards[i]) {
                    return false;
                }
                if (cards[post] - cards[i] - 1 > zeroNum) {
                    return false;
                }
                zeroNum = zeroNum - (cards[post] - cards[i] - 1);
            }
        }
        return true;
    }
}
