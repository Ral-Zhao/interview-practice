package questions.offer;

import org.junit.Test;

public class CutStringTest {

    @Test
    public void testMaxLengthUseDP(){
        System.out.println(CutString.maxLengthUseDP(15));
    }

    @Test
    public void testMaxLengthUseGreed(){
        System.out.println(CutString.maxLengthUseGreed(15));
    }
}
