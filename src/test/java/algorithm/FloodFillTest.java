package algorithm;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

public class FloodFillTest {

    @Test
    public void testFillColor(){
        int[][] matrix = new int[][]{
                {1,1,1,1,0,0},
                {0,0,1,1,0,0},
                {0,1,1,0,0,1},
                {0,1,0,1,0,0},
                {1,0,1,0,1,0}
        };

        FloodFill.fillColor(matrix,0,0,2);
        for (int i = 0; i < matrix.length; i++) {
            System.out.println(JSON.toJSONString(matrix[i]));
        }
    }

    @Test
    public void testFillBound(){
        int[][] matrix = new int[][]{
                {1,1,1,1,0,0},
                {1,1,1,1,0,0},
                {1,1,1,0,0,1},
                {1,1,0,1,0,0},
                {1,1,1,0,1,0}
        };

        FloodFill.fillBound(matrix,0,0,2);
        for (int i = 0; i < matrix.length; i++) {
            System.out.println(JSON.toJSONString(matrix[i]));
        }
    }
}
