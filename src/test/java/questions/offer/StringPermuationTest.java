package questions.offer;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class StringPermuationTest {
    @Test
    public void test() {
        String str = "abcd";
        List<String> result = StringPermuation.permuation(str);
        Assert.assertEquals(24, result.size());
        for (String s : result) {
            System.out.println(s);
        }
    }
}
