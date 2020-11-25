package questions.offer;

/**
 * 题目58-1 翻转字符串
 *
 * 输入一个英文句子，翻转句中单词的顺序，但单词内字符的顺序不变。
 * 为简单起见，标点符号和普通字母一样处理。
 * 例如输入"I am a student."，输出"student. a am I"。
 */
public class ReverseWordsInSentence {
    public static String reverse(String sentence) {
        if (sentence == null || sentence.length() == 0) {
            return sentence;
        }
        StringBuilder sb = new StringBuilder();
        String[] arr = sentence.split(" ");
        for (int i = arr.length - 1; i >= 0; i--) {
            sb.append(arr[i]).append(" ");
        }
        return sb.toString().trim();
    }
}
