package skill;

import java.util.HashMap;
import java.util.Iterator;

public class LRUCache<K, V> {

    private Node head;

    private Node tail;

    private HashMap<K, Node> map;

    private int maxSize;

    private class Node {
        Node prev;
        Node next;
        K k;
        V v;

        public Node(K k, V v) {
            this.k = k;
            this.v = v;
        }
    }

    public LRUCache(int maxSize) {
        this.maxSize = maxSize;
        this.map = new HashMap<>(maxSize * 4 / 3);

        head = new Node(null, null);
        tail = new Node(null, null);

        head.next = tail;
        tail.prev = head;
    }

    public V get(K key) {
        if (!map.containsKey(key)) {
            return null;
        }
        Node node = map.get(key);
        remove(node);
        addFirst(node);
        return node.v;
    }

    public void put(K key, V value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            remove(node);
        }
        Node node = new Node(key, value);
        map.put(key, node);
        addFirst(node);

        if (map.size() > maxSize) {
            Node last = removeLast();
            map.remove(last.k);
        }
    }

    private void addFirst(Node node) {
        Node next = head.next;
        node.next = next;
        next.prev = node;

        node.prev = head;
        head.next = node;
    }

    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;

        node.prev = null;
        node.next = null;
    }

    private Node removeLast() {
        if (tail.prev == head) {
            return null;
        }
        Node last = tail.prev;
        remove(last);
        return last;
    }

    public static void main(String[] args) {
        LRUCache<Integer, Integer> lruCache = new LRUCache<>(1);
        lruCache.put(1, 1);
        lruCache.put(2, 2);
        lruCache.put(3, 3);

        System.out.println(lruCache.get(2));
    }
}
