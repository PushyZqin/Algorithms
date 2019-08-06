package leetcode.problemset._9_Palindrome_Number;

import java.util.*;

/**
 * @author Pushy
 * @since 2019/4/12 21:45
 */
public class Solution {

    public boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        List<Integer> list = new ArrayList<>();
        for (; x != 0; x /= 10) {
            list.add(x % 10);
        }

        int n = list.size();
        for (int i = 0; i < n / 2; i++) {
            if (!list.get(i).equals(list.get(n - 1 - i))) {
                return false;
            }
        }
        return true;
    }

    public boolean isPalindrome2(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        int rn = 0;
        while (x > rn) {
            rn = rn * 10 + x % 10;
            x /= 10;
        }
        System.out.println("rn => " + rn);
        System.out.println("x  => " + x);
        return x == rn || x == rn / 10;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        boolean res = solution.isPalindrome2(45654);
        System.out.println("res：" + res);
    }

}