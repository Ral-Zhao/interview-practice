package algorithm;

/**
 * 在未排序的数组中找到第 k 个最大的元素
 */
public class TopK {
    /**
     * 小顶堆
     */
    public int method_1(int[] nums, int k) {
        int[] heap = new int[k];
        for (int i = 0; i < k; i++) {
            heap[i] = nums[i];
        }
        for (int i = (k - 2) / 2; i >= 0; i--) {
            fitDown(heap, i);
        }
        for (int i = k; i < nums.length; i++) {
            if (nums[i] > heap[0]) {
                heap[0] = nums[i];
                fitDown(heap, 0);
            }
        }

        return heap[0];
    }

    private void fitDown(int[] heap, int index) {
        int len = heap.length;
        while (index < len) {
            int left = index * 2 + 1;
            if (left >= len) {
                break;
            }
            int right = index * 2 + 2;
            int minIndex = right >= len ? left : heap[left] < heap[right] ? left : right;
            if (heap[index] > heap[minIndex]) {
                swap(heap, index, minIndex);
            }
            index = minIndex;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    /**
     * 快速选择算法
     */
    public int method_2(int[] nums, int k) {
        int index = select(nums, 0, nums.length - 1, k);
        return nums[index];
    }

    private int select(int[] nums, int l, int r, int k) {
        int left = l;
        int temp = nums[l];
        int right = r;
        while (left < right) {
            while (left < right && nums[right] >= temp) {
                right--;
            }
            if (left < right) {
                nums[left] = nums[right];
            }
            while (left < right && nums[left] < temp) {
                left++;
            }
            if (left < right) {
                nums[right] = nums[left];
            }
        }
        nums[left] = temp;
        if (left + k == nums.length) {
            return left;
        } else if (left + k < nums.length) {
            return select(nums, left + 1, r, k);
        } else {
            return select(nums, l, left - 1, k);
        }

    }
}
