package leetcode.problemset._86_Partition_List;

import leetcode.explore.linkedList.ListNode;
import leetcode.explore.linkedList.ListUtil;

/**
 * @author Pushy
 * @since 2019/4/20 10:27
 */
public class Solution {

    public ListNode partition(ListNode head, int x) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode prev = dummy, cur;
        while (prev.next != null && prev.next.val < x) {  // 找出链表中第一个大于或等于x的结点
            prev = prev.next;
        }
        cur = prev;

        while (cur.next != null) {
            if (cur.next.val < x) {
                ListNode temp = cur.next;
                cur.next = temp.next;

                temp.next = prev.next;
                prev.next = temp;
                prev = prev.next;
            } else {
                cur = cur.next;
            }
        }
        return dummy.next;
    }

    public ListNode partition2(ListNode head, int x) {
        ListNode lessDummy = new ListNode(0);
        ListNode moreDummy = new ListNode(0);

        ListNode lessCur = lessDummy, moreCur = moreDummy;
        while (head != null) {
            if (head.val < x) {
                lessCur.next = head;
                lessCur = lessCur.next;
            } else {
                moreCur.next = head;
                moreCur = moreCur.next;
            }
            head = head.next;
        }

        lessCur.next = moreDummy.next;
        moreCur.next = null;
        return lessDummy.next;
    }

    public static void main(String[] args) {
        ListNode head = ListUtil.getListByArray(new int[]{1, 4, 3, 2, 5, 2});

        Solution solution = new Solution();
        ListNode res = solution.partition2(head, 3);
        System.out.println("res：" + ListUtil.toString(res));
    }

}