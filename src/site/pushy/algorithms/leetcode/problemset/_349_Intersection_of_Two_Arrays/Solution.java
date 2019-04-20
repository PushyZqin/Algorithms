package site.pushy.algorithms.leetcode.problemset._349_Intersection_of_Two_Arrays;

import java.util.*;

/**
 * @author Pushy
 * @since 2019/4/20 19:01
 */
public class Solution {

    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        for (int num : nums1) set1.add(num);
        for (int num : nums2) set2.add(num);

        List<Integer> res = new LinkedList<>();
        for (Integer num : set1) {
            if (set2.contains(num)) {
                res.add(num);
            }
        }

        int[] arr = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            arr[i] = res.get(i);
        }
        return arr;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] res = solution.intersection(new int[]{1, 2, 2, 1}, new int[]{2, 2});
        System.out.println("res：" + Arrays.toString(res));
    }

}