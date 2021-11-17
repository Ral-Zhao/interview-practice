package questions.leetbook.top_interview_questions.test;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个整数 n ，找出从 1 到 n 各个整数的 Fizz Buzz 表示，并用字符串数组 answer（下标从 1 开始）返回结果，其中：
 * <p>
 * answer[i] == "FizzBuzz" 如果 i 同时是 3 和 5 的倍数。
 * answer[i] == "Fizz" 如果 i 是 3 的倍数。
 * answer[i] == "Buzz" 如果 i 是 5 的倍数。
 * answer[i] == i 如果上述条件全不满足。
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 3
 * 输出：["1","2","Fizz"]
 * 示例 2：
 * <p>
 * 输入：n = 5
 * 输出：["1","2","Fizz","4","Buzz"]
 * 示例 3：
 * <p>
 * 输入：n = 15
 * 输出：["1","2","Fizz","4","Buzz","Fizz","7","8","Fizz","Buzz","11","Fizz","13","14","FizzBuzz"]
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 10^4
 * <p>
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions/xm6kpg/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class FizzBuzz {
    public List<String> fizzBuzz(int n) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(String.valueOf(i+1));
        }
        for (int i = 1; i * 3 <= n; i++) {
            list.set(i * 3 - 1, "Fizz");
        }
        for (int i = 1; i * 5 <= n; i++) {
            list.set(i * 5 - 1, "Buzz");
        }
        for (int i = 1; i * 15 <= n; i++) {
            list.set(i * 15 - 1, "FizzBuzz");
        }

        return list;
    }

    public static void main(String[] args) {
        FizzBuzz solution = new FizzBuzz();
        List<String> result;
        result = solution.fizzBuzz(3);
        System.out.println(JSON.toJSONString(result));
        result = solution.fizzBuzz(5);
        System.out.println(JSON.toJSONString(result));
        result = solution.fizzBuzz(15);
        System.out.println(JSON.toJSONString(result));
    }
}
