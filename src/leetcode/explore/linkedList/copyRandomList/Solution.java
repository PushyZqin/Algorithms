package site.pushy.algorithms.leetcode.explore.linkedList.copyRandomList;

import java.util.*;

/**
 * @author Pushy
 * @since 2019/4/16 15:42
 */
public class Solution {

    static class Node {
        public int val;
        public Node next;
        public Node random;

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _next, Node _random) {
            val = _val;
            next = _next;
            random = _random;
        }
    }

    public Node copyRandomList(Node head) {
        if (head == null) return null;

        Node newHead = new Node(head.val, null, null);
        Node oldHead = head.next;
        Map<Node, Node> map = new HashMap<>();  // 用来保存旧结点与新结点的映射
        map.put(head, newHead);

        Node cur = newHead;
        while (oldHead != null) {
            Node clone = new Node(oldHead.val, null, null);
            cur.next = clone;
            map.put(oldHead, clone);
            oldHead = oldHead.next;
            cur = cur.next;
        }

        cur = newHead;

        // 处理random指针
        while (head != null) {
            if (head.random != null) {
                cur.random = map.get(head.random);
            }
            head = head.next;
            cur = cur.next;
        }
        return newHead;
    }

    /**
     * 将节点复制，插入到被复制的节点的后面，然后将随机节点加入进去，之后拆分链表
     */
    public Node copyRandomList2(Node head) {
        Node cur = head;
        while (cur != null) {
            Node clone = new Node(cur.val);
            Node next = cur.next;

            cur.next = clone;
            clone.next = next;
            cur = next;
        }

        cur = head;
        while (cur != null) {
            cur.next.random = cur.random == null ? null : cur.random.next;
            cur = cur.next.next;
        }

        cur = head;
        Node res = head.next;
        while (cur != null) {
            Node clone = cur.next;
            cur.next = clone.next;
            clone.next = clone.next == null ? null : clone.next.next;
            cur = cur.next;
        }
        return res;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        Node next = new Node(2);

        head.next = next;
        head.random = next;
        next.random = next;

        Solution solution = new Solution();
        Node res = solution.copyRandomList(head);
        System.out.println("res：" + res);
    }

}