package leetcode.problemset._61_Rotate_List;

import leetcode.explore.linkedList.ListNode;
import leetcode.explore.linkedList.ListUtil;

/**
 * @author Pushy
 * @since 2019/1/9 19:00
 */
public class Solution {

    public ListNode rotateRight(ListNode head, int k) {
        if (k == 0 || head == null || head.next == null) return head;

        int length = 0;
        ListNode cur = head;
        while (cur != null) {
            cur = cur.next;
            length++;
        }
        if (k % length == 0) return head;
        int n = length - (k % length);

        ListNode tail = head;
        for (int i = 0; i < n - 1; i++) { // 找到新的尾结点
            tail = tail.next;
        }

        ListNode newHead = tail.next;  // 新的头结点
        tail.next = null;

        cur = newHead;
        while (cur.next != null) { // 遍历到尾结点
            cur = cur.next;
        }
        cur.next = head; // 将两个断开的链表相连
        return newHead;
    }

    /**
     * 参考LeetCode
     */
    public ListNode rotateRight2(ListNode head, int k) {
        if (head == null || k == 0) {
            return head;
        }
        ListNode cursor = head;
        ListNode tail = null;//尾指针
        int length = 1;
        while (cursor.next != null)//循环 得到总长度
        {
            cursor = cursor.next;
            length++;
        }
        int loop = length - (k % length);//得到循环的次数
        tail = cursor;//指向尾结点
        cursor.next = head;//改成循环链表
        cursor = head;//指向头结点
        for (int i = 0; i < loop; i++) {//开始循环
            cursor = cursor.next;
            tail = tail.next;
        }
        tail.next = null;//改成单链表
        return cursor;//返回当前头
    }

    public static void main(String[] args) {
        ListNode head = ListUtil.getListByArray(new int[]{1, 2, 3, 4, 5});

        Solution solution = new Solution();
        ListNode res = solution.rotateRight(head, 2);
        System.out.println("res：" + ListUtil.toString(res));
    }

}