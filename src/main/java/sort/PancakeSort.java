package sort;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定数组A，对其进行煎饼翻转：我们选择一些正整数k<=A.length，
 * 然后反转前k个元素的顺序，我们要执行若干次煎饼翻转以完成对数组A的排序。
 * 返回能使A排序的煎饼翻转操作对应的k值序列
 */
public class PancakeSort {

    public static List<Integer> sort(int[] nums) {
        List<Integer> result = new ArrayList<>();
        helper(result, nums, nums.length - 1);
        return result;
    }

    private static void helper(List<Integer> result, int[] nums, int bound) {
        if (bound == 0) {
            return;
        }
        int max = 0;
        int iMax = bound;
        for (int i = bound; i >= 0; i--) {
            if (nums[i] > max) {
                iMax = i;
                max = nums[i];
            }
        }
        if (iMax != bound){
            reverse(nums, 0, iMax);
            result.add(iMax + 1);
            reverse(nums, 0, bound);
            result.add(bound + 1);
        }

        helper(result, nums, bound - 1);
    }

    private static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
