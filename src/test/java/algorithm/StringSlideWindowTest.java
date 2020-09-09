package algorithm;

import org.junit.Test;

public class StringSlideWindowTest {

    @Test
    public void testMinSubStringCovered(){
        System.out.println(StringSlideWindow.minSubStringCovered("ADOBECODEBANC","ABO"));
    }

    @Test
    public void testFindAnagrams(){
        System.out.println(StringSlideWindow.findAnagrams("abciedbdacbaokb","abc"));
    }

    @Test
    public void testLengthOfLongestSubstring(){
        System.out.println(StringSlideWindow.lengthOfLongestSubstring("abbdiffkljff"));
    }
}
