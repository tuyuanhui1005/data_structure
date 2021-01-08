package heap;

import java.util.Arrays;

public class Test1 {
    public static void main(String[] args) {

        int[] arr = {5, 3, 6, 1, -1, 19, 20, 25, 22};
        sort(arr);
        System.out.println(Arrays.toString(arr));

    }

    public static void sort(int[] arr) {
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            adjuest(arr, i, arr.length);
        }
        for (int j = arr.length - 1; j > 0; j--) {
            adjuest(arr, 0, j);
            int temp = arr[j];
            arr[j] = arr[0];
            arr[0] = temp;
        }

    }


    public static void adjuest(int[] arr, int i, int length) {
        int temp = arr[i];
        for (int k = i * 2 + 1; k < length; k = k * 2 + 1) {
            if (k + 1 < length && arr[k] < arr[k + 1]) {
                k++;
            }
            if (temp < arr[k]) {
                arr[i] = arr[k];
                i = k;
            } else {
                break;
            }
            arr[i] = temp;
        }


    }


}
