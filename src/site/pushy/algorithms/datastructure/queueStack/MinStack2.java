package site.pushy.algorithms.datastructure.queueStack;

import java.util.Stack;

/**
 * 设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。
 * 该结构用JDK内置的Stack库实现，并用一个栈stack2来保存最小的元素
 *
 * @author Pushy
 * @since 2018/111/8 9:25
 */
public class MinStack2 {

    private Stack<Integer> stack1;
    private Stack<Integer> stack2;  // 存放最小的数值

    /** initialize your data structure here. */
    public MinStack2() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void push(int x) {
        stack1.push(x);

        if (stack2.isEmpty()) {
            stack2.push(x);
        } else if (x < stack2.peek()) {
            stack2.push(x);
        }
    }

    public void pop() {
        int x = stack1.pop();
        // 如果stack1出站的数据是stack2最小的数据，那么则删除stack2中顶元素（即最小的数）
        if (x == stack2.peek()) {
            stack2.pop();
        }
    }

    public int top() {
        return stack1.peek();
    }

    public int getMin() {
        return stack2.peek();
    }

    public static void main(String[] args) {
        MinStack2 minStack = new MinStack2();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);

        int min1 = minStack.getMin();  // 返回 -3.
        minStack.pop();
        minStack.top();     // 返回 0.
        int min2 = minStack.getMin();  // 返回 -2.
    }

}
