package DataSturctures.sort;

import java.util.Arrays;

/**
 * 创建: 2020/2/22
 * 作者: fr
 */
public class ShellSort {

    public static void main(String[] args) {
        int[] arr = {8, 9, 1, 7, 2, 3, 5, 4, 6, 0};
        shellSort2(arr);
        System.out.println(Arrays.toString(arr));
    }

    //交换法（耗时较大）
    public static void shellSort(int[] arr) {

        int temp = 0;

        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                for (int j = i - gap; j >= 0; j -= gap) {
                    if (arr[j] > arr[j + gap]) {
                        temp = arr[j];
                        arr[j] = arr[j + gap];
                        arr[j + gap] = temp;
                    }
                }
            }
        }

        /*
         * 希尔排序首先将需要排序的数组分为length/2组进行比较排序
         * 再将排序好的数组分为length/2/2组直至分为为1组为止
         * 再进行最后一次排序
         */
        /*
        //第一轮排序
        for (int i = 5; i < arr.length; i++) {
            for (int j = i - 5; j >= 0; j -= 5) {
                if (arr[j] > arr[j + 5]) {
                    temp = arr[j];
                    arr[j] = arr[j + 5];
                    arr[j + 5] = temp;
                }
            }
        }

        System.out.println(Arrays.toString(arr));

        for (int i = 5/2; i < arr.length; i++) {
            for (int j = i - 5/2; j >= 0; j -= 5/2) {
                if (arr[j] > arr[j + 5/2]) {
                    temp = arr[j];
                    arr[j] = arr[j + 5/2];
                    arr[j + 5/2] = temp;
                }
            }
        }

        System.out.println(Arrays.toString(arr));

        for (int i = 5/2/2; i < arr.length; i++) {
            for (int j = i - 5/2/2; j >= 0; j -= 5/2/2) {
                if (arr[j] > arr[j + 5/2/2]) {
                    temp = arr[j];
                    arr[j] = arr[j + 5/2/2];
                    arr[j + 5/2/2] = temp;
                }
            }
        }

        System.out.println(Arrays.toString(arr));
         */
    }

    //移动法（耗时小）
    public static void shellSort2(int[] arr) {

        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                int insertIndex = i;         //待插入数的下标
                int insertVal = arr[insertIndex]; //待插入数

                if (insertVal < arr[insertIndex - gap]) {
                    while (insertIndex - gap >= 0 && insertVal < arr[insertIndex - gap]) {
                        //移动
                        arr[insertIndex] = arr[insertIndex - gap];
                        insertIndex -= gap;
                    }
                    arr[insertIndex] = insertVal;
                }
            }
        }
    }
}
