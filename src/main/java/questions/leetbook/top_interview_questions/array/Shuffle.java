package questions.leetbook.top_interview_questions.array;

import java.util.Random;

/**
 * Created by zhaozhezijian on 2021/8/22.
 */
public class Shuffle {
    private int[] origin;
    private int[] copy;

    public Shuffle(int[] nums) {
        this.origin = nums;
        copy = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            copy[i] = nums[i];
        }
    }

    /**
     * Resets the array to its original configuration and return it.
     */
    public int[] reset() {
        return origin;
    }

    /**
     * Returns a random shuffling of the array.
     */
    public int[] shuffle() {
        for (int i = copy.length - 1; i > 0; i--) {
            int random = new Random().nextInt(i+1);
            int temp = copy[random];
            copy[random] = copy[i];
            copy[i] = temp;
        }
        return copy;
    }
}
