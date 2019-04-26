package site.pushy.algorithms.fourth.bagQueueStack;

import java.util.Iterator;

/**
 * 可自动扩展大小的栈，而且实现了可迭代的接口，可使用for-each来进行迭代
 *
 * @author Pushy
 * @since 2019/1/6 12:58
 */
public class ResizingArrayStack<E> implements StackApi<E> {

    private class Itr implements Iterator<E> {
        int cursor = 0;

        @Override
        public boolean hasNext() {
            return cursor != size;
        }

        @Override
        public E next() {
            return elements[cursor++];
        }
    }

    private E[] elements;

    private int size;

    public ResizingArrayStack() {
        this.elements = (E[]) new Object[10];
    }

    public ResizingArrayStack(int cap) {
        this.elements = (E[]) new Object[cap];
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void push(E item) {
        if (size == elements.length) {  // 超出数组大小，扩展数组
            resize(2 * elements.length);
        }
        elements[size++] = item;
    }

    @Override
    public E pop() {
        E item = elements[--size];
        elements[size] = null;  // 避免对象游离
        /* 如果检测到栈的大小是数组长度的四分之一，那么则将数组的大小减半，避免浪费过多的空间 */
        if (size > 0 && size == elements.length / 4) {
            resize(elements.length /2);
        }
        return item;
    }

    @Override
    public E peek() {
        return elements[size];
    }

    /**
     * 调整数组的大小，将栈移动到另一个两倍大小不同的数组当中
     */
    private void resize(int max) {
        E[] temp = (E[]) new Object[max];
        for (int i = 0; i < size; i++) {
            temp[i] = elements[i];
        }
        elements = temp;
    }

    @Override
    public Iterator<E> iterator() {
        return new Itr();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < size; i++) {
            sb.append(elements[i]);
            if (i != size - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }


}
