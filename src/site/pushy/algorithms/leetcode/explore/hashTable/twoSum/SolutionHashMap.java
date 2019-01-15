package site.pushy.algorithms.leetcode.explore.hashTable.twoSum;

import java.util.*;

/**
 * 通过哈希表来维护数组中元素和索引的对应关系
 *
 * @author Pushy
 * @since 2019/1/15 16:18
 */
public class SolutionHashMap {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        /* 将数组中的下标索引和值的对应存储到哈希表中 */
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];   // 符合相加条件的元素值
            if (map.containsKey(complement) && map.get(complement) != i) {
                return new int[]{i, map.get(complement)};
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;

        SolutionHashMap solution = new SolutionHashMap();
        int[] res = solution.twoSum(nums, target);
        System.out.println("res：" + Arrays.toString(res));
    }

}
