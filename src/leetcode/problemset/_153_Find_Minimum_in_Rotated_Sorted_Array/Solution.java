package leetcode.problemset._153_Find_Minimum_in_Rotated_Sorted_Array;

/**
 * @author Pushy
 * @since 2019/4/26 11:01
 */
public class Solution {

    public int findMin(int[] nums) {
        int mix = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < mix) mix = nums[i];
        }
        return mix;
    }

    public int findMin2(int[] nums) {
        int l = 0, r = nums.length - 1;

        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] > nums[r]) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return nums[l];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int res = solution.findMin2(new int[]{4, 5, 6, 7, 0, 1, 2});
        System.out.println("res：" + res);
    }

}