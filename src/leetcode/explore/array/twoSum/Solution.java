package site.pushy.algorithms.leetcode.explore.array.twoSum;

import java.util.*;

/**
 * 我自己写的垃圾算法，执行时间 160ms+
 *
 * @author Pushy
 * @since 2019/1/1 19:36
 */
public class Solution {

    public int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];

        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] + numbers[j] == target) {
                    res[0] = i + 1;
                    res[1] = j + 1;
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] numbers = {2, 7, 11, 15};
        int target = 9;

        Solution solution = new Solution();
        int[] res = solution.twoSum(numbers, target);
        System.out.println("res：" + Arrays.toString(res));
    }

}