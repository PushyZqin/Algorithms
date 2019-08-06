package fourth.bagQueueStack;

/**
 * 定容栈的实现
 *
 * @author Pushy
 * @since 2019/1/6 12:48
 */
public class FixedCapacityStack<E> implements StackApi<E>{

    private E[] elements;
    private int size;

    public FixedCapacityStack(int cap) {
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
        elements[size++] = item;
    }

    @Override
    public E pop() {
        return elements[--size];
    }

    @Override
    public E peek() {
        return elements[size];
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