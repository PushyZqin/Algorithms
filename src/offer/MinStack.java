package offer;

import java.util.Stack;

/**
 * @author pushy zheng
 * @since 2019/8/8
 */
public class MinStack {

    private Stack<Integer> stack1 = new Stack<>();
    private Stack<Integer> stack2 = new Stack<>();

    public void push(int value) {
        stack1.push(value);
        if (stack2.isEmpty())
            stack2.push(value);
        else if (value <= stack2.peek())
            stack2.push(value);
    }

    public void pop() {
        if (stack1.peek().equals(stack2.peek()))
            stack2.pop();
        stack1.pop();
    }

    public int top() {
        return stack1.peek();
    }

    public int min() {
        return stack2.peek();
    }

    public static void main(String[] args) {
        MinStack stack = new MinStack();
        stack.push(4);
        stack.push(2);
        stack.push(3);

        System.out.println(stack.min());
    }

}
