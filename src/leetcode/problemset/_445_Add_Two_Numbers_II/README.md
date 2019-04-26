---
export_on_save:
  html: true
---

# [445. 两数相加 II](https://leetcode-cn.com/problems/add-two-numbers-ii/)

## Question

给定两个非空链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储单个数字。将这两数相加会返回一个新的链表。

你可以假设除了数字 0 之外，这两个数字都不会以零开头。

进阶:

如果输入链表不能修改该如何处理？换句话说，**你不能对列表中的节点进行翻转。**

示例:

```java
输入: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
输出: 7 -> 8 -> 0 -> 7
```

## Solution

该题和 [2. 两数相加](https://github.com/pushyzheng/Algorithms/blob/master/src/site/pushy/algorithms/leetcode/problemset/_2_Add_Two_Numbers) 类似，唯一区别在于链表的顺序相反。如果题目允许对列表中的节点进行翻转，那个这两题的解法是相同的。

但是我们可以使用两个栈进行操作，将两个链表遍历并入栈。然后再将两个栈出栈进行操作，达到“从后往前”遍历的操作。并将结果追加到dummy链表后，最后再反转链表：

```java
public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
    Stack<ListNode> s1 = new Stack<>(), s2 = new Stack<>();
    ListNode dummy = new ListNode(0);

    for (ListNode cur = l1; cur != null; cur = cur.next) s1.push(cur);
    for (ListNode cur = l2; cur != null; cur = cur.next) s2.push(cur);

    int carry = 0;
    ListNode cur = dummy;
    while (!s1.isEmpty() || !s2.isEmpty()) {
        int a = s1.isEmpty() ? 0 : s1.pop().val;
        int b = s2.isEmpty() ? 0 : s2.pop().val;
        int sum = a + b + carry;
        carry = sum / 10;

        cur.next = new ListNode(sum % 10);
        cur = cur.next;
    }
    if (carry != 0) cur.next = new ListNode(1);

    return reverseList(dummy.next);
}

// 翻转链表
public ListNode reverseList(ListNode head) {
    if (head == null || head.next == null) return head;

    ListNode reHead = reverseList(head.next);
    head.next.next = head;
    head.next = null;
    return reHead;
}
```