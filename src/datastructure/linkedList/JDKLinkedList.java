package datastructure.linkedList;

import java.util.Arrays;
import java.util.NoSuchElementException;

// 节点类
class Node<E> {
    E item;
    Node<E> next;
    Node<E> prev;

    /**
     * 构造方法，设置新节点的前驱和后继节点
     */
    Node(Node<E> prev, E element, Node<E> next) {
        this.item = element;
        this.next = next;
        this.prev = prev;
    }
}

public class JDKLinkedList<E> {

    transient int size = 0;   // 链表长度
    transient Node<E> first;  // 头结点
    transient Node<E> last;   // 尾节点

    int modCount;             // 修改次数

    /**
     * 给定一个索引，返回它对应的节点
     * 
     * @param index
     * @return
     */
    Node<E> node(int index) {
        /* size >> 1为移位操作，相当于size/2的操作 */
        if (index < (size >> 1)) { // 如果index小于size/2，那么从头开始向后遍历
            Node<E> x = first;
            for (int i = 0; i < index; i++)
                x = x.next;
            return x;
        } else { // 如果index大于size/2，那么从尾开始向前遍历
            Node<E> x = last;
            for (int i = size - 1; i > index; i--)
                x = x.prev;
            return x;
        }
    }

    /**
     * 添加元素到链头
     */
    private void linkFirst(E e) {
        final Node<E> f = first; // 保存原来的头结点
        final Node<E> newNode = new Node<>(null, e, f); // 创建新的节点，前驱设置为null，代表它会成为头结点
        first = newNode; // 将新的节点设置为头结点
        if (f == null)
            last = newNode;
        else
            f.prev = newNode; // 将之前的头结点前驱设置为新的节点
        size++;
        modCount++;
    }

    public void addFirst(E e) {
        linkFirst(e);
    }

    /**
     * 添加元素到链尾
     */
    void linkLast(E e) {
        final Node<E> l = last; // 保存原来的尾节点
        final Node<E> newNode = new Node<>(l, e, null); // 创建新的节点，后继设置为null，代表它会成为尾节点
        last = newNode; // 将新的节点设置为尾节点
        if (l == null)
            first = newNode;
        else
            l.next = newNode; // 将之前的尾节点的后继设置为新的节点
        size++; // 链表的长度+1
        modCount++; // 修改的次数+1
    }

    public void addLast(E e) {
        linkLast(e);
    }

    /**
     * 添加一个元素
     */
    public void add(int index, E element) {
        checkPositionIndex(index); // 检查索引是否越界或者不合理
        if (index == size) // 如果插入的是末尾，直接调用linkLast
            linkLast(element);
        else // 如果插入的是中间，则调用linkBefore
            linkBefore(element, node(index));
    }

    void linkBefore(E e, Node<E> succ) {
        final Node<E> pred = succ.prev; // 保存第i个节点的前驱结点
        final Node<E> newNode = new Node<>(pred, e, succ); // 创建新的节点，前驱设置为第i-1个节点，后继设置为第i个节点
        succ.prev = newNode; // 将原先的第i个节点前驱设置为新的节点
        if (pred == null)
            first = newNode;
        else
            pred.next = newNode; // 将第i-1个节点的后继设置为新的节点
        size++;
        modCount++;
    }

    /**
     * 获取一个元素
     */
    public E get(int index) {
        checkElementIndex(index); // 检查数组是否越界
        return node(index).item;
    }

    /**
     * 删除一个节点
     */
    public E remove() {
        return removeFirst();
    }

    /**
     * 删除第一个节点
     *
     * @return
     */
    public E removeFirst() {
        final Node<E> f = first;
        if (f == null) // 检查是否存在头节点
            throw new NoSuchElementException();
        return unlinkFirst(f);
    }

