package leetcode.explore.linkedList.mergeTwoLists;

import leetcode.explore.linkedList.ListNode;
import leetcode.explore.linkedList.ListUtil;

/**
 * @author Pushy
 * @since 2019/1/8 16:49
 */
public class Solution {

    /**
     * 同时不断遍历两个链表，取出小的追加到新的头结点，直至两者其中一个为空
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        /* 创建哑结点，这样就不用判断新链表的头结点是l1的头结点还是l2的头结点了 */
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }

        /* 判断哪个链表先遍历完毕，就将另外一个链表拼接起来就行 */
        if (l1 == null) cur.next = l2;   // 代表l1先遍历完毕了
        if (l2 == null) cur.next = l1;   // 代表l2先遍历完毕了

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode l1 = ListUtil.getListByArray(new int[]{1, 2, 4});
        ListNode l2 = ListUtil.getListByArray(new int[]{1, 3, 4});

        Solution solution = new Solution();
        ListNode res = solution.mergeTwoLists(l1, l2);
        System.out.println("res：" + ListUtil.toString(res));
    }

}