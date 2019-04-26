package site.pushy.algorithms.leetcode.problemset._33_Search_in_Rotated_Sorted_Array;

/**
 * @author Pushy
 * @since 2019/4/25 11:04
 */
public class Solution {

    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;

        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (nums[mid] == target) return mid;

            if (nums[mid] < nums[r]) { // 判断mid右边区间是单调递增的吗
                if (nums[mid] < target && target <= nums[r]) l = mid + 1;
                else r = mid - 1;
            }

            else {  // 右边区间不是单调的
                if (nums[mid] > target && target >= nums[l]) r = mid - 1;
                else l = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int res = solution.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0);
        System.out.println("res：" + res);
    }

}