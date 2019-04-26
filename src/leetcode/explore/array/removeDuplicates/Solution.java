package site.pushy.algorithms.leetcode.explore.array.removeDuplicates;

import java.util.Arrays;

/**
 * @author Pushy
 * @since 2019/1/2 21:05
 */
public class Solution {

    /**
     * 同样是通过快慢双指针来实现
     */
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int j = 0;  // 慢指针

        for (int i = 0; i < nums.length; i++) {  // i为快指针，用于迭代
            if (nums[j] != nums[i]) {
                j++;
                nums[j] = nums[i];
            }
        }

        return j + 1;
    }

    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};

        Solution solution = new Solution();
        int res = solution.removeDuplicates(nums);
        System.out.println("res：" + res);
        System.out.println("nums：" + Arrays.toString(nums));

    }

}