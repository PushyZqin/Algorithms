package leetcode.explore.linkedList;

import java.util.LinkedList;

/**
 * @author Pushy
 * @since 2018/11/10 9:51
 */
public class MyLinkedList {

    Node head = null;  // 头结点

    class Node {
        Node next = null;
        int data;

        public Node(int data) {
            this.data = data;
        }
    }

    /** Initialize your data structure here. */
    public MyLinkedList() {

    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        int j = 0;
        Node p = head;
        while (p != null && j < index) {
            p = p.next;
            j++;
        }
        if (p == null) {
            return -1;
        }
        return p.data;
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        final Node f = head;  // 保存原先的头结点
        Node newNode = new Node(val);
        head = newNode;
        head.next = f;
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        Node newNode = new Node(val);
        head.next = newNode;
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        int j = 0;
        Node p = head;
        while (p != null && j < index - 1) { // 找到前驱结点
            p = p.next;
            j++;
        }
        if (p == null) {
            return;
        }
        // 创建新的节点
        Node newNode = new Node(val);
        newNode.next = p.next;
        p.next = newNode;
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        int j = 0;
        Node p = head;
        while (p != null && j < index - 1) { // 找到前驱结点
            p = p.next;
            j++;
        }
        if (p == null) {
            return;
        }
        Node tmp = p.next;  // 删除释放的节点
        p.next = tmp.next;  // 让第i个结点的前驱结点的next指针指向第i个节点的后继结点
    }

    public static void main(String[] args) {
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.addAtHead(1);
        linkedList.addAtTail(3);
        linkedList.addAtIndex(1, 2);   //链表变为1-> 2-> 3
        int res1 = linkedList.get(1);            //返回2
        linkedList.deleteAtIndex(1);  //现在链表是1-> 3
        int res2 = linkedList.get(1);            //返回3


        System.out.println("res1 = " + res1);
        System.out.println("res2 = " + res2);
    }

}
