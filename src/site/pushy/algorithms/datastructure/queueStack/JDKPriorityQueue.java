package site.pushy.algorithms.datastructure.queueStack;

import java.util.Arrays;
import java.util.Comparator;

public class JDKPriorityQueue<E> {

    private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;

    transient Object[] queue;                         // 堆的底层数组结构

    private final Comparator<? super E> comparator;   // 自定义比较器

    private int size = 0;                             // 堆的大小

    transient int modCount = 0;                       // 修改次数

    public JDKPriorityQueue(int initialCapacity) {
        this(initialCapacity, null);
    }

    public JDKPriorityQueue(int initialCapacity, Comparator<? super E> comparator) {
        if (initialCapacity < 1)
        throw new IllegalArgumentException();
        this.queue = new Object[initialCapacity];
        this.comparator = comparator;
    }

    /**
     * 用于扩容数组的函数
     */
    private void grow(int minCapacity) {
        int oldCapacity = queue.length;
        // 如果容量很小，则增量两倍大小；否则增加一半大小
        int newCapacity = oldCapacity + ((oldCapacity < 64) ?
                                         (oldCapacity + 2) :
                                         (oldCapacity >> 1));
        if (newCapacity - MAX_ARRAY_SIZE > 0)
            newCapacity = hugeCapacity(minCapacity);
        queue = Arrays.copyOf(queue, newCapacity);
    }

    private static int hugeCapacity(int minCapacity) {
        if (minCapacity < 0) // overflow
            throw new OutOfMemoryError();
        return (minCapacity > MAX_ARRAY_SIZE) ?
                Integer.MAX_VALUE :
                MAX_ARRAY_SIZE;
    }

    public boolean add(E e) {
        return offer(e);
    }

    public boolean offer(E e) {
        if (e == null)
            throw new NullPointerException();
        modCount++;
        int i = size;
        if (i >= queue.length)  // 数组大小不够，调用grow方法扩充
            grow(i + 1);
        size = i + 1;
        if (i == 0) // 如果只有一个元素则放入堆顶
            queue[0] = e;
        else        // 否则调用siftUp函数从上往下调整堆
            siftUp(i, e);
        return true;
    }

    private void siftUp(int k, E x) {
        if (comparator != null)
            siftUpUsingComparator(k, x);
        else
            siftUpComparable(k, x);
    }

    @SuppressWarnings("unchecked")
    private void siftUpComparable(int k, E x) {
        Comparable<? super E> key = (Comparable<? super E>) x;
        while (k > 0) {
            int parent = (k - 1) >>> 1;  // 找到父结点在数组中的索引，即parentNo = (curNo - 1) / 2
            Object e = queue[parent];
            if (key.compareTo((E) e) >= 0) // 与父结点进行比较
                break;
            // 如果比父结点小则与父结点交换位置，并继续向上比较
            queue[k] = e;
            k = parent;
        }
        queue[k] = key;
    }

    /**
     * 获取但不删除首元素，即队列中权值最小的那个元素
     */
    public E peek() {
        return (size == 0) ? null : (E) queue[0];  // 如果队列不为空，则返回数组下标0的元素
    }

    public E poll() {
        if (size == 0)
            return null;
        int s = --size;
        modCount++;
        E result = (E) queue[0];  // 权值最小的元素
        E x = (E) queue[s];       // 末尾元素
        queue[s] = null;
        if (s != 0)
            siftDown(0, x);
        return result;
    }

    private void siftDown(int k, E x) {
        if (comparator != null)
            siftDownUsingComparator(k, x);
        else
            siftDownComparable(k, x);
    }

    private void siftDownComparable(int k, E x) {
        Comparable<? super E> key = (Comparable<? super E>)x;
        int half = size >>> 1;        // loop while a non-leaf
        while (k < half) {
            int child = (k << 1) + 1; // 左子节点在数组中的索引，即leftNo = (parentNo * 2) + 1
            Object c = queue[child];
            int right = child + 1;    // 右子节点，即rightNo = leftNo + 1
            if (right < size &&
                ((Comparable<? super E>) c).compareTo((E) queue[right]) > 0)
                // 比较左右节点，找到权值较小的那个，将值记录到c中，并用child记录其下标
                c = queue[child = right];
            if (key.compareTo((E) c) <= 0)
                break;
            // 如果比左右子节点大，则继续与较小的交换位置，并继续向下比较
            queue[k] = c;
            k = child;
        }
        // 如果小于等于左右孩子的任意一个，则将key存到该结点
        queue[k] = key;
    }

    public boolean remove(Object o) {
        int i = indexOf(o);
        if (i == -1)
            return false;
        else {
            removeAt(i);
            return true;
        }
    }

    private E removeAt(int i) {
        modCount++;
        int s = --size;
        if (s == i) // 删除的是最后一个元素，直接删除即可
            queue[i] = null;
        else {      // 不是最后一个元素，需要进行调整
            E moved = (E) queue[s];
            queue[s] = null;
            siftDown(i, moved);
            if (queue[i] == moved) {
                siftUp(i, moved);
                if (queue[i] != moved)
                    return moved;
            }
        }
        return null;
    }

    private int indexOf(Object o) {
        if (o != null) {
            for (int i = 0; i < size; i++)
                if (o.equals(queue[i]))
                    return i;
        }
        return -1;
    }

    private void siftUpUsingComparator(int k, E x) {
        while (k > 0) {
            int parent = (k - 1) >>> 1;
            Object e = queue[parent];
            if (comparator.compare(x, (E) e) >= 0)
                break;
            queue[k] = e;
            k = parent;
        }
        queue[k] = x;
    }

    private void siftDownUsingComparator(int k, E x) {
        int half = size >>> 1;
        while (k < half) {
            int child = (k << 1) + 1;
            Object c = queue[child];
            int right = child + 1;
            if (right < size &&
                    comparator.compare((E) c, (E) queue[right]) > 0)
                c = queue[child = right];
            if (comparator.compare(x, (E) c) <= 0)
                break;
            queue[k] = c;
            k = child;
        }
        queue[k] = x;
    }

    @Override
    public String toString() {
        return Arrays.toString(queue);
    }

    public static void main(String[] args) {
        JDKPriorityQueue<Integer> queue = new JDKPriorityQueue<>(8);
        queue.offer(5);
        queue.offer(10);
        queue.offer(3);

        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());

        System.out.println(queue);


        // 倒序比较器，传入PriorityQueue的构造函数，可以让优先队列变成最大堆
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return - (o1 - o2);
            }
        };
        JDKPriorityQueue<Integer> maxQueue = new JDKPriorityQueue<>(8, comparator);
        maxQueue.offer(5);
        maxQueue.offer(10);
        maxQueue.offer(3);

        System.out.println(maxQueue.poll());   // 10
        System.out.println(maxQueue.poll());   // 5
    }

}