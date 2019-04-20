---
export_on_save:
  html: true
---

# 86. 分隔链表

## Question

给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在**大于或等于 x 的节点之前**。

你应当保留两个分区中每个节点的初始相对位置。

示例:

```java
输入: head = 1->4->3->2->5->2, x = 3
输出: 1->2->2->4->3->5
```

## Solution

### 解法一

先找出链表中第一个大于或等于 `x` 的结点，然后将之后所有小于 `x` 的节点都置于该结点之后即可：

```java
public ListNode partition(ListNode head, int x) {
    ListNode dummy = new ListNode(-1);
    dummy.next = head;

    ListNode prev = dummy, cur;
    while (prev.next != null && prev.next.val < x) {  // 找出链表中第一个大于或等于x的结点
        prev = prev.next;
    }
    cur = prev;  // 从该结点开始遍历

    while (cur.next != null) {
        if (cur.next.val < x) {  // 小于x的结点
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
```

### 解法二

> 将所有小于给定值的节点取出组成一个新的链表，此时原链表中剩余的节点的值都大于或等于给定值，只要将原链表直接接在新链表后即可

```java
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

    lessCur.next = moreDummy.next;  // 小于x结点作为表头
    moreCur.next = null;            // 原链表作为表尾
    return lessDummy.next;
}
```