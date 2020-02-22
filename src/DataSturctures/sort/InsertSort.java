package DataSturctures.sort;

import java.util.Arrays;

/**
 * 创建: 2020/2/21
 * 作者: fr
 */
public class InsertSort {

    public static void main(String[] args) {
        int[] arr = {4, 2, -1, -2};
        insertSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    //从小到大排序
    public static void insertSort(int[] arr) {

        for (int i = 1; i < arr.length; i++) {
            int insertVal = arr[i];
            int insertIndex = i - 1;

            /*
             * insertIndex >= 0 保证下标不越界
             * insertVal < arr[insertIndex] 表示待插入的数还没找到位置
             */
            while (insertIndex >= 0 && insertVal < arr[insertIndex]) {
                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex--;
            }

            if (insertIndex + 1 != i) {
                arr[insertIndex + 1] = insertVal;
            }
        }

//        int insertVal = arr[1];
//        int insertIndex = 1 - 1;
//
//        while (insertIndex >= 0 && insertVal < arr[insertIndex]) {
//            arr[insertIndex + 1] = arr[insertIndex];
//            insertIndex--;
//        }
//
//        arr[insertIndex + 1] = insertVal;
    }
}
