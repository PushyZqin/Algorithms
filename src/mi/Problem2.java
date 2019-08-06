package mi;

import java.util.Stack;

/**
 * @author Pushy
 * @since 2018/12/29 22:23
 */
public class Problem2 {

    private static int solution(int[] arr) {
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < arr.length; i++) {
            if (stack.isEmpty()) {
                stack.push(arr[i]);
            } else {
                if (arr[i] == stack.peek()) {
                    stack.pop();
                } else {
                    stack.push(arr[i]);
                }
            }
        }
        return stack.peek();
    }

    public static void main(String[] args) {
        int[] arr = {10, 10, 11, 12, 12, 11, 16};

        int res = Problem2.solution(arr);
        System.out.println(res);
    }

}
