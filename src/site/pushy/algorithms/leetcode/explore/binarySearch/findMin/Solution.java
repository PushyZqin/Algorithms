package site.pushy.algorithms.leetcode.explore.binarySearch.findMin;

/**
 * @author Pushy
 * @since 2019/1/20 11:05
 */
public class Solution {

    public int findMin(int[] nums) {
        int l = 0, r = nums.length - 1;
        int target = nums[nums.length - 1];

        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] <= target)
                r = mid;
            else
                l = mid + 1;
        }

        return Math.min(nums[l], nums[r]);
    }

    public static void main(String[] args) {
        int[] nums = {3, 4, 5, 1, 2};

        Solution solution = new Solution();
        int res = solution.findMin(nums);
        System.out.println("res：" + res);
    }

}