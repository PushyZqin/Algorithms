package site.pushy.algorithms.leetcode.explore.binarySearch.searchRange;

import java.util.Arrays;

/**
 * @author Pushy
 * @since 2019/1/20 17:04
 */
public class Solution {

    /**
     * 先用二分查找找到目标值，以这个位置为基准
     * 向左寻找第一个目标值的位置，向右寻找最后一个目标值的位置
     */
    public int[] searchRange(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int[] res = {-1, -1};

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                left = mid;
                right = mid;
                // 循环直到 nums[left] != target，那么left + 1则第一个出现的元素
                while (left >= 0 && nums[left] == target)
                    left--;
                res[0] = left + 1;

                // 循环直到 nums[right] != target，那么right + 1则第一个出现的元素
                while (right < nums.length && nums[right] == target)
                    right++;
                res[1] = right - 1;

                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 6;

        Solution solution = new Solution();
        int[] res = solution.searchRange(nums, target);
        System.out.println("res：" + Arrays.toString(res));
    }

}