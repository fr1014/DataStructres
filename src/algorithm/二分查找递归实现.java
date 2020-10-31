package algorithm;

public class 二分查找递归实现 {

    public static void main(String[] args) {
        int[] arr = {-1,0,3,5,9,12};
        System.out.println(search(arr,9));
    }

    public static int search(int[] nums, int target) {
        return searchTarget(nums, 0, nums.length - 1, target);
    }

    public static int searchTarget(int[] nums, int start, int end, int target) {
        int mid = (end + start) / 2;
        if (nums[mid] == target) {
            return mid;
        }

        if (start > end) {
            return -1;
        } else if (nums[mid] < target) {
            return searchTarget(nums, mid + 1, end, target);
        } else if (nums[mid] > target) {
            return searchTarget(nums, start, mid - 1, target);
        }

        return -1;
    }

}
