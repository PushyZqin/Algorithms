package site.pushy.algorithms.datastructure.hashSet;

/**
 * @author Pushy
 * @since 2019/1/14 19:23
 */
public class MyLinkedHashMap implements HashMapApi {

    class ListNode {
        int key;
        int val;
        ListNode next;

        ListNode(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    final ListNode[] nodes;

    public MyLinkedHashMap() {
        nodes = new ListNode[10001];
    }

    @Override
    public void put(int key, int value) {
        int hash = hash(key);
        if (nodes[hash] == null)
            nodes[hash] = new ListNode(-1, -1);

        ListNode prev = findPrevNode(nodes[hash], key);
        if (prev.next == null)
            prev.next = new ListNode(key, value);
        else
            prev.next.val = value;
    }

    @Override
    public int get(int key) {
        int hash = hash(key);
        if (nodes[hash] == null) return -1;

        ListNode prev = findPrevNode(nodes[hash], key);
        return prev.next == null ? -1 : prev.next.val;
    }

    @Override
    public void remove(int key) {
        int hash = hash(key);
        if (nodes[hash] ==null) return;

        ListNode prev = findPrevNode(nodes[hash], key);
        if (prev.next == null) return;

        prev.next = prev.next.next;   // 删除prev.next结点
    }

    /**
     * 发现前驱结点
     */
    private ListNode findPrevNode(ListNode bucket, int key) {
        ListNode node = bucket;
        ListNode prev = null;

        while (node != null && node.key != key) {
            prev = node;
            node = node.next;
        }
        return prev;
    }

    /**
     * 获取哈希值
     * @param key
     * @return
     */
    private int hash(int key) {
        return Integer.hashCode(key) % nodes.length;
    }

}