package site.pushy.algorithms.leetcode.explore.hashTable.containsNearbyDuplicate;

import java.util.*;

/**
 * @author Pushy
 * @since 2019/1/17 10:21
 */
public class Solution {

    /**
     * 暴力求解
     */
//    public boolean containsNearbyDuplicate(int[] nums, int k) {
//        for (int i = 0; i < nums.length; i++) {
//            for (int j = 0; j < nums.length; j++) {
//                if (i != j && nums[i] == nums[j]) {
//                    if (Math.abs(i - j) <= k) {
//                        return true;
//                    }
//                }
//            }
//        }
//        return false;
//    }

    /**
     * 使用HashMap来替代双循环，能够大幅度的提升算法的速度
     */
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            /* 只要存在大于K的即可，因此限定的判断条件为 <= k */
            if (map.containsKey(nums[i]) && i - map.get(nums[i]) <= k) {
                return true;
            }
            map.put(nums[i], i);
        }

        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        int k = 3;

        Solution solution = new Solution();
        boolean res = solution.containsNearbyDuplicate(nums, k);
        System.out.println("res：" + res);
    }

}