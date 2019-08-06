package leetcode.problemset._70_Climbing_Stairs;

import java.util.*;

/**
 * @author Pushy
 * @since 2019/4/27 20:27
 */
public class Solution {

    public int climbStairs(int n) {
        return climbStairs(0, n);
    }

    public int climbStairs(int i, int n) {
        if (i > n) return 0;
        if (i == n) return 1;

        return climbStairs(i + 1, n) + climbStairs(i + 2, n);
    }


    /* ------------------- 备忘录算法 ------------------- */

    /**
     * 借助一个哈希表来存储重复分支的值
     */
    public int climbStair2(int n) {
        Map<Integer, Integer> map = new HashMap<>();
        return climbStairs2(n, map);
    }

    private int climbStairs2(int n, Map<Integer, Integer> map) {
        if (n < 1) return 0;
        if (n == 1) return 1;
        if (n == 2) return 2;

        if (map.containsKey(n)) {
            return map.get(n);
        } else {
            int val = climbStairs2(n - 1, map) + climbStairs2(n - 2, map);
            map.put(n, val);
            return val;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int res = solution.climbStair2(3);
        System.out.println("res：" + res);
    }

}