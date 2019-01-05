package site.pushy.algorithms.datastructure.queueStack;

import java.util.LinkedList;
import java.util.Queue;

public class QueueToStack {

    Queue<Integer> myQueue;

    /** Initialize your data structure here. */
    public QueueToStack() {
        myQueue= new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        int n = myQueue.size();
        Queue<Integer> tempQueue= new LinkedList<>();
        for (int i = 0; i < n; i++) {
            tempQueue.add(myQueue.poll());
        }
        myQueue.add(x);
        for (int i = 0; i < n; i++) {
            myQueue.add(tempQueue.poll());
        }
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return myQueue.poll();
    }

    /** Get the top element. */
    public int top() {
        return myQueue.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return myQueue.isEmpty();
    }

}
