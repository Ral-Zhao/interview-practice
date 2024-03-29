package questions.leetbook.top_interview_questions.graph;

import com.alibaba.fastjson.JSON;

import java.util.*;

/**
 * 现在你总共有 numCourses 门课需要选，记为 0 到 numCourses - 1。
 * 给你一个数组 prerequisites ，其中 prerequisites[i] = [ai, bi] ，表示在选修课程 ai 前 必须 先选修 bi 。
 * <p>
 * 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示：[0,1] 。
 * 返回你为了学完所有课程所安排的学习顺序。可能会有多个正确的顺序，你只要返回 任意一种 就可以了。如果不可能完成所有课程，返回 一个空数组 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：numCourses = 2, prerequisites = [[1,0]]
 * 输出：[0,1]
 * 解释：总共有 2 门课程。要学习课程 1，你需要先完成课程 0。因此，正确的课程顺序为 [0,1] 。
 * 示例 2：
 * <p>
 * 输入：numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]
 * 输出：[0,2,1,3]
 * 解释：总共有 4 门课程。要学习课程 3，你应该先完成课程 1 和课程 2。并且课程 1 和课程 2 都应该排在课程 0 之后。
 * 因此，一个正确的课程顺序是 [0,1,2,3] 。另一个正确的排序是 [0,2,1,3] 。
 * 示例 3：
 * <p>
 * 输入：numCourses = 1, prerequisites = []
 * 输出：[0]
 *  
 * <p>
 * 提示：
 * 1 <= numCourses <= 2000
 * 0 <= prerequisites.length <= numCourses * (numCourses - 1)
 * prerequisites[i].length == 2
 * 0 <= ai, bi < numCourses
 * ai != bi
 * 所有[ai, bi] 匹配 互不相同
 *  
 * <p>
 * 拓展：
 * <p>
 * 这个问题相当于查找一个循环是否存在于有向图中。如果存在循环，则不存在拓扑排序，因此不可能选取所有课程进行学习。
 * 通过 DFS 进行拓扑排序 - 一个关于Coursera的精彩视频教程（21分钟），介绍拓扑排序的基本概念。
 * 拓扑排序也可以通过 BFS 完成。
 * <p>
 * <p>
 * <p>
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions/x2a743/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class FindOrder {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];
        Map<Integer, Set<Integer>> edges = new HashMap<>();
        for (int[] course : prerequisites) {
            inDegree[course[0]]++;
            Set<Integer> set = edges.getOrDefault(course[1], new HashSet<>());
            set.add(course[0]);
            edges.put(course[1], set);
        }
        int[] result = new int[numCourses];
        int index = 0;
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }
        while (!queue.isEmpty()) {
            int start = queue.poll();
            result[index++] = start;
            Set<Integer> set = edges.get(start);
            if (set == null || set.isEmpty()) {
                continue;
            }
            for (int n : set) {
                if (--inDegree[n] == 0) {
                    queue.add(n);
                }
            }
        }
        if (index < numCourses) {
            return new int[0];
        }
        return result;
    }

    public static void main(String[] args) {
        FindOrder solution = new FindOrder();
        int[] result;
        int[][] prerequisites = new int[][]{{1, 0}};
        result = solution.findOrder(2, prerequisites);
        System.out.println(JSON.toJSONString(result));
        prerequisites = new int[][]{{1, 0}, {2, 0}, {3, 1}, {3, 2}};
        result = solution.findOrder(4, prerequisites);
        System.out.println(JSON.toJSONString(result));
        prerequisites = new int[][]{{1, 0}, {1, 2}, {0, 1}};
        result = solution.findOrder(3, prerequisites);
        System.out.println(JSON.toJSONString(result));

    }
}
