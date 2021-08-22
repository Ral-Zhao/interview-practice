package questions.leetbook.top_interview_questions.string;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 给定一个 m x n 二维字符网格 board 和一个单词（字符串）列表 words，找出所有同时在二维网格和字典中出现的单词。
 * <p>
 * 单词必须按照字母顺序，通过 相邻的单元格 内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母在一个单词中不允许被重复使用。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：board = [["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f","l","v"]], words = ["oath","pea","eat","rain"]
 * 输出：["eat","oath"]
 * 示例 2：
 * <p>
 * <p>
 * 输入：board = [["a","b"],["c","d"]], words = ["abcb"]
 * 输出：[]
 *  
 * <p>
 * 提示：
 * <p>
 * m == board.length
 * n == board[i].length
 * 1 <= m, n <= 12
 * board[i][j] 是一个小写英文字母
 * 1 <= words.length <= 3 * 10^4
 * 1 <= words[i].length <= 10
 * words[i] 由小写英文字母组成
 * words 中的所有字符串互不相同
 * <p>
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions/xaorig/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class FindWord {
    private Node root = new Node(' ');
    private final static int[][] DIRECTIONS = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    private char[][] board;

    public List<String> findWords(char[][] board, String[] words) {
        this.board = board;
        buildTrie(words);
        Set<String> result = new HashSet<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                Node child = root.getChild(board[i][j]);
                if (child!=null){
                    helper(result, i, j, "", child);
                }
            }
        }
        return new ArrayList<>(result);
    }

    private void helper(Set<String> result, int i, int j, String target, Node node) {
        if (!validBound(i, j) || board[i][j] == '.') {
            return;
        }
        char ch = board[i][j];
        if (node.val == ch) {
            if (node.isLeaf) {
                result.add(target + ch);
            }
            board[i][j] = '.';
            for (Node child : node.children) {
                if (child == null) {
                    continue;
                }
                for (int[] direction : DIRECTIONS) {
                    helper(result, i + direction[0], j + direction[1], target + ch, child);
                }
            }
            board[i][j] = ch;
        }

    }

    private boolean validBound(int i, int j) {
        return i >= 0 && i < board.length && j >= 0 && j < board[0].length;
    }

    private void buildTrie(String[] words) {
        for (String word : words) {
            Node node = root;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                Node child = node.getChild(ch);
                if (child == null) {
                    node.addChild(ch);
                    child = node.getChild(ch);
                }
                node = child;
            }
            node.isLeaf = true;
        }
    }

    class Node {
        boolean isLeaf;
        char val;
        Node[] children = new Node[26];

        Node(char val) {
            this.val = val;
        }

        Node getChild(char ch) {
            return children[ch - 'a'];
        }

        void addChild(char ch) {

            children[ch - 'a'] = new Node(ch);
        }
    }

    public static void main(String[] args) {
        FindWord solution = new FindWord();
        char[][] board = new char[][]{{'o', 'a', 'a', 'n'}, {'e', 't', 'a', 'e'}, {'i', 'h', 'k', 'r'}, {'i', 'f', 'l', 'v'}};
        String[] words = new String[]{"oath", "pea", "eat", "rain"};
        List<String> result = solution.findWords(board, words);
        System.out.println(JSON.toJSONString(result));
        board = new char[][]{{'a','b'},{'c','d'}};
        words = new String[]{"abcb"};
        result = solution.findWords(board, words);
        System.out.println(JSON.toJSONString(result));
    }
}
