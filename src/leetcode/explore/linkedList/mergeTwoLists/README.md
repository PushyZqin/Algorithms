---
export_on_save:
  html: true
---

# [21. 合并两个有序链表](https://leetcode-cn.com/problems/merge-two-sorted-lists/)

## Question

将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 

示例：

```java
输入：1->2->4, 1->3->4
输出：1->1->2->3->4->4
```

## Solution

同时不断遍历两个链表，**取出值较小的结点追加到新的头结点**。直到其中有一个链表尾空时，将另一个链表追加到新的链表末尾即可：

```java
public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    ListNode dummy = new ListNode(-1);
    ListNode cur = dummy;

    while (l1 != null && l2 != null) {
        if (l1.val <= l2.val) { // 值相同优先追加l1结点
            cur.next = l1;
            l1 = l1.next;
        } else {
            cur.next = l2;
            l2= l2.next;
        }
        cur = cur.next;
    }

    if (l1 == null) cur.next = l2; // l1先遍历完，追加l2
    if (l2 == null) cur.next = l1;

    return dummy.next;
}
```

可以看到这里我们又用哑结点的技巧，假设我们是创建一个对象作为新链表的头结点，那么必须选取一个两链表其中一个头结点：

```java
ListNode newHead = l1 ? l2
```

这样能简化不用判断新链表的结点是`l1`的头结点还是`l2`的头结点，统一了判断的操作。