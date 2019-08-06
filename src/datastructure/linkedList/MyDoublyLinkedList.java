package datastructure.linkedList;

/**
 * @author Pushy
 * @since 2019/1/5 0:17
 */
public class MyDoublyLinkedList implements LinkedListInterface {

    DoublyListNode head;

    private static class DoublyListNode {

        DoublyListNode next;
        DoublyListNode prev;
        int val;

        DoublyListNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return "DoublyListNode{" +
                    "val=" + val +
                    '}';
        }
    }

    @Override
    public int get(int index) {
        return 0;
    }

    @Override
    public void addAtHead(int val) {
        DoublyListNode node = new DoublyListNode(val);
        /* 将新节点的后继指向原先的头结点，新的节点的前驱指向null，代表它现在是头结点 */
        node.next = head;
        node.prev = null;
        /* 将新的节点赋值给头结点 */
        head = node;
    }

    @Override
    public void addAtTail(int val) {
        DoublyListNode front = head;
        while (front.next != null) {  // 遍历到最后一个节点
            front = front.next;
        }
        DoublyListNode node = new DoublyListNode(val);  // 创建新的节点
        /* 让最后一个节点的后继指向新的节点，新的节点的前驱指向最后一个节点 */
        front.next = node;
        node.prev = front;
        /* 让新的节点的后继指向 null，代表它成为最后一个节点 */
        node.next = null;
    }

    @Override
    public void addAtIndex(int index, int val) {
        int j = 0;
        DoublyListNode front = head;
        while (front != null && j < index - 1) { // 遍历到第 i-1 个节点
            front = front.next;
            j++;
        }
        if (front == null) { // 添加位置不合理
            return;
        }

        DoublyListNode temp = front.next;  // 保留原来的第i个节点

        DoublyListNode node = new DoublyListNode(val);
        /* 让新的节点的前驱指向第i-1个节点，第i-1个节点的后继指向新的节点，让新的节点成为第i个节点 */
        node.prev = front;
        front.next = node;
        /* 让新的节点的后继指向原先的第i个节点，原先第i个节点的前驱指向新的节点 */
        node.next = temp;
        temp.prev = node;
    }

    @Override
    public void deleteAtIndex(int index) {
        int j = 0;
        DoublyListNode front = head;
        while (front != null && j < index - 1) {  // 遍历到第i-1个节点
            front = front.next;
            j++;
        }
        if (front == null) {  // 删除位置不合理
            return;
        }

        DoublyListNode temp = front.next;  // 保留原先第i个节点
        /* 将第i-1个节点的后继指向第i+1个节点，第i+1个节点的前驱指向第i-1个节点 */
        front.next = temp.next;
        temp.next.prev = front;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");

        DoublyListNode p = head;
        while (p != null) {
            sb.append(p.val);
            if (p.next != null) {
                sb.append(",");
            }
            p = p.next;
        }

        sb.append("]");
        return sb.toString();
    }

    public static void main(String[] args) {
        /*DoublyListNode node1 = new DoublyListNode(1);
        DoublyListNode node2 = new DoublyListNode(2);
        DoublyListNode node3 = new DoublyListNode(3);
        node1.next = node2;
        node2.prev = node1;
        node2.next = node3;
        node3.prev = node2;
        MyDoublyLinkedList linkedList = new MyDoublyLinkedList(node1);*/

        MyDoublyLinkedList linkedList = new MyDoublyLinkedList();

        linkedList.addAtHead(2);
        linkedList.addAtHead(1);
        linkedList.addAtHead(0);

        System.out.println(linkedList);

        linkedList.addAtIndex(1, 9);

        System.out.println(linkedList);

        linkedList.addAtTail(8);

        System.out.println(linkedList);

        linkedList.deleteAtIndex(2);

        System.out.println(linkedList);
    }

}
