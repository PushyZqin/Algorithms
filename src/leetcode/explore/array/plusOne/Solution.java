package leetcode.explore.array.plusOne;

import java.util.Arrays;

/**
 * @author Pushy
 * @since 2018/12/30 12:15
 */
public class Solution {

    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                ++digits[i];
                return digits;
            }
            digits[i] = 0;
        }

        /* 处理类似 999 的情况，因为整形数组所有的值默认为0，将数组首位设置为1后，该数组的值为1000 */
        int[] newDigits = new int[digits.length + 1];
        newDigits[0] = 1;
        return newDigits;
    }

    public static void main(String[] args) {
//        int[] digits = {9, 9, 9};
        int[] digits = {1, 2, 3, 9};

        Solution solution = new Solution();
        int[] res = solution.plusOne(digits);
        System.out.println("res：" + Arrays.toString(res));
    }

}