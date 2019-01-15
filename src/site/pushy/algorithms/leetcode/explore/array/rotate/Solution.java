package site.pushy.algorithms.leetcode.explore.array.rotate;

import java.util.Arrays;

/**
 * @author Pushy
 * @since 2019/1/2 10:47
 */
public class Solution {

    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k %= n;
        for (int i = 0; i < k; i++) {
            int temp = nums[n - 1];
            for (int j = n - 1; j > 0; j--) {
                nums[j] = nums[j - 1];
            }
            nums[0] = temp;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int k = 2;

        Solution solution = new Solution();
        solution.rotate(nums, k);

        System.out.println(Arrays.toString(nums));
    }

}