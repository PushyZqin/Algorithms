package site.pushy.algorithms.leetcode.explore.binarySearch.findClosestElements;

import java.util.*;

/**
 * @author Pushy
 * @since 2019/1/20 17:39
 */
public class Solution {

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> res = new ArrayList<>();
        // Todo 找到 K 个最接近的元素
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {6, 7, 8, 9, 10};
        int k = 4;
        int x = 8;

        Solution solution = new Solution();
        List<Integer> res = solution.findClosestElements(arr, k, x);
        System.out.println("res：" + res);
    }

}