package site.pushy.algorithms.leetcode.explore.binarySearch.isPerfectSquare;

/**
 * @author Pushy
 * @since 2019/1/21 15:02
 */
public class Solution {

    /**
     * 这里需要注意一点是，当num值很大的时候，mid * mid的值可能是比int最大值还大的，所以要使用Long
     */
    public boolean isPerfectSquare(int num) {
        long l = 1, r = num;

        while (l <= r) {
            long mid = l + (r - l) / 2;
            long prod = mid * mid;
            if (prod < num)
                l = mid + 1;
            else if (prod > num)
                r = mid - 1;
            else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] testNums = {16, 15, 9, 2147483647};

        Solution solution = new Solution();

        for (int num : testNums) {
            boolean res = solution.isPerfectSquare(num);
            System.out.println(num + " res：" + res);
        }
    }

}