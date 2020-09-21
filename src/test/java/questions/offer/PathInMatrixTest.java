package questions.offer;

import org.junit.Assert;
import org.junit.Test;

public class PathInMatrixTest {
    @Test
    public void testHasPath(){
        char[][] matrix = new char[][]{
                {'a','c','e','g','h'},
                {'i','d','p','e','n'},
                {'h','j','w','x','m'},
                {'l','j','l','z','r'},
        };
        Assert.assertTrue(!PathInMatrix.hasPath(matrix,"pdcep"));
        Assert.assertTrue(PathInMatrix.hasPath(matrix,"pdce"));
        matrix = new char[][]{
                {'a','c','e','g','h'},
        };
        Assert.assertTrue(!PathInMatrix.hasPath(matrix,"acde"));
        Assert.assertTrue(PathInMatrix.hasPath(matrix,"aceg"));
        matrix = new char[][]{
                {'a','a','a','a'},
                {'a','a','a','a'},
                {'a','a','a','a'},
                {'a','a','a','a'},
        };
        Assert.assertTrue(!PathInMatrix.hasPath(matrix,"acaa"));
        Assert.assertTrue(PathInMatrix.hasPath(matrix,"aaaaa"));

    }
}
