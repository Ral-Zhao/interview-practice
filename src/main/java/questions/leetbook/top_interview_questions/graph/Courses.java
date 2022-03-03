package questions.leetbook.top_interview_questions.graph;

import org.junit.Assert;

import java.util.*;

/**
 * 你这个学期必须选修 numCourses 门课程，记为 0 到 numCourses - 1 。
 * <p>
 * 在选修某些课程之前需要一些先修课程。 先修课程按数组 prerequisites 给出，其中 prerequisites[i] = [ai, bi] ，
 * 表示如果要学习课程 ai 则 必须 先学习课程  bi 。
 * <p>
 * 例如，先修课程对 [0, 1] 表示：想要学习课程 0 ，你需要先完成课程 1 。
 * 请你判断是否可能完成所有课程的学习？如果可以，返回 true ；否则，返回 false 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：numCourses = 2, prerequisites = [[1,0]]
 * 输出：true
 * 解释：总共有 2 门课程。学习课程 1 之前，你需要完成课程 0 。这是可能的。
 * 示例 2：
 * <p>
 * 输入：numCourses = 2, prerequisites = [[1,0],[0,1]]
 * 输出：false
 * 解释：总共有 2 门课程。学习课程 1 之前，你需要先完成​课程 0 ；并且学习课程 0 之前，你还应先完成课程 1 。这是不可能的。
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= numCourses <= 10^5
 * 0 <= prerequisites.length <= 5000
 * prerequisites[i].length == 2
 * 0 <= ai, bi < numCourses
 * prerequisites[i] 中的所有课程对 互不相同
 * <p>
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions/x2muyh/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class Courses {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegrees = new int[numCourses];
        List<List<Integer>> adjacency = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++)
            adjacency.add(new ArrayList<>());
        // Get the indegree and adjacency of every course.
        for (int[] cp : prerequisites) {
            indegrees[cp[0]]++;
            adjacency.get(cp[1]).add(cp[0]);
        }
        // Get all the courses with the indegree of 0.
        for (int i = 0; i < numCourses; i++)
            if (indegrees[i] == 0) queue.add(i);
        // BFS TopSort.
        while (!queue.isEmpty()) {
            int pre = queue.poll();
            numCourses--;
            for (int cur : adjacency.get(pre))
                if (--indegrees[cur] == 0) queue.add(cur);
        }
        return numCourses == 0;
    }

    public boolean method_2(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjacency = new ArrayList<>();
        for (int i = 0; i < numCourses; i++)
            adjacency.add(new ArrayList<>());
        int[] flags = new int[numCourses];
        for (int[] cp : prerequisites)
            adjacency.get(cp[1]).add(cp[0]);
        for (int i = 0; i < numCourses; i++)
            if (!dfs(adjacency, flags, i)) return false;
        return true;
    }

    private boolean dfs(List<List<Integer>> adjacency, int[] flags, int i) {
        if (flags[i] == 1) return false;
        if (flags[i] == -1) return true;
        flags[i] = 1;
        for (Integer j : adjacency.get(i))
            if (!dfs(adjacency, flags, j)) return false;
        flags[i] = -1;
        return true;
    }

    public static void main(String[] args) {
        Courses solution = new Courses();
        int[][] prerequisites = new int[][]{{1, 0}};
        Assert.assertTrue(solution.canFinish(1, prerequisites));
        solution = new Courses();
        prerequisites = new int[][]{{1, 0}, {0, 1}};
        Assert.assertTrue(!solution.canFinish(2, prerequisites));
        solution = new Courses();
        prerequisites = new int[][]{{1, 4}, {2, 4}, {3, 1}, {3, 2}};
        Assert.assertTrue(solution.canFinish(5, prerequisites));
        solution = new Courses();
        prerequisites = new int[][]{{0, 2}, {1, 2}, {2, 0}};
        Assert.assertTrue(!solution.canFinish(3, prerequisites));
        solution = new Courses();
        prerequisites = new int[][]{{0, 1}, {0, 2}, {1, 2}};
        Assert.assertTrue(solution.canFinish(3, prerequisites));
    }
}
