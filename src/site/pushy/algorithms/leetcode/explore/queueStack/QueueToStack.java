package site.pushy.algorithms.leetcode.explore.queueStack;

import org.omg.CORBA.INTERNAL;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 用队列实现栈
 *
 * @author Pushy
 * @since 2018/111/14 12:34
 */
public class QueueToStack {

    private Queue<Integer> queue1;
    private Queue<Integer> queue2;

    /** Initialize your data structure here. */
    public QueueToStack() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        if (queue1.isEmpty()) {
            queue2.offer(x);
        } else {
            queue1.offer(x);
        }
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        int result;

        if (!queue1.isEmpty()) {
            while (queue1.size() > 1) {
                queue2.offer(queue1.poll());
            }
            result = queue1.poll();

        } else {
            while (queue2.size() > 1) {
                queue1.offer(queue2.poll());
            }
            result = queue2.poll();
        }

        return result;
    }

    /** Get the top element. */
    public int top() {
        int result;

        if (!queue1.isEmpty()) {
            while (queue1.size() > 1) {
                queue2.offer(queue1.poll());
            }
            result = queue1.poll();
            queue2.offer(result);

        } else {
            while (queue2.size() > 1) {
                queue1.offer(queue2.poll());
            }
            result = queue2.poll();
            queue1.offer(result);
        }

        return result;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue1.isEmpty() && queue2.isEmpty();
    }

    public static void main(String[] args) {
        QueueToStack obj = new QueueToStack();
        obj.push(1);
        obj.push(2);
        int param_2 = obj.top();
        int param_3 = obj.pop();
        int param_4 = obj.pop();
        boolean param_5 = obj.empty();

        System.out.println(param_2 + " " +param_3 + " " +param_4 + " " + param_5);
    }

}
