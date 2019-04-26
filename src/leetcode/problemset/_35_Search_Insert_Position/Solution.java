package site.pushy.algorithms.leetcode.problemset._35_Search_Insert_Position;

/**
 * @author Pushy
 * @since 2019/4/11 12:20
 */
public class Solution {

    public int searchInsert(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= target) {
                return i;
            }
        }
        // 说明数组中没有比目标值大的数，因此只能放到最后
        return nums.length;
    }

    /**
     * 二分法
     */
    public int searchInsert2(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] == target) return mid;
            else if (nums[mid] > target) end = mid - 1;
            else start = mid + 1;
        }
        return start;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int res = solution.searchInsert2(new int[]{1, 3, 5, 6}, 7);
        System.out.println("res：" + res);
    }

}