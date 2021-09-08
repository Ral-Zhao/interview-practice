package questions.leetbook.top_interview_questions.hash;

import org.junit.Assert;

/**
 * 给你一个字符串 columnTitle ，表示 Excel 表格中的列名称。返回该列名称对应的列序号。
 * <p>
 *  
 * <p>
 * 例如，
 * <p>
 * A -> 1
 * B -> 2
 * C -> 3
 * ...
 * Z -> 26
 * AA -> 27
 * AB -> 28
 * ...
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: columnTitle = "A"
 * 输出: 1
 * 示例 2:
 * <p>
 * 输入: columnTitle = "AB"
 * 输出: 28
 * 示例 3:
 * <p>
 * 输入: columnTitle = "ZY"
 * 输出: 701
 * 示例 4:
 * <p>
 * 输入: columnTitle = "FXSHRXW"
 * 输出: 2147483647
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= columnTitle.length <= 7
 * columnTitle 仅由大写英文组成
 * columnTitle 在范围 ["A", "FXSHRXW"] 内
 * <p>
 * <p>
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions/xa6dkt/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class ColumnTitle {
    public int titleToNumber(String columnTitle) {
        int sum = 0;
        for (int i = 0; i < columnTitle.length(); i++) {
            char ch = columnTitle.charAt(i);
            sum += (ch - 'A' + 1) * Math.pow(26, columnTitle.length() - i - 1);
        }
        return sum;
    }

    public static void main(String[] args) {
        ColumnTitle solution = new ColumnTitle();
        Assert.assertEquals(28, solution.titleToNumber("AB"));
        Assert.assertEquals(701, solution.titleToNumber("ZY"));
        Assert.assertEquals(2147483647, solution.titleToNumber("FXSHRXW"));
    }
}
