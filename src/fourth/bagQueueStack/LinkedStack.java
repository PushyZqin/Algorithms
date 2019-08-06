package fourth.bagQueueStack;

import java.util.Iterator;

/**
 * 使用链表来实现栈
 *
 * @author Pushy
 * @since 2019/1/6 21:12
 */
public class LinkedStack<E> implements StackApi<E> {

    private int size;
    private Node head;

    private class Node {
        E item;
        Node next;

        public Node(E item) {
            this.item = item;
        }
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    /**
     * 入栈，添加新的结点到链头，替换先前的头结点
     * @param item
     */
    @Override
    public void push(E item) {
        Node oldHead = head;
        head = new Node(item);
        head.next = oldHead;
        size++;
    }

    /**
     * 出栈，删除头结点
     * @return
     */
    @Override
    public E pop() {
        E item = head.item;
        head = head.next;
        size--;
        return item;
    }

    /**
     * 返回头结点的元素
     * @return
     */
    @Override
    public E peek() {
        return head.item;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (Node node = head; node != null; node = node.next) {
            sb.append(node.item);
            if (node.next != null) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

}
