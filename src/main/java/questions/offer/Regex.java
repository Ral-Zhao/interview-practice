package questions.offer;

/**
 *  题目19 正则表达式匹配
 *
 *  实现用来匹配包含'.'和'*'的正则表达式。模式中'.'表示任意一个字符，而'*'表示它前面字符可以出现任意次(包含0次)
 *  这里的匹配指字符串的所有字符匹配整个模式。
 */
public class Regex {

    public static boolean match(String pattern, String input) {
        if (pattern != null && input != null) {
            return helper(pattern, 0, input, 0);
        }
        return false;
    }

    private static boolean helper(String patter, int patterIndex, String input, int inputIndex) {
        if (patterIndex >= patter.length() - 1 && inputIndex >= input.length() - 1) {
            return true;
        }
        if (patterIndex >= patter.length() - 1 && inputIndex < input.length() - 1) {
            return false;
        }
        //下一个模式是*
        if (patter.charAt(patterIndex + 1) == '*') {
            //该条件表示当前模式匹配
            if (patter.charAt(patterIndex) == input.charAt(inputIndex)
                    || (patter.charAt(patterIndex) == '.' && inputIndex < input.length() - 1)) {
                //第一种选择：跳过模式*，跳过当前字符，去看后面的匹配结果。
                return helper(patter, patterIndex + 2, input, inputIndex + 1)
                        //第二种选择，跳过当前字符，继续进行*模式匹配，因为*可以匹配多个字符
                        || helper(patter, patterIndex, input, inputIndex + 1)
                        //第三种选择，跳过*模式，匹配后续的字符，因为*可以匹配0个字符
                        || helper(patter, patterIndex + 2, input, inputIndex);
            } else {
                //当前模式不匹配，则将模式向后移动两个位置，因为*可以表示0次出现，所以需要跳过* 看后面是否匹配；
                return helper(patter, patterIndex + 2, input, inputIndex);
            }

        }

        if (patter.charAt(patterIndex) == input.charAt(inputIndex)
                || (patter.charAt(patterIndex) == '.' && inputIndex < input.length() - 1)) {
            return helper(patter, patterIndex + 1, input, inputIndex + 1);
        }
        return false;
    }
}
