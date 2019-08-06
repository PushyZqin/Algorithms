package leetcode;

import leetcode.explore.linkedList.ListNode;
import leetcode.explore.linkedList.ListUtil;

/**
 * @author Pushy
 * @since 2019/1/8 16:14
 */
public class RemoveDuplicatesFromList {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy;

        while (cur.next != null) {
            if (cur.next.next != null && cur.next.val == cur.next.next.val) {
                while (cur.next.next != null && cur.next.val == cur.next.next.val) {
                    cur.next = cur.next.next;  // 删除p的后续结点
                }
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        head.next = node1;
        node1.next = node2;

        RemoveDuplicatesFromList solution = new RemoveDuplicatesFromList();
        ListNode res = solution.deleteDuplicates(head);

        System.out.println("res：" + ListUtil.toString(res));
    }

}
