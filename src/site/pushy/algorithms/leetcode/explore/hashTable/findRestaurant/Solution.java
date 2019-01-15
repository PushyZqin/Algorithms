package site.pushy.algorithms.leetcode.explore.hashTable.findRestaurant;

import java.util.*;

/**
 * @author Pushy
 * @since 2019/1/15 16:48
 */
public class Solution {

    public String[] findRestaurant(String[] list1, String[] list2) {
        int minIdx = Integer.MAX_VALUE;
        Map<String, Integer> map = new HashMap<>();
        List<String> res = new LinkedList<>();

        for (int i = 0; i < list1.length; i++) {
            map.put(list1[i], i);
        }

        for (int i = 0; i < list2.length; i++) {
            if (i > minIdx) break;             // 后面的索引会更大，直接跳出循环
            if (map.containsKey(list2[i])) {   // 元素相等
                int curIdx = map.get(list2[i]) + i;
                if (curIdx < minIdx) {
                    minIdx = curIdx;
                    res.clear();
                }
                if (curIdx == minIdx) {
                    res.add(list2[i]);
                }
            }
        }

        String[] strings = new String[res.size()];
        return res.toArray(strings);
    }

    public static void main(String[] args) {
        String[] list1 = {"Shogun", "Tapioca Express", "Burger King", "KFC"};
        String[] list2 = {"KFC", "Shogun", "Burger King"};

        Solution solution = new Solution();
        String[] res = solution.findRestaurant(list1, list2);
        System.out.println("res：" + Arrays.toString(res));
    }

}