package questions.leetbook.top_interview_questions.stack;

import org.junit.Assert;

import java.util.Stack;

/**
 * 给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。
 * <p>
 * 整数除法仅保留整数部分。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "3+2*2"
 * 输出：7
 * 示例 2：
 * <p>
 * 输入：s = " 3/2 "
 * 输出：1
 * 示例 3：
 * <p>
 * 输入：s = " 3+5 / 2 "
 * 输出：5
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 3 * 10^5
 * s 由整数和算符 ('+', '-', '*', '/') 组成，中间由一些空格隔开
 * s 表示一个 有效表达式
 * 表达式中的所有整数都是非负整数，且在范围 [0, 2^31 - 1] 内
 * 题目数据保证答案是一个 32-bit 整数
 * <p>
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions/xa8q4g/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class Calculator {
    public int calculate(String s) {
        Stack<Character> operators = new Stack<>();
        Stack<Integer> numbers = new Stack<>();
        int num = 0;
        int i = 0;
        boolean flag = true;
        while (i < s.length()) {
            char ch = s.charAt(i);
            if (ch == ' ') {
                i++;
                continue;
            }
            if (isOperators(ch)) {
                if (flag){
                    numbers.push(num);
                }
                num = 0;
                if (operators.isEmpty()) {
                    operators.push(ch);
                    i++;
                    continue;
                }
                if (compareOperator(operators.peek(), ch) == 0) {
                    int num1 = numbers.pop();
                    int num2 = numbers.pop();
                    numbers.push(calc(operators.pop(), num2, num1));
                } else if (compareOperator(ch, operators.peek()) < 0) {
                    int num1 = numbers.pop();
                    int num2 = numbers.pop();
                    numbers.push(calc(operators.pop(), num2, num1));
                    flag = false;
                    continue;
                }
                operators.push(ch);
            } else {
                num = num * 10 + ch - '0';
            }
            i++;
            flag = true;
        }
        numbers.push(num);
        while (!operators.isEmpty()) {
            int num1 = numbers.pop();
            int num2 = numbers.pop();
            numbers.push(calc(operators.pop(), num2, num1));
        }
        return numbers.pop();
    }

    private boolean isOperators(char ch) {
        return ch == '+' || ch == '-' || ch == '*' || ch == '/';
    }

    private int compareOperator(char op1, char op2) {
        if (op1 == op2 || (op1 == '-' && op2 == '+') || (op1 == '+' && op2 == '-') || (op1 == '*' && op2 == '/') || (op1 == '/' && op2 == '*')) {
            return 0;
        } else if ((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-')) {
            return 1;
        } else {
            return -1;
        }
    }

    private int calc(char operator, int num1, int num2) {
        switch (operator) {
            case '+':
                return num1 + num2;
            case '-':
                return num1 - num2;
            case '*':
                return num1 * num2;
            case '/':
                return num1 / num2;
        }
        return 0;
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        Assert.assertEquals(7, calculator.calculate("3+2*2"));
        Assert.assertEquals(1, calculator.calculate("3/2"));
        Assert.assertEquals(5, calculator.calculate(" 3+5 / 2 "));
        Assert.assertEquals(1, calculator.calculate("1-1+1"));
        Assert.assertEquals(1, calculator.calculate("1-2*3/5+1/2+1"));
        Assert.assertEquals(10, calculator.calculate("2*3+4"));
    }
}
