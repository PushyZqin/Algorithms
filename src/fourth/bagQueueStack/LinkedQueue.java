package site.pushy.algorithms.fourth.bagQueueStack;

/**
 * 使用链表来实现队列的数据结构
 *
 * @author Pushy
 * @since 2019/1/6 21:23
 */
public class LinkedQueue<E> implements QueueApi<E> {

    private int size;
    private Node first;   // 头结点
    private Node last;    // 尾结点

    private class Node {
        E item;
        Node next;

        public Node(E item) {
            this.item = item;
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return first == null;
    }

    /**
     * 入队，在表尾添加新的结点
     */
    @Override
    public void enqueue(E item) {
        Node oldNode = last;
        last = new Node(item);

        if (first == null)
            first = last;
        else
            oldNode.next = last;

        size++;
    }

    /**
     * 出队，从表头删除结点
     */
    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new NullPointerException("The queue is empty");
        }
        E item = first.item;
        first = first.next;
        if (isEmpty())
            last = null;

        size--;
        return item;
    }
}
