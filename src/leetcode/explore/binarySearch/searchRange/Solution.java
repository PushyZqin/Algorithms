package leetcode.explore.binarySearch.searchRange;

import java.util.Arrays;

/**
 * @author Pushy
 * @since 2019/4/26 16:22
 */
public class Solution {

    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) return new int[]{-1, -1};
        if (nums.length == 1) {
            if (nums[0] == target) return new int[]{0, 0};
            else return new int[]{-1, -1};
        }

        int l = 0, r = nums.length - 1;
        while (l + 1 < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] < target) l = mid;
            else if (nums[mid] > target) r = mid;
            else {
                l = mid;
                r = mid;
                break;
            }
        }

        while (l >= 0 && nums[l] == target) l--;
        while (r < nums.length && nums[r] == target) r++;
        l++;
        r--;

        if (nums[l] == target && nums[r] == target) return new int[]{l, r};
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] res = solution.searchRange(new int[]{1, 2, 3}, 2);
        System.out.println("res：" + Arrays.toString(res));
    }

}