package site.pushy.algorithms.leetcode.explore.hashTable.topKFrequent;

import java.util.*;

/**
 * @author Pushy
 * @since 2019/4/23 9:59
 */
public class Solution {

    /**
     * 使用集合自带的排序
     */
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> res = new ArrayList<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        List<Map.Entry<Integer, Integer>> entries = new ArrayList<>(map.entrySet());
        entries.sort((o1, o2) -> (o2.getValue() - o1.getValue()));

        int i = k;
        for (Map.Entry<Integer, Integer> entry : entries) {
            if (i == 0) break;
            res.add(entry.getKey());
            i--;
        }
        return res;
    }

    /**
     * 使用集合中的优先队列进行排序
     */
    public List<Integer> topKFrequent2(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> res = new ArrayList<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });
        pq.addAll(map.entrySet());

        for (int i = 0; i < k; i++) {
            res.add(pq.poll().getKey());
        }
        return res;
    }

    public List<Integer> topKFrequent3(int[] nums, int k) {
        List<Integer>[] bucket = new ArrayList[nums.length + 1];
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        System.out.println(map);

        for (int n : map.keySet()) {
            int frequency = map.get(n);
            if (bucket[frequency] == null) { // 初始化
                List<Integer> list = new ArrayList<>();
                bucket[frequency] = list;
            }
            bucket[frequency].add(n);
        }

        System.out.println(Arrays.toString(bucket));

        List<Integer> res = new ArrayList<>();
        for (int i = nums.length; i >= 0 && res.size() < k; i--) {
            if (bucket[i] != null) {
                res.addAll(bucket[i]);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<Integer> res = solution.topKFrequent3(new int[]{1, 1, 1, 2, 2, 3}, 2);
        System.out.println("res：" + res);
    }

}