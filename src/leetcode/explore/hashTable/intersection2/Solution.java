package site.pushy.algorithms.leetcode.explore.hashTable.intersection2;

import java.util.*;

/**
 * @author Pushy
 * @since 2019/4/21 21:31
 */
public class Solution {

    /**
     * 执行用时 : 9 ms, 在Intersection of Two Arrays II的Java提交中击败了46.86% 的用户
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums1) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        List<Integer> res = new ArrayList<>();
        for (int num : nums2) {
            if (map.containsKey(num) && map.get(num) != 0) {
                res.add(num);
                map.put(num, map.get(num) - 1);
            }
        }
        int[] arr = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            arr[i] = res.get(i);
        }
        return arr;
    }

    /**
     * 执行用时 : 4 ms, 在Intersection of Two Arrays II的Java提交中击败了93.11% 的用户
     */
    public int[] intersect2(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int i = 0, j = 0;
        int[] res = new int[nums2.length];
        int count = 0;  // 记录交集的元素个数

        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                res[count++] = nums1[i];
                i++;
                j++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                i++;
            }
        }
        return Arrays.copyOf(res, count);
    }

    public void test() {
        int[] arr = {2, 2, 0, 0, 0, 0};
        int[] res = Arrays.copyOf(arr, 2);
        System.out.println(Arrays.toString(res));

        int[] arr2 = {2, 2};
        int[] res2 = Arrays.copyOf(arr2, 5);
        System.out.println(Arrays.toString(res2));
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] res = solution.intersect2(new int[]{1, 2, 2, 1}, new int[]{2, 2, 3, 4});
        System.out.println("res：" + Arrays.toString(res));

//        solution.test();
    }

}