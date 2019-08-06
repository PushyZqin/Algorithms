package skill.recursion;

import leetcode.explore.linkedList.ListNode;
import leetcode.explore.linkedList.ListUtil;

/**
 * @author Pushy
 * @since 2019/6/13 21:26
 */
public class SwapListNodePairs {

    public ListNode swapPairs(ListNode head){
        if (head == null || head.next == null) return head;

        ListNode next = head.next;
        head.next = swapPairs(next.next);

        next.next = head;
        return next;
    }

    public static void main(String[] args) {
        ListNode head = ListUtil.getListByArray(new int[]{1, 2, 3, 4});

        SwapListNodePairs solution = new SwapListNodePairs();
        ListNode r = solution.swapPairs(head);

        System.out.println(ListUtil.toString(r));
    }

}
