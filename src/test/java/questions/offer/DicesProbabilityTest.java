package questions.offer;

import org.junit.Test;

public class DicesProbabilityTest {
    @Test
    public void test(){
        String[] result = DicesProbability.calcProbability(2);
        for (String s:result){
            System.out.print(s+" ");
        }
        System.out.println();
        result = DicesProbability.calcProbability(3);
        for (String s:result){
            System.out.print(s+" ");
        }
    }
}
