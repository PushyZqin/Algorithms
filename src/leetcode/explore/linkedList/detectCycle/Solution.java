package leetcode.explore.linkedList.detectCycle;

import leetcode.explore.linkedList.ListNode;

/**
 * @author Pushy
 * @since 2019/1/4 19:06
 */
public class Solution {

    /**
     * 通过双指针来实现，算法来自LeetCode提交记录
     * 思路可以看 https://blog.csdn.net/Heitao5200/article/details/84994161
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) return null;

        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) { // 判断是否成环，快指针和慢指针相遇
                break;
            }
        }

        if (fast == null || fast.next == null) {
            return null;
        }

        /* fast指针到入口的距离 = head到环入口的距离 */
        slow = head;
        while (fast != slow) {
            slow = slow.next;
            fast = fast.next;
        }
        // fast == slow，快指针和慢指针在入口点相遇
        return slow;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(0);
        ListNode node3 = new ListNode(-4);

        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node1;

        Solution solution = new Solution();
        ListNode res = solution.detectCycle(head);
        System.out.println("res：" + res);
    }

}