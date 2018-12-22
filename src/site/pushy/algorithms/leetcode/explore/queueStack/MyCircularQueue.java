package site.pushy.algorithms.leetcode.explore.queueStack;

import java.util.Arrays;

/**
 * 设计循环队列实现——循环队列是一种线性数据结构，其操作表现基于 FIFO（先进先出）原则并且队尾被连接在队首之后以形成一个循环。
 * 它也被称为“环形缓冲器”。循环队列的一个好处是我们可以利用这个队列之前用过的空间。
 * 在一个普通队列里，一旦一个队列满了，我们就不能插入下一个元素，即使在队列前面仍有空间。
 * 但是使用循环队列，我们能使用这些空间去存储新的值。
 * @author Pushy
 * @since 2018/111/7 12:111
 */
public class MyCircularQueue {

    private Integer[] data;
    private int maxSize;
    private int head;
    private int tail;
    private int length;

    /** Initialize your data structure here. Set the size of the queue to be k. */
    public MyCircularQueue(int k) {
        data = new Integer[k];
        maxSize = k;
        head = 0;
        tail = 0;
        length = 0;
    }

    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }
        data[tail] = value;
        tail = (tail + 1) % maxSize;
        length++;
        return true;
    }

    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }
        data[head] = null;
        head = (head + 1) % maxSize;
        length--;
        return true;
    }

    /** Get the front item from the queue. */
    public int Front() {
        if (isEmpty()) {
            return -1;
        }
        return data[head];
    }

    /** Get the last item from the queue. */
    public int Rear() {
        if (isEmpty()) {
            return -1;
        }
        int temp = tail == 0? (maxSize - 1) : (tail - 1);  // tail的前一位总是尾元素
        return data[temp];
    }

    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        return length == 0;
    }

    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        return length == maxSize;
    }

    public void traverseQueue() {
        System.out.println(Arrays.asList(data));
    }

    public static void main(String[] args) {
        MyCircularQueue circularQueue = new MyCircularQueue(3);

        circularQueue.enQueue(1);  // 返回true

        circularQueue.enQueue(2);  // 返回true

        circularQueue.enQueue(3);  // 返回true

        circularQueue.enQueue(4);  // 返回false,队列已满

        int rear = circularQueue.Rear();  // 返回3

        circularQueue.isFull();  // 返回true

        circularQueue.deQueue();  // 返回true

        circularQueue.enQueue(4);  // 返回true

        int rear2 = circularQueue.Rear();  // 返回4
    }

}
