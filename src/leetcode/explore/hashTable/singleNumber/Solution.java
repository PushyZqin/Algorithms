package site.pushy.algorithms.leetcode.explore.hashTable.singleNumber;

import java.util.*;

/**
 * @author Pushy
 * @since 2019/1/14 20:50
 */
public class Solution {

    public int singleNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                set.remove(nums[i]);
            } else {
                set.add(nums[i]);
            }
        }
        return set.iterator().next();
    }

    /**
     * 通过位操作抵消相同的元素
     */
//    public int singleNumber(int[] nums) {
//        int result = 0;
//        for(int i = 0; i < nums.length; i++){
//            result ^= nums[i];
//        }
//        return result;
//    }

    public static void main(String[] args) {
        int[] nums = {4, 1, 2, 1, 2};

        Solution solution = new Solution();
        int res = solution.singleNumber(nums);
        System.out.println("res：" + res);
    }

}