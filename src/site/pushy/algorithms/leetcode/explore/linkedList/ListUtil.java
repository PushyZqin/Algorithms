package site.pushy.algorithms.leetcode.explore.linkedList;

/**
 * @author Pushy
 * @since 2019/1/5 16:59
 */
public class ListUtil {

    public static ListNode getList() {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);

        head.next = node1;
        node1.next = node2;
        node2.next = node3;

        return head;
    }

    public static String toString(ListNode head) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");

        ListNode p = head;
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

}
