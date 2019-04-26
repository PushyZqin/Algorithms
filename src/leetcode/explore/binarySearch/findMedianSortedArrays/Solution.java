package site.pushy.algorithms.leetcode.explore.binarySearch.findMedianSortedArrays;

import java.util.*;

/**
 * @author Pushy
 * @since 2019/1/26 11:13
 */
public class Solution {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] nums = contactAndSort(nums1, nums2);
        int n = nums.length;

        if (n % 2 == 0) {
            double sum = nums[n / 2] + nums[n / 2 - 1];
            return sum / 2;
        } else {
            return nums[n / 2];
        }
    }

    /**
     * 合并两个数组并对新数组排序
     */
    public int[] contactAndSort(int[] nums1, int[] nums2) {
        int[] nums = new int[nums1.length + nums2.length];
        for (int i = 0; i < nums1.length; i++)
            nums[i] = nums1[i];
        for (int i = 0; i < nums2.length; i++)
            nums[i + nums1.length] = nums2[i];

        Arrays.sort(nums);
        return nums;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 3};
        int[] nums2 = {2};

        Solution solution = new Solution();
        double res = solution.findMedianSortedArrays(nums1, nums2);
        System.out.println("res：" + res);
    }

}