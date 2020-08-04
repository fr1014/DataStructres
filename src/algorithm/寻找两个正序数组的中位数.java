package algorithm;

public class 寻找两个正序数组的中位数 {

    public static void main(String[] args) {
        int[] nums1 = {1,2};
        int[] nums2 = {3,4};
        new 寻找两个正序数组的中位数().findMedianSortedArrays(nums1,nums2);
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int r1 = nums1.length;
        int r2 = nums2.length;
        int sum = r1 + r2;
        int mid = sum / 2;

        int[] temp = new int[r1 + r2];
        int i = 0,j = 0,t = 0;

        while(i < r1 && j < r2){
            if(nums1[i] < nums2[j]){
                temp[t] = nums1[i];
                i++;
            }else{
                temp[t] = nums2[j];
                j++;
            }
            t++;
        }

        while(i < r1){
            temp[t] = nums1[i];
            i++;
            t++;
        }

        while(j < r2){
            temp[t] = nums2[j];
            j++;
            t++;
        }

        if(sum % 2 == 0){
            return (temp[mid - 1] + temp[mid]) / 2.0;
        }else{
            return temp[mid];
        }

    }
}
