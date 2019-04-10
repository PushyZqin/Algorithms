package site.pushy.algorithms.leetcode.explore.array.plusOne;

import java.util.Arrays;

/**
 * @author Pushy
 * @since 2018/12/30 12:15
 */
public class Solution2 {

    public int[] plusOne(int[] digits) {
        digits[digits.length - 1]++;
        if (digits[digits.length - 1] > 9) {
            int j = digits.length - 1;
            while (j > 0 && digits[j] > 9) {
                digits[j] -= 10;
                j--;
                digits[j]++;
            }
        }
        // [10, 0, 0]
        if (digits[0] > 9) {
            int[] res = new int[digits.length + 1];
            res[0] = 1;
            res[1] = digits[0] - 10;
            System.arraycopy(digits, 1, res, 2, digits.length - 1);
            return res;
        }
        return digits;
    }

    public static void main(String[] args) {
        int[] digits = {9, 9, 9};
        Solution2 solution = new Solution2();
        int[] res = solution.plusOne(digits);
        System.out.println("res：" + Arrays.toString(res));
    }

}