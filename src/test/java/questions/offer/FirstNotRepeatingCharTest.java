package questions.offer;

import org.junit.Assert;
import org.junit.Test;

public class FirstNotRepeatingCharTest {
    @Test
    public void test(){
        Assert.assertEquals('g',FirstNotRepeatingChar.firstChar("aaghebse"));
        Assert.assertEquals('w',FirstNotRepeatingChar.firstChar("bbssffewegr"));
    }
}
