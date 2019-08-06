package leetcode.problemset._217_Contains_Duplicate;

import java.util.*;

/**
 * @author Pushy
 * @since 2019/4/20 12:16
 */
public class Solution {

    /**
     * 执行用时 : 23 ms, 在Contains Duplicate的Java提交中击败了49.32% 的用户
     */
    public boolean containsDuplicate(int[] nums) {
        if (nums == null || nums.length == 0) return false;

        Set<Integer> set = new HashSet<>();
        for (int num : nums) set.add(num);

        return set.size() != nums.length;
    }

    /**
     * 执行用时 : 13 ms, 在Contains Duplicate的Java提交中击败了70.26% 的用户
     */
    public boolean containsDuplicate2(int[] nums) {
        if (nums.length < 2) return false;

        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) return true;
            else
                set.add(num);
        }
        return false;
    }

    public boolean containsDuplicate3(int[] nums) {
        if (nums.length < 2) return false;

        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
            } else if (nums[i] == max) {
                return true;
            } else {
                for (int j = i - 1; j >= 0; j--) {
                    if (nums[i] == nums[j]) return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        boolean res = solution.containsDuplicate2(new int[]{1, 2, 3, 1});
        System.out.println("res：" + res);
    }

}