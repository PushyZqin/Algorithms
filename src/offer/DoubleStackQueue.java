package offer;

import java.util.Stack;

/**
 * @author Pushy
 * @since 2019/5/27 11:26
 */
public class DoubleStackQueue {

    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if (!stack2.isEmpty())
            return stack2.pop();

        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        return stack2.pop();
    }

    public static void main(String[] args) {
        DoubleStackQueue queue = new DoubleStackQueue();
        queue.push(1);
        queue.push(2);
        queue.push(3);

        System.out.println(queue.pop());
        System.out.println(queue.pop());

        queue.push(4);
        System.out.println(queue.pop());

        queue.push(5);
        System.out.println(queue.pop());
        System.out.println(queue.pop());
    }

}
