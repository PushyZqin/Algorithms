package site.pushy.algorithms.leetcode.explore.linkedList.MyLinkedList;

/**
 * @author Pushy
 * @since 2019/4/14 10:52
 */
public class MyLinkedList {

    public static class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
        }
    }

    private Node head;

    /**
     * Initialize your data structure here.
     */
    public MyLinkedList() {

    }

    /**
     * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
     */
    public int get(int index) {
        if (head == null) return -1;
        Node cur = head;
        int i = 0;
        while (cur != null) {
            if (index == i) {
                return cur.val;
            }
            cur = cur.next;
            i++;
        }
        return -1;
    }

    /**
     * Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
     */
    public void addAtHead(int val) {
        if (head == null) {  // 特殊处理，头结点空，则直接将头结点设置为新的节点
            head = new Node(val);
        } else {
            Node newNode = new Node(val);
            newNode.next = head;
            head = newNode;
        }

    }

    /**
     * Append a node of value val to the last element of the linked list.
     */
    public void addAtTail(int val) {
        if (head == null) { // 特殊处理，头结点空，则直接将头结点（也是为尾结点）设置为新的节点
            head = new Node(val);
        } else {
            Node newNode = new Node(val);
            Node p = head;
            while (p.next != null) { // 找到尾结点
                p = p.next;
            }
            p.next = newNode;
        }
    }

    /**
     * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
     */
    public void addAtIndex(int index, int val) {
        Node prev = null;
        if (index == 0) {  // 当index=0时，实际上就是插入到头结点
            addAtHead(val);
        } else {
            Node cur = head;
            int i = 0;
            while (cur != null) {
                if (i == index) {
                    Node newNode = new Node(val);
                    newNode.next = cur;
                    prev.next = newNode;
                    break;
                } else {
                    prev = cur;
                    cur = cur.next;
                    i++;
                    if (cur == null && i == index) {
                        Node newNode = new Node(val);
                        prev.next = newNode;
                        break;
                    }
                }
            }

        }
    }

    /**
     * Delete the index-th node in the linked list, if the index is valid.
     */
    public void deleteAtIndex(int index) {
        if (head == null) return;

        Node prev = null;
        if (index == 0) { // 当index=0，即删除头结点，直接将头结点设置为null即可
            head = null;
        } else {
            Node cur = head;
            int i = 0;
            while (cur != null) {
                if (i == index) {
                    prev.next = cur.next;
                    break;
                } else {
                    prev = cur;
                    cur = cur.next;
                    i++;
                }
            }

        }
    }

}
