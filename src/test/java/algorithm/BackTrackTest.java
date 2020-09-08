package algorithm;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.List;

public class BackTrackTest {

    @Test
    public void testPermute() {
        int[] nums = new int[]{1, 2, 3, 4};
        List<List<Integer>> result = BackTrack.permute(nums);
        for (List<Integer> list : result) {
            System.out.println(JSON.toJSONString(list));
        }
    }

    @Test
    public void testNQueen() {
        List<int[][]> result = BackTrack.nQueen(8);
        for (int[][] res : result) {
            for (int[] row : res) {
                System.out.println(JSON.toJSONString(row));
            }
            System.out.println("==================");
        }
    }

    @Test
    public void testSubsets() {
        int[] nums = new int[]{1,2,3,4};
        List<List<Integer>> result = BackTrack.subsets(nums);
        for (List<Integer> list : result) {
            System.out.println(JSON.toJSONString(list));
        }
    }

    @Test
    public void testCombine() {
        List<List<Integer>> result = BackTrack.combine(5,2);
        for (List<Integer> list : result) {
            System.out.println(JSON.toJSONString(list));
        }
    }
}
