package DataSturctures.sort;

import java.util.Arrays;

/**
 * 创建: 2020/2/23
 * 作者: fr
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] arr = {2,3,9,5,6,7,8};
//        int[] arr = {4,5,3,2,6,9,8};
        quickSort(arr,0,6);
        System.out.println(Arrays.toString(arr));
     }

    /**
     * @param arr 需要排序的数组
     * @param left   数组的起始数的下标
     * @param right   数组最后一位数的下标
     */
    public static void quickSort(int[] arr, int left, int right) {
        int l = left;
        int r = right;
        int mid = arr[(l + r) / 2];   //数组的中间值
        int temp = 0;            //临时变量，交换时使用

        while (l < r) {

            while (arr[l] < mid){
                l++;
            }

            while (arr[r] > mid){
                r--;
            }

            if (l >= r){
                break;
            }

            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;

            /*
             * arr[l] == mid,arr[r] == mid
             * 这两个判断是防止有一边是有序的情况
             * l : 递归的右起始点
             * r : 递归的左终止点
             */
            if (arr[l] == mid){
                r--;
            }

            if (arr[r] == mid){
                l++;
            }
        }

        //如果 l == r,必须l++,r--,否则栈溢出
        if (l == r){
            l++;
            r--;
        }

        //向左递归
        if (left < r){
            quickSort(arr,left,r);
        }

        //向右递归
        if (right > l){
            quickSort(arr,l,right);
        }

    }
}
