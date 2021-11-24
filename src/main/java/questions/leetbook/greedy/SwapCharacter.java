package questions.leetbook.greedy;

/**
 * 有两个长度相同的字符串 s1 和 s2，且它们其中 只含有 字符 "x" 和 "y"，你需要通过「交换字符」的方式使这两个字符串相同。
 *
 * 每次「交换字符」的时候，你都可以在两个字符串中各选一个字符进行交换。
 *
 * 交换只能发生在两个不同的字符串之间，绝对不能发生在同一个字符串内部。也就是说，我们可以交换 s1[i] 和 s2[j]，但不能交换 s1[i] 和 s1[j]。
 *
 * 最后，请你返回使 s1 和 s2 相同的最小交换次数，如果没有方法能够使得这两个字符串相同，则返回 -1 。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s1 = "xx", s2 = "yy"
 * 输出：1
 * 解释：
 * 交换 s1[0] 和 s2[1]，得到 s1 = "yx"，s2 = "yx"。
 * 示例 2：
 *
 * 输入：s1 = "xy", s2 = "yx"
 * 输出：2
 * 解释：
 * 交换 s1[0] 和 s2[0]，得到 s1 = "yy"，s2 = "xx" 。
 * 交换 s1[0] 和 s2[1]，得到 s1 = "xy"，s2 = "xy" 。
 * 注意，你不能交换 s1[0] 和 s1[1] 使得 s1 变成 "yx"，因为我们只能交换属于两个不同字符串的字符。
 * 示例 3：
 *
 * 输入：s1 = "xx", s2 = "xy"
 * 输出：-1
 * 示例 4：
 *
 * 输入：s1 = "xxyyxyxyxx", s2 = "xyyxyxxxyx"
 * 输出：4
 *  
 *
 * 提示：
 *
 * 1 <= s1.length, s2.length <= 1000
 * s1, s2 只包含 'x' 或 'y'。
 *
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/greedy/rvkx9e/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class SwapCharacter {
    public int minimumSwap(String s1, String s2) {
        // 根据题目提示1 <= s1.length, s2.length <= 1000，所以可以不用做判断处理
        // 根据贪心算法原则：
        // 1、我们先剔除不需要交换的元素（s1、s2对应位置相等的元素）
        // 2、然后再处理只需要一次交换的场景(xx或yy)
        // 3、然后再处理需要两次交换的场景(xy或yx)
        // 以上就是所有的场景
        char[] s1Arr = s1.toCharArray();
        char[] s2Arr = s2.toCharArray();

        int length = s1.length();
        // 首先我们统计第一步之后s1剩下的x和y的个数.
        // 定义numX代表s1剩下的x的个数
        // 定义numY代表s1剩下的y的个数
        int numX = 0;
        int numY = 0;
        for(int i=0; i<length;i++) {
            if(s1Arr[i] - s2Arr[i] < 0) {
                numX++;
            } else if(s1Arr[i] - s2Arr[i] > 0) {
                numY++;
            }
        }
        // 然后判断x和y的总个数如果是奇数，说明通过交换永远无法形成两个相同的字符串。则直接返回-1
        if((numX+numY)%2 != 0) {
            return -1;
        }

        //当x和y的总个数是偶数时，如果x的个数是偶数，则y的个数也是偶数。则只需要按照一次交换的场景（xx或yy）处理即可.
        //当x和y的总个数是偶数时，如果x的个数是奇数，则y的个数也是奇数。优先按照一次交换的场景（xx或yy）处理,然后剩下的一对(xy或yx)则直接按照两次交换的场景(xy或yx)来处理。
        return numX/2 + numY/2 + (numX%2)*2;
    }
}
