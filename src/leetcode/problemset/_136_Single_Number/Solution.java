package site.pushy.algorithms.leetcode.problemset._136_Single_Number;

import java.util.*;

/**
 * @author Pushy
 * @since 2019/4/20 18:11
 */
public class Solution {

    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return -1;
    }

    public int singleNumber2(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i += 2) {
            if (nums[i] != nums[i - 1]) {
                return nums[i - 1];
            }
        }
        return nums[nums.length - 1];
    }

    public int singleNumber3(int[] nums) {
        int res = 0;
        for (int n : nums) {
            res ^= n;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int res = solution.singleNumber3(new int[]{4, 1, 2, 1, 2});
        System.out.println("res：" + res);
    }

}