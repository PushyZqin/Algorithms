package leetcode.problemset._203_Remove_Linked_List_Elements;

import leetcode.explore.linkedList.ListNode;
import leetcode.explore.linkedList.ListUtil;

/**
 * @author Pushy
 * @since 2019/1/5 18:27
 */
public class Solution {

    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return null;

        /* 操作链表的技巧，为了方便返回结果，新建一个结点dummy作为一个头结点 */
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prev = dummy;
        while (prev.next != null) {
            if (prev.next.val == val)
                prev.next = prev.next.next; // 删除下一个结点
            else
                prev = prev.next;
        }
        return dummy.next;
    }

    /**
     * 递归求法
     */
    public ListNode removeElements2(ListNode head, int val) {
        if (head == null) return head;

        head.next = removeElements(head.next, val);
        return head.val == val ? head.next : head;
    }

    public static void main(String[] args) {
        // 测试用例：[1, 3, 3, 2]
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(2);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;

        Solution solution = new Solution();
//        Solution2 solution1 = new Solution2();
        ListNode res = solution.removeElements(head, 2);
        System.out.println("res：" + ListUtil.toString(res));
    }

}