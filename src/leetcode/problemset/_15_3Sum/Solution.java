package leetcode.problemset._15_3Sum;

import java.util.*;

/**
 * @author Pushy
 * @since 2019/7/15 9:53
 */
public class Solution {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) break;  // 如果一个数已经大于0，则三数之和一定大于0
            if (i > 0 && nums[i] == nums[i - 1]) continue;  // 去重，防止出现相同的结果

            int l = i + 1, r = nums.length - 1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (sum == 0) {
                    res.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    while (l < r && nums[l] == nums[l + 1]) l++;  // 去重
                    while (l < r && nums[r] == nums[r - 1]) r--;  // 去重
                    l++;
                    r--;
                } else if (sum > 0) {
                    while (l < r && nums[r] == nums[r - 1]) r--;  // 去重
                    r--;
                } else {
                    while (l < r && nums[l] == nums[l + 1]) l++;  // 去重
                    l++;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<Integer>> res = solution.threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        System.out.println("res：" + res);
    }
}