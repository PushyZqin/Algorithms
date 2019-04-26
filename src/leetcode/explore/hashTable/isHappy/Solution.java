package site.pushy.algorithms.leetcode.explore.hashTable.isHappy;

import java.util.*;

/**
 * @author Pushy
 * @since 2019/1/14 21:21
 */
public class Solution {

    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        set.add(n);

        while (n != 1) {
            n = getSquare(n);
            if (set.contains(n)) {
                return false;
            }
            set.add(n);
        }
        return true;
    }


    private int getSquare(int num) {
        int res = 0;
        while (num > 0) {
            res += Math.pow(num % 10, 2);
            num /= 10;
        }
        return res;
    }

    public static void main(String[] args) {
        int n = 19;

        Solution solution = new Solution();
        boolean res = solution.isHappy(n);
        System.out.println("res：" + res);
    }

}