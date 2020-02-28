package DataSturctures.sort;

import java.util.Arrays;

/**
 * 创建: 2020/2/28
 * 作者: fr
 */
//归并排序
public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {8, 4, 5, 7, 1, 3, 6, 2};
        int[] temp = new int[arr.length];
        mergeSort(arr, 0, arr.length - 1, temp);
        System.out.println(Arrays.toString(arr));
    }

    //分+合方法
    public static void mergeSort(int[] arr, int left, int right, int[] temp) {

        if (left < right) {
            int mid = (left + right) / 2;
            //向左递归分解
            mergeSort(arr, left, mid, temp);
            //向右递归分解
            mergeSort(arr, mid + 1, right, temp);
            merge(arr, left, mid, right, temp);
        }
    }


    /**
     * 合并方法
     *
     * @param arr   需要排序的数组
     * @param left  数组左边的初始索引
     * @param mid   已此值将数组分为左、右两边
     * @param right 数组右边的索引
     * @param temp  中转数组
     */
    public static void merge(int[] arr, int left, int mid, int right, int[] temp) {
        int i = left;           //初始化i，左边有序序列的索引
        int j = mid + 1;        //初始化j，右边有序序列的索引
        int t = 0;              //指向temp数组的当前索引

        //首先将左右两边（有序）的数组按照规则填充到temp数组中
        //直到左右两边的有序序列，有一边处理完为止
        while (i <= mid && j <= right) {
            if (arr[i] < arr[j]) {
                temp[t] = arr[i];
                i++;
            } else {
                temp[t] = arr[j];
                j++;
            }
            t++;
        }

        //将剩余数据的一边依次全部填充到temp数组中
        while (i <= mid) {    //左边元素有剩余，将剩余的元素全部依次拷贝到temp数组中
            temp[t] = arr[i];
            i++;
            t++;
        }

        while (j <= right) {  //右边元素有剩余，将剩余的元素全部依次拷贝到temp数组中
            temp[t] = arr[j];
            j++;
            t++;
        }

        //将temp数组中的元素填充到arr数组中
        t = 0;
        while (left <= right) {
            arr[left] = temp[t];
            left++;
            t++;
        }
    }
}
