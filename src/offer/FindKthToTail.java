package offer;

import leetcode.explore.linkedList.ListNode;
import leetcode.explore.linkedList.ListUtil;

public class FindKthToTail {

    public ListNode FindKthToTail(ListNode head, int k) {
        if (head == null) return head;

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode first = dummy, second = dummy;

        for (int i = 1; i <= k + 1; i++) {
            if (first == null) return null;    // 防止输入的N会大于链表的长度
            first = first.next;
        }

        while (first != null) {
            first = first.next;
            second = second.next;
        }

        return second.next;
    }

    public static void main(String[] args) {
        FindKthToTail f = new FindKthToTail();
        ListNode root = ListUtil.getListByArray(new int[]{1, 2, 3, 4, 5});
        System.out.println(f.FindKthToTail(root, 6));
    }

}
