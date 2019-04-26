package site.pushy.algorithms.datastructure.linkedList;

/**
 * @author Pushy
 * @since 2019/1/4 16:05
 */
public class MyLinkedList implements LinkedListInterface {

    Node head = null;  // 头节点

    /**
     * 节点类
     */
    private class Node {
        Node next = null;
        int data;

        public Node(int data) {
            this.data = data;
        }
    }

    public MyLinkedList() {
    }

    @Override
    public int get(int index) {
        int j = 0;
        Node p = head;

        while (p != null && j < index) {
            p = p.next;
            j++;
        }
        if (p == null) {  // 索引失败
            return -1;
        }
        return p.data;
    }

    @Override
    public void addAtHead(int val) {
        Node f = head;  // 保存原先的头结点

        head = new Node(val);
        head.next = f;
    }

    @Override
    public void addAtTail(int val) {
        Node p = head;
        while (p.next != null) {
            p = p.next;
        }

        p.next = new Node(val);
    }

    @Override
    public void addAtIndex(int index, int val) {
        int j = 0;
        Node p = head;

        while (p != null && j < index - 1) {  // 找着index的前驱结点
            p = p.next;
            j++;
        }
        if (p == null) return; // 插入失败

        Node node = new Node(val);  // 创建新的节点
        node.next = p.next;  // 将新的节点的后继节点指向原先的(index-1)的后继节点
        p.next = node;  // 将原先的(index-1)的后继节点指向新节点
    }

    @Override
    public void deleteAtIndex(int index) {
        int j = 0;
        Node p = head;

        while (p != null && j < index - 1) {
            p = p.next;
            j++;
        }
        if (p == null) return;

        Node temp = p.next;
        p.next = temp.next; // 让第i个结点的前驱结点的next指针指向第i个节点的后继结点
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");

        Node p = head;
        while (p != null) {
            sb.append(p.data);
            if (p.next != null) {
                sb.append(",");
            }
            p = p.next;
        }

        sb.append("]");
        return sb.toString();
    }

    public static void main(String[] args) {
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.addAtHead(1);

        linkedList.addAtTail(3);
        linkedList.addAtIndex(1, 2);   //链表变为1-> 2-> 3

        System.out.println(linkedList.get(1));            //返回2
        linkedList.deleteAtIndex(1);  //现在链表是1-> 3
        System.out.println(linkedList.get(1));            //返回3

        System.out.println(linkedList);
    }


}
