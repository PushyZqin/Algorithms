package site.pushy.algorithms.leetcode.explore.array.moveZeroes;

import java.util.*;

/**
 * @author Pushy
 * @since 2019/1/2 21:10
 */
public class Solution {

    /**
     * 通过两个指针来实现
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        int curIndex = nums.length - 1;  // 快指针
        int lastIndex = nums.length - 1; // 慢指针
        int count;

        while (curIndex >= 0) {
            if (nums[curIndex] == 0) {
                count = lastIndex - curIndex;
                /* 根据lastIndex与curIndex之间的差值，将元素前移 */
                for (int i = 0; i < count; i++) {
                    nums[curIndex + i] = nums[curIndex + i + 1];
                }
                /* 然后再将零放在最后的所有的零最前的一个位置，即慢指针lastIndex指向的位置 */
                nums[lastIndex] = 0;
                lastIndex--;
            }
            curIndex--;
        }
    }

    public static void main(String[] args) {
        int[] nums = {0, 0, 1};

        Solution solution = new Solution();
        solution.moveZeroes(nums);

        System.out.println(Arrays.toString(nums));
    }

}