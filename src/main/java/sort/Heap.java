package sort;

public class Heap {

    public static void buildHeap(int[] arr) {
        for (int i = (arr.length - 2) / 2; i >= 0; i--) {
            //从最后一个非叶子节点开始，依次向下调整
            fit(arr, i, arr.length);
        }
    }

    private static void fit(int[] arr, int index, int len) {
        //向下寻找直到叶子节点退出循环
        while (index * 2 + 1 < len) {
            int left = index * 2 + 1;
            int right = index * 2 + 2;
            //右孩子节点可能不存在，此时最大节点默认为左孩子
            int big = right < len && arr[left] < arr[right] ? right : left;
            //将比父节点大的子节点与父节点交换
            if (arr[index] < arr[big]) {
                int temp = arr[big];
                arr[big] = arr[index];
                arr[index] = temp;
            }
            //从交换的子节点开始向下重复上述过程
            index = big;
        }
    }

    public static void sort(int[] arr) {
        buildHeap(arr);
        for (int i = arr.length - 1; i > 0; i--) {
            int temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;
            fit(arr, 0, i);
        }
    }
}
