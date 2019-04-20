package site.pushy.algorithms.leetcode.explore.hashTable.twoSum;

import java.util.*;

/**
 * @author Pushy
 * @since 2019/1/14 21:27
 */
public class Solution {

    public int[] twoSum(int[] nums, int target) {
        List<Integer> list = new LinkedList<>();
        for (int num : nums) list.add(num);

        Arrays.sort(nums);

        int head = 0;
        int rail = nums.length - 1;

        while (true) {
            int sum = nums[head] + nums[rail];
            if (sum < target) {
                head++;
            } else if (sum > target) {
                rail--;
            } else {
                int[] res = new int[2];
                for (int i = 0; i < list.size(); i++) {
                    if (nums[head] == list.get(i)) {
                        res[0] = i;
                        break;
                    }
                }
                for (int i = list.size() - 1; i > 0; i--) {
                    if (nums[rail] == list.get(i)) {
                        res[1] = i;
                        break;
                    }
                }
                return res;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {3, 3};
        int target = 6;

        Solution solution = new Solution();
        int[] res = solution.twoSum(nums, target);
        System.out.println("res：" + Arrays.toString(res));
    }

}