package site.pushy.algorithms.leetcode.problemset._278_First_Bad_Version;

/**
 * @author Pushy
 * @since 2019/4/26 9:38
 */
public class Solution extends VersionControl {

    public int firstBadVersion(int n) {
        int l = 1, r = n;

        while (l < r) {
            int mid = l + (r - l) / 2;
            if (isBadVersion(mid)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        // left = right
        return l;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int res = solution.firstBadVersion(5);
        System.out.println("res：" + res);
    }

}