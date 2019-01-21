package site.pushy.algorithms.leetcode.explore.binarySearch.guessNumber;

/**
 * @author Pushy
 * @since 2019/1/19 11:42
 */
public class Solution extends GuessGame {

    public int guessNumber(int n) {
        int l = 0, r = n;

        while (l <= r) {
            int mid = l + (r - l) / 2;
            int ans = guess(mid);
            if (ans == 1)        // 比选择的数小了，向右查找
                l = mid + 1;
            else if (ans == -1)  // 比选择的数大了，向左查找
                r = mid - 1;
            else
                return mid;
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int res = solution.guessNumber(10);

        System.out.println(res);
    }


}
