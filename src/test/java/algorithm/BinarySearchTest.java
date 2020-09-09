package algorithm;

import org.junit.Test;

public class BinarySearchTest {

    @Test
    public void testSearch() {
        int[] nums = new int[]{1, 2, 5, 6, 7, 9, 12, 16};
        System.out.println(BinarySearch.search(nums, 2));
        System.out.println(BinarySearch.search2(nums, 5));
    }

    @Test
    public void testSearchLeftBound() {
        int[] nums = new int[]{1, 2, 2, 2, 7, 9, 9, 16};
        System.out.println(BinarySearch.findLeftBound(nums, 9));
    }

    @Test
    public void testSearchRightBound() {
        int[] nums = new int[]{1, 2, 2, 2, 7, 9, 9, 16};
        System.out.println(BinarySearch.findRightBound(nums, 2));
        System.out.println(BinarySearch.findRightBound(nums, 9));
    }
}
