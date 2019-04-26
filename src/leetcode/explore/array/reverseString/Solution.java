package site.pushy.algorithms.leetcode.explore.array.reverseString;

import java.util.*;

/**
 * @author Pushy
 * @since 2019/4/10 15:23
 */
public class Solution {

    public void reverseString(char[] s) {
        int i = 0;
        int j = s.length - 1;
        while (i < j) {
            char temp = s[i];
            s[i++] = s[j];
            s[j--] = temp;
        }
    }

    public static void main(String[] args) {
        char[] s = {'h', 'e', 'l', 'l', 'o'};

        Solution solution = new Solution();
        solution.reverseString(s);

        System.out.println(Arrays.toString(s));
    }

}