package DataSturctures.sort;

import java.util.Arrays;

/**
 * 创建: 2020/2/19
 * 作者: fr
 */
//冒泡排序
public class BubbleSort {

    //将数从小到大排序
    public static void main(String[] args) {
//        int arr[] = {3, -1, 5, 4, 8, -2};
        int arr[] = {3, 2, 4, 5, 6};

        int temp; //临时变量
        boolean flag = false; //表示是否进行过交换（用来优化冒泡排序，可能数组在遍历完之前就已经有序）
        //第一趟遍历将最大的数排到最后
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    flag = false;
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                } else {
                    flag = true;
                }
            }
            System.out.printf("第%d趟的数组: %s\n", i + 1, Arrays.toString(arr));
            if (flag) {
                return;
            }
        }
    }
}
