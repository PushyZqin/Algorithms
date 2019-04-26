package site.pushy.algorithms.leetcode.problemset._599_Minimum_Index_Sum_of_Two_Lists;

import java.util.*;

/**
 * @author Pushy
 * @since 2019/4/21 19:57
 */
public class Solution {

    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < list2.length; i++) {
            map.put(list2[i], i);
        }

        int min = Integer.MAX_VALUE;
        List<String> res = new ArrayList<>();
        for (int i = 0; i < list1.length; i++) {
            if (i > min) break;             // 后面的索引会更大，直接跳出循环
            if (map.containsKey(list1[i])) {
                int idx = map.get(list1[i]);
                if (min >= idx + i) {
                    min = idx + i;
                    res.add(list1[i]);
                }
            }
        }
        return res.toArray(new String[0]);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] res = solution.findRestaurant(
                new String[]{"Shogun", "Tapioca Express", "Burger King", "KFC"},
                new String[]{"KFC", "Burger King", "Tapioca Express", "Shogun"});
        System.out.println("res：" + Arrays.toString(res));
    }

}