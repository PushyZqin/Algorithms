package leetcode.problemset._46_Permutations;

import java.util.*;

/**
 * @author Pushy
 * @since 2019/7/15 15:42
 */
public class Solution {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        permute(nums, 0, res);
        return res;
    }

    private void permute(int[] nums, int start, List<List<Integer>> res) {
        if (start == nums.length - 1) {
            List<Integer> list = new ArrayList<>();
            for (int num : nums) list.add(num);
            res.add(list);
        }
        else {
            for (int i = start; i < nums.length; i++) {
                swap(nums, start, i);
                permute(nums, start + 1, res);
                swap(nums, start, i);  // 回溯，通过swap进行还原
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<Integer>> res = solution.permute(new int[]{1, 2, 3});
        System.out.println("res：" + res);
    }
}