package site.pushy.algorithms.leetcode.problemset._849_Maximize_Distance_to_Closest_Person;

import java.util.*;

/**
 * @author Pushy
 * @since 2019/4/12 9:47
 */
public class Solution {

    public int maxDistToClosest(int[] seats) {
//        int res = -1;
//        int left = 0, right = 0;
//        while (right < seats.length) {
//            if (seats[right] == 1 && right > 0) {
//                int temp = right;
//                while (right - left != temp - right) {
//                    right--;
//                }
//                int s = right - left;
//                res = Math.max(s, res);
//                right = temp + 1;
//                left = temp;
//            } else {
//                right++;
//            }
//        }
//        return res != -1 ? res : right - left - 1;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < seats.length; i++) {
            if (seats[i] == 1) list.add(i);
        }

        int start = list.get(0);
        int end = seats.length - list.get(list.size() - 1) - 1;
        int max = Math.max(start, end);

        for (int i = 0; i < list.size() - 1; i++) {
            int temp = (list.get(i + 1) - list.get(i)) / 2;
            max = Math.max(temp, max);
        }
        return max;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int res = solution.maxDistToClosest(new int[]{1, 0, 0, 0});
        System.out.println("res：" + res);
    }

}