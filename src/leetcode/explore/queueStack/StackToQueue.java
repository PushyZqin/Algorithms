package leetcode.explore.queueStack;

import java.util.Stack;

/**
 * 用栈实现队列
 *
 * @author Pushy
 * @since 2018/111/14 12:18
 */
public class StackToQueue {

    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    /** Initialize your data structure here. */
    public StackToQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        stack1.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }

        int result = stack2.pop();

        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }

        return result;
    }

    /** Get the front element. */
    public int peek() {
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }

        int result = stack2.peek();

        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }

        return result;
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack1.isEmpty();
    }

    public static void main(String[] args) {
        StackToQueue queue = new StackToQueue();
        queue.push(1);
        queue.push(2);
        int res1 = queue.peek();  // 返回 1
        int res2 = queue.pop();   // 返回 1
        boolean res3 = queue.empty(); // 返回 false

        System.out.println(res1 + " " + res2+ " " + res3);
    }

}
