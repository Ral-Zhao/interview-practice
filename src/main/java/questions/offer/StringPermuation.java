package questions.offer;

import java.util.ArrayList;
import java.util.List;

/**
 *  题目38 字符串的排列
 *
 *  输入一个字符串，打印出该字符串的所有排列。
 */
public class StringPermuation {
    public static List<String> permuation(String input) {
        if (input == null || "".equals(input)) {
            return null;
        }
        List<String> result = new ArrayList<>();
        List<Integer> index = new ArrayList<>();
        backTrace(result, index, input);
        return result;
    }

    private static void backTrace(List<String> result, List<Integer> index, String input) {
        if (index.size() == input.length()) {
            StringBuilder sb = new StringBuilder();
            for (Integer i : index) {
                sb.append(input.charAt(i));
            }
            result.add(sb.toString());
            return;
        }
        for (int i = 0; i < input.length(); i++) {
            if (index.contains(i)) {
                continue;
            }
            index.add(i);
            backTrace(result, index, input);
            index.remove(index.size() - 1);
        }

    }
}
