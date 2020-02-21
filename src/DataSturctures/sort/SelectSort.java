package DataSturctures.sort;

import java.util.Arrays;

/**
 * 创建: 2020/2/21
 * 作者: fr
 */
//选择排序
public class SelectSort {

    public static void main(String[] args) {
        int[] arr = {4, -1, 3, 5, -2};
        selectSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void selectSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            int min;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[minIndex] > arr[j]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {   //对选择排序进行优化，如果最小值就在当前位置则无需进行交换
                min = arr[minIndex];
                arr[minIndex] = arr[i];
                arr[i] = min;
            }
        }
    }
//        int minIndex = 0;
//        int min;
//        for (int i = 0 + 1; i < arr.length; i++) {
//            if (arr[minIndex] > arr[i]) {
//                minIndex = i;
//            }
//        }
//        min = arr[minIndex];
//        arr[minIndex] = arr[0];
//        arr[0] = min;
}
