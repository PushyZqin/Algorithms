package offer;

import leetcode.explore.linkedList.ListNode;

public class ReverseList {

    public ListNode ReverseList(ListNode head) {
        ListNode cur = head, prev = null;

        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = prev;

            prev = cur;
            cur = temp;
        }
        return prev;
    }

}
