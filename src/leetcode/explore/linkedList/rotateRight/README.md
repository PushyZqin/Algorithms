---
export_on_save:
  html: true
---

# [61. 旋转链表](https://leetcode-cn.com/problems/rotate-list/)

## Quesiton

给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。

示例 1:

```java
输入: 1->2->3->4->5->NULL, k = 2
输出: 4->5->1->2->3->NULL
解释:
向右旋转 1 步: 5->1->2->3->4->NULL
向右旋转 2 步: 4->5->1->2->3->NULL
```

示例 2:

```java
输入: 0->1->2->NULL, k = 4
输出: 2->0->1->NULL
解释:
向右旋转 1 步: 2->0->1->NULL
向右旋转 2 步: 1->2->0->NULL
向右旋转 3 步: 0->1->2->NULL
向右旋转 4 步: 2->0->1->NULL
```

## Solution

这题的本质是**将尾部向前第K个元素作为头，并将原来的头接到原来的尾上。**

首先，我们需要找到倒数第`K`个元素的（新链表的头结点）前驱，通过双指针可以很容易找到。但是需要注意的是，本题所给的`k`值可能会大于链表长度，因此真正旋转的单位应该是`k % length`。所以我们通过一趟遍历先求出链表的长度。

求出链表长度之后很容易就可能找到**倒数第K个结点的前驱**（新链表的尾结点），将它的后继设置为`NULL`。最后**将原来的尾结点与原来的头结点相连即可**：

```java
public static ListNode rotateRight(ListNode head, int k) {
    if (k == 0 || head == null || head.next == null) return head;

    int length = 0;
    ListNode cur = head;
    while (cur != null) {  // 计算出链表的长度
        cur = cur.next;
        length++;
    }
    if (k % length == 0) return head;
    int n = length - (k % length); // 旋转的单位

    ListNode tail = head;
    for (int i = 0; i < n - 1; i++) { // 找到新的尾结点前驱
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
```

操作的结果如下：

![TIM截图20190417102726.png](https://i.loli.net/2019/04/17/5cb68f167d609.png)