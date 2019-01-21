package site.pushy.algorithms.leetcode.explore.binarySearch.findPeakElement;

/**
 * @author Pushy
 * @since 2019/1/19 19:33
 */
public class Solution {

    /**
     * 二分查找的高级用法，终止条件为left == right，向右查找为 r = mid
     */
    public int findPeakElement(int[] nums) {
        if (nums == null || nums.length == 0) return -1;

        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] < nums[mid + 1]) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        // while left == right
        return l;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};

        Solution solution = new Solution();
        int res = solution.findPeakElement(nums);
        System.out.println("res：" + res);
    }

}