package algorithm;

import java.util.Arrays;

public class 合并两个有序数组 {

    public static void main(String[] args) {
        int[] nums1 = {1,2,3};
        int[] nums2 = {2,5,6};
        int[] merge = new 合并两个有序数组().merge(nums1, 3, nums2, 3);
        System.out.println(Arrays.toString(merge));
    }

    public int[] merge(int[] nums1, int m, int[] nums2, int n) {
        int i = 0,j = 0;
        int t = 0;
        int[] tempArr = new int[m+n];

        //将左右两边有序的数组按从小到大的顺序填充到tempArr中，直至有一个数组被处理完
        while(i < m && j < n){
            if(nums1[i] < nums2[j]){
                tempArr[t] = nums1[i];
                i++;
            }else{
                tempArr[t] = nums2[j];
                j++;
            }
            t++;
        }

        //将数组剩余的部分全部填充到tempArr
        //nums1未处理完
        while (i < m){
            tempArr[t] = nums1[i];
            i++;
            t++;
        }

        //nums2未处理完
        while (j < n){
            tempArr[t]  = nums2[j];
            j++;
            t++;
        }

        nums1 = tempArr;
        return nums1;
    }

//    public void merge(int[] nums1, int m, int[] nums2, int n) {
//        /*
//         * 第一个参数是要被复制的数组
//         * 第二个参数是被复制的数字开始复制的下标
//         * 第三个参数是目标数组，也就是要把数据放进来的数组
//         * 第四个参数是从目标数据第几个下标开始放入数据
//         * 第五个参数表示从被复制的数组中拿几个数值放到目标数组中
//         */
//        System.arraycopy(nums2, 0, nums1, m, n);
//        Arrays.sort(nums1);
//    }
}
