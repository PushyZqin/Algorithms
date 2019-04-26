package site.pushy.algorithms.simple.array;

import java.util.Stack;

/**
 * 给你一个长度为n的数组，其中有一个数字出现的次数至少为n/2，找出这个数字
 *
 * @author Pushy
 * @since 2018/12/24 20:25
 */
public class FindMajorityElement {

    public static int solution(int[] array) {
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < array.length; i++) {
            if (stack.isEmpty()) {  // 如果栈为空，将元素入栈
                stack.push(array[i]);
            }
            else if (stack.peek() == array[i]) {  // 如果该元素和栈顶元素相等，则入栈
                stack.push(array[i]);
            } else {
                stack.pop();  // 如果与栈顶元素不相等，则将栈顶元素出栈
            }
        }

        /* 那么剩下来的元素肯定是出现次数最多的（而且肯定出现次数肯定大于 n/2） */
        return stack.peek();
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 1, 1};

        int result = FindMajorityElement.solution(array);
        System.out.println(result);
    }

}