package heap;


import java.util.Arrays;

/**
 * 从左至右 从上至下 第一个非叶子节点，将大的子节点与改
 * 节点进行交换
 * 时间复杂度 O（nlogn） 不稳定排序
 */
public class heapSort {


    public static void main(String[] args) {
        int[] arr = {2, 6, 7, 11, 5, 12, 3, 0, 1};
        heapsort(arr);
        System.out.println(Arrays.toString(arr));


    }

    public static void heapsort(int[] arr) {
        System.out.println("执行堆排序");

        //int temp= 0 ;

        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            adjustHeap(arr, i, arr.length);
        }
        for (int j = arr.length - 1; j > 0; j--) {
            int temp = arr[j];
            arr[j] = arr[0];
            arr[0] = temp;
            adjustHeap(arr, 0, j);
        }

    }

    /**
     * @param arr    待调整的数组
     * @param i      表示非叶子节点的下标   第一个为  arr.length/2 -1
     * @param length 数组长度
     */
    public static void adjustHeap(int  []arr, int i, int length) {

        int temp = arr[i];
        for (int k = i * 2 + 1; k < length; k = k * 2 + 1) {
            if (k + 1 < length && arr[k] < arr[k + 1]) {
                k++;
            }
            if (arr[k] > temp) {
                arr[i] = arr[k];
                i = k;
            } else {
                break;
            }
        }
        arr[i] = temp;
    }


}
