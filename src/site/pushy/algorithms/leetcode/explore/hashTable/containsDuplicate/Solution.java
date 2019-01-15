package site.pushy.algorithms.leetcode.explore.hashTable.containsDuplicate;

import java.util.*;

/**
 * @author Pushy
 * @since 2019/1/14 20:47
 */
public class Solution {

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                return true;
            }
            set.add(nums[i]);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};

        Solution solution = new Solution();
        boolean res = solution.containsDuplicate(nums);
        System.out.println("res：" + res);
    }

}