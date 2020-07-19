package algorithm;

import java.util.HashMap;
import java.util.Map;

public class 两数之和 {

    public static void main(String[] args) {
//        int[] nums = {2, 7, 11, 15};
//        int[] r = new 两数之和().twoSum(nums, 9);
        int[] nums = {2, 5, 3, 4};
        int[] r = new 两数之和().twoSum3(nums, 5);
        for (int i : r) {
            System.out.println(i);
        }
    }

    /**
     * 暴力法
     * 时间复杂度: O(n^2)
     *
     * @param nums   完整数组(乱序)
     * @param target 目标值
     * @return 两个整数的数组下标
     */
    public int[] twoSum(int[] nums, int target) {

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target && i != j) {
                    return new int[]{i, j};
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    /**
     * 两遍哈希表
     * 时间复杂度: O(n)
     */
    public int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        //第一次迭代将每个元素的值和其索引添加到表中
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
//        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
//            System.out.println(entry.getKey() + ": " + entry.getValue());
//        }
        //第二次迭代，检查每个元素对应的目标元素(target - nums[i])是否存在于表中。注：该元素对应的非nums[i]本身
        //map.containsKey(complement) && map.get(complement) != i  解决了nums中含有相同值的情况
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i) {
                return new int[]{i, map.get(complement)};
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    /**
     * 一遍哈希表
     * 时间复杂度: O(n)
     */
    public int[] twoSum3(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
