package site.pushy.algorithms.leetcode.problemset._496_nextGreaterElement;

import java.util.*;

/**
 * @author Pushy
 * @since 2019/4/7 9:57
 */
public class Solution {

    public int[] nextGreaterElement(int[] num1, int[] num2) {
        int[] res = new int[num1.length];
        Map<Integer, Integer> map = getMap(num2);

        for (int i = 0; i < num1.length; i++) {
            res[i] = map.getOrDefault(num1[i], -1);
        }
        return res;
    }

    /**
     * 遍历num2，通过辅助栈将num2中的每个元素下一个出现的最大元素存入哈希表中
     * 实现的方式和 <每日温度>(https://leetcode-cn.com/explore/learn/card/queue-stack/218/stack-last-in-first-out-data-structure/879/)类似
     * @param arr
     * @return
     */
    private Map<Integer, Integer> getMap(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[i] > stack.peek()) {
                int top = stack.pop();
                map.put(top, arr[i]);
            }
            stack.push(arr[i]);
        }
        return map;
    }

    public static void main(String[] args) {
        int[] num1 = {4, 1, 2};
        int[] num2 = {1, 3, 4, 2};

        Solution solution = new Solution();
        int[] res = solution.nextGreaterElement(num1, num2);
        System.out.println("res：" + Arrays.toString(res));
    }

}