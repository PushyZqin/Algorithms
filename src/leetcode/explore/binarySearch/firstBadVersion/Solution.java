package site.pushy.algorithms.leetcode.explore.binarySearch.firstBadVersion;

/**
 * @author Pushy
 * @since 2019/1/19 19:04
 */
public class Solution extends VersionControl {

    /**
     * 这题需要注意的条件是：由于每个版本都是基于之前的版本开发的，所以错误的版本之后的所有版本都是错的
     * 因此某个情况为：false false false true true
     */
    public int firstBadVersion(int n) {
        int l = 0;
        int r = n;

        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (isBadVersion(mid))  // 当isBadVersion为true，往左查找第一个出现的错误版本
                r = mid - 1;
            else  // 当isBadVersion为false时，继续向右查找到某个错误版本
                l = mid + 1;
        }
        return l;
    }

    public static void main(String[] args) {
        int n = 5;

        Solution solution = new Solution();
        int res = solution.firstBadVersion(n);
        System.out.println("res：" + res);
    }

}