    private E unlinkFirst(Node<E> f) {
        final E element = f.item;
        final Node<E> next = f.next; // 保留头节点的后继
        f.item = null;
        f.next = null;
        first = next; // 将头节点重新设置
        if (next == null)
            last = null;
        else
            next.prev = null; // 将头节点的后继的前驱设置为null，代表它现在是头节点
        size--; // 链表长度减1
        modCount++;
        return element; // 返回被删除的元素值
    }

    /**
     * 删除最后一个节点
     *
     * @return
     */
    public E removeLast() {
        final Node<E> l = last;
        if (l == null) // 检查是否存在尾节点
            throw new NoSuchElementException();
        return unlinkLast(l);
    }

    private E unlinkLast(Node<E> l) {
        final E element = l.item;
        final Node<E> prev = l.prev; // 保留尾节点的前驱
        l.item = null;
        l.prev = null;
        last = prev; // 将尾节点重新设置
        if (prev == null)
            first = null;
        else
            prev.next = null; // 将尾节点前驱的后继设置为null，代表它现在是尾节点
        size--; // 链表长度减1
        modCount++;
        return element; // 返回被删除的元素值
    }

    public E remove(int index) {
        checkElementIndex(index); // 检查index是否合理
        return unlink(node(index));
    }

    /**
     * 删除某个节点
     *
     * @param x 需要删除的节点
     * @return 被删除的元素
     */
    E unlink(Node<E> x) {
        final E element = x.item;
        final Node<E> next = x.next; // 需要删除节点的后继
        final Node<E> prev = x.prev; // 需要删除节点的前驱

        if (prev == null) { // 代表删除的节点是头结点
            first = next;  // 直接将删除节点的后继设置为头结点
        } else {
            prev.next = next; // 将删除节点的前驱 next 设置为 删除节点的后继
            x.prev = null;
        }

        if (next == null) {  // 代表删除的是尾节点
            last = prev;  // 直接将删除节点的前驱设置为尾节点
        } else {
            next.prev = prev; // 将删除节点的后继的 prev 设置为 删除节点的前驱
            x.next = null;
        }

        x.item = null;
        size--;
        modCount++;
        return element;
    }

    /**
     * 设置第index个节点为新的值
     */
    public E set(int index, E element) {
        checkElementIndex(index);  // 检查数组是否越界
        Node<E> x = node(index);  // 查找到第index个节点
        E oldVal = x.item;
        x.item = element;  // 将节点的数据域设置为新的值
        return oldVal;
    }

    /**
     * 清除列表的所有节点
     */
    public void clear() {
        for (Node<E> x = first; x != null; ) {
            Node<E> next = x.next;
            x.item = null;
            x.next = null;
            x.prev = null;
            x = next;
        }
        first = last = null;  // 将头结点和尾节点设置为null 
        size = 0;  // 链表长度归零
        modCount++;
    }

    /**
     * 将链表中所有的元素添加到新的数组
     * @return
     */
    public Object[] toArray() {
        Object[] result = new Object[size];
        int i = 0;
        /* 遍历所有的节点 */
        for (Node<E> x = first; x != null; x = x.next)
            result[i++] = x.item;
        return result;
    }

    private boolean isPositionIndex(int index) {
        return index >= 0 && index <= size;
    }

    private String outOfBoundsMsg(int index) {
        return "Index: "+index+", Size: "+size;
    }

    private void checkPositionIndex(int index) {
        if (!isPositionIndex(index))
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
    }

    private boolean isElementIndex(int index) {
        return index >= 0 && index < size;
    }

    private void checkElementIndex(int index) {
        if (!isElementIndex(index))
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");

        for (Node<E> x = first; x != null; x = x.next) {
            sb.append(x.item);
            if (x.next != null) {
                sb.append(", ");
            }
        }
        sb.append("]");

        return sb.toString();
    }

    public static void main(String[] args) {
        JDKLinkedList<Integer> list = new JDKLinkedList<>();

        list.addFirst(0);
        list.addFirst(1);
        list.addLast(3);

        list.add(2, 2);

        System.out.println(list);

        System.out.println(Arrays.toString(list.toArray()));

        list.clear();

        System.out.println(list);

    }

}