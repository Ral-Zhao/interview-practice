package questions.offer;

import org.junit.Assert;
import org.junit.Test;

public class ReverseWordsInSentenceTest {
    @Test
    public void test(){
        Assert.assertEquals("you. love I",ReverseWordsInSentence.reverse("I love you."));
        Assert.assertEquals("you.",ReverseWordsInSentence.reverse("you."));
    }
}
