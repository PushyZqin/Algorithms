package site.pushy.algorithms.leetcode.problemset._704_Binary_Search;

/**
 * @author Pushy
 * @since 2019/4/25 9:59
 */
public class Solution {

    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;

        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target)
                left = mid + 1;
            else if (nums[mid] > target)
                right = mid - 1;
            else
                return mid;
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int res = solution.search(new int[]{5}, 5);
        System.out.println("res：" + res);
    }

}