package site.pushy.algorithms.leetcode.explore.hashTable.intersection;

import java.util.*;

/**
 * @author Pushy
 * @since 2019/1/14 21:08
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
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};

        Solution solution = new Solution();
        int[] res = solution.intersection(nums1, nums2);
        System.out.println("res：" + Arrays.toString(res));
    }

}