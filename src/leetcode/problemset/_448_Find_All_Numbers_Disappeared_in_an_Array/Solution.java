package site.pushy.algorithms.leetcode.problemset._448_Find_All_Numbers_Disappeared_in_an_Array;

import java.util.*;

/**
 * @author Pushy
 * @since 2019/4/11 21:22
 */
public class Solution {

    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int[] count = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            count[nums[i] - 1]++;
        }
        for (int i = 0; i < nums.length; i++) {
            if (count[i] == 0) list.add(i + 1);
        }
        System.out.println("count => " + Arrays.toString(count));
        return list;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<Integer> res = solution.findDisappearedNumbers(new int[]{4, 3, 2, 7, 8, 2, 3, 1});
        System.out.println("res：" + res);
    }

}