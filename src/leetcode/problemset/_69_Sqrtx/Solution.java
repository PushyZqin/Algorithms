package leetcode.problemset._69_Sqrtx;

/**
 * @author Pushy
 * @since 2019/4/25 10:13
 */
public class Solution {

    public int mySqrt(int x) {
        if (x == 0 || x == 1) return x;
        int l = 0, r = x, res = -1;

//        while (l <= r) {
//            int mid = l + (r - l) / 2;
//            if (mid * mid <= x) {
//                l = mid + 1;
//                res = mid;
//            } else {
//                r = mid - 1;
//            }
//        }
//        return res;

        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (mid <= x / mid) {
                l = mid + 1;
                res = mid;
            } else {
                r = mid - 1;
            }
        }
        return res;
    }

    /**
     * 牛顿迭代法
     */
    public int mySqrt2(int x) {
        if (x <= 1) return x;

        double last = 0, res = 1;
        while (last != res) {
            last = res;
            res = (res + x / res) / 2;
        }
        return (int) res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int res = solution.mySqrt(18);
        System.out.println("res：" + res);
    }

}