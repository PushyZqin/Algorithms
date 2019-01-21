package site.pushy.algorithms.leetcode.explore.binarySearch.search;

/**
 * @author Pushy
 * @since 2019/1/19 11:01
 */
public class Solution {

    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;

        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > target)
                right = mid - 1;  // 向左查找
            else if (nums[mid] < target)
                left = mid + 1;   // 向右查找
            else  // nums[mid] == target
                return mid;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {5};
        int target = 5;

        Solution solution = new Solution();
        int res = solution.search(nums, target);
        System.out.println("res：" + res);
    }

}