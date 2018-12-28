package site.pushy.algorithms.leetcode.explore.queueStack.example;

/**
 * 设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。
 * 该结构用数组实现
 *
 * @author Pushy
 * @since 2018/111/8 9:25
 */
public class MinStack {

    private Integer[] data;
    private int length;

    /** initialize your data structure here. */
    public MinStack() {
        data = new Integer[10];
        length = 0;
    }

    public void push(int x) {
        data[length] = x;
        length++;
    }

    public void pop() {
        data[length - 1] = null;
        length--;
    }

    public int top() {
        return data[length - 1];
    }

    public int getMin() {
        int min = data[0];
        for (int i = 1; i < length; i++) {
            if (data[i] < min) {
                min = data[i];
            }
        }
        return min;
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);

        int min1 = minStack.getMin();  // 返回 -3.
        minStack.pop();
        minStack.top();     // 返回 0.
        int min2 = minStack.getMin();  // 返回 -2.
    }

}
