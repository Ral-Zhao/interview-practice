package questions.offer;

import org.junit.Test;

public class ConstuctArrayTest {
    @Test
    public void test() {
        int[] arr = new int[]{1, 2, 3, 4, 5};
        int[] result = ConstuctArray.getArray(arr);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i]+" ");
        }
    }
}
