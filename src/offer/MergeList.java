package offer;

import leetcode.explore.linkedList.ListNode;

public class MergeList {

    public ListNode Merge(ListNode list1, ListNode list2) {
        ListNode l1 = list1, l2 = list2;
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                cur.next = l2;
                l2 = l2.next;
            } else {
                cur.next = l1;
                l1 = l1.next;
            }
            cur = cur.next;
        }
        cur.next = l1 == null ? l2 : l1;
        return dummy.next;
    }

}
