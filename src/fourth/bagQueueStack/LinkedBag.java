package fourth.bagQueueStack;

import java.util.Iterator;

/**
 * @author Pushy
 * @since 2019/1/6 21:40
 */
public class LinkedBag<E> implements BagApi<E> {

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

    /**
     * 向背包中添加元素，内部只需要在链表头部添加新的结点即可
     * @param item
     */
    @Override
    public void add(E item) {
        Node oldHead = head;
        head = new Node(item);
        head.next = oldHead;
        size++;
    }

    private class Itr implements Iterator<E> {

        private Node cursor = head;

        @Override
        public boolean hasNext() {
            return cursor != null;
        }

        @Override
        public E next() {
            E item = cursor.item;
            cursor = cursor.next;
            return item;
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new Itr();
    }

}
