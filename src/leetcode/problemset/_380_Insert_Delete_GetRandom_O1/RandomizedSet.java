package site.pushy.algorithms.leetcode.problemset._380_Insert_Delete_GetRandom_O1;

import java.util.*;

/**
 * @author Pushy
 * @since 2019/4/23 11:19
 */
public class RandomizedSet {

    private Map<Integer, Integer> map;
    private List<Integer> list;
    int size;
    Random rand;

    /** Initialize your data structure here. */
    public RandomizedSet() {
        map = new HashMap<>();
        list = new ArrayList<>();
        size = 0;
        rand = new Random();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (map.containsKey(val) ) return false;

        map.put(val, size);
        list.add(val);
        size++;
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!map.containsKey(val)) return false;

        int last = list.get(size - 1);
        list.set(map.get(val), last);

        map.put(last, map.get(val));
        map.remove(val);

        list.remove(size - 1);
        size--;

        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        return list.get(rand.nextInt(size));
    }

}
