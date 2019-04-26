package site.pushy.algorithms.leetcode.explore.queueStack.dailyTemp;

import java.util.Arrays;
import java.util.Stack;

/**
 * Question：根据每日 气温 列表，请重新生成一个列表，对应位置的输入是你需要再等待多久温度才会升高的天数。
 * 如果之后都不会升高，请输入 0 来代替。
 * <p>
 * Thought：维持一个递减栈
 *
 * @author Pushy
 * @since 2018/111/8 13:31
 */
public class Solution {

    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int[] arr = new int[temperatures.length];

        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int t = stack.pop();
                arr[t] = i - t;
            }
            stack.push(i);
        }
        return arr;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] result = solution.dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73});
        System.out.println(Arrays.toString(result));
    }

}
