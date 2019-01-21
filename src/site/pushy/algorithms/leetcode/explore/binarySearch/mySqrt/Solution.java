package site.pushy.algorithms.leetcode.explore.binarySearch.mySqrt;

/**
 * @author Pushy
 * @since 2019/1/19 11:16
 */
public class Solution {

    public int mySqrt(int x) {
        if (x == 0) return 0;
        int left = 1, right = x, ans = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (mid <= x / mid) {
                left = mid + 1;
                ans = mid;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int x = 8;

        Solution solution = new Solution();
        int res = solution.mySqrt(x);
        System.out.println("res：" + res);
    }

}