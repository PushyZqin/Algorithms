---
export_on_save:
  html: true
---

## 24. 两两交换链表中的节点

## Question

给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。

你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。

示例:

```
给定 1->2->3->4, 你应该返回 2->1->4->3.
```

## Solution

通过建立一个哑结点进行链表的一些操作，操作不是很复杂，但是比较绕，需要画图来理解：

```java
public ListNode swapPairs(ListNode head) {
    ListNode dummy = new ListNode(-1);
    dummy.next = head;

    ListNode cur = dummy;
    while (cur.next != null && cur.next.next != null) {
        ListNode temp = cur.next.next;
        cur.next.next = temp.next;

        temp.next = cur.next;
        cur.next = temp;
        cur = temp.next;
    }
    return dummy.next;
}
```

示意图如下：

步骤1: 未遍历前，创建哑结点指向头结点

![TIM截图20190417202349.png](https://i.loli.net/2019/04/17/5cb71c1c4b2af.png)


步骤2：第一次遍历完成，结点`2`成为了新的头结点

![TIM截图20190417202543.png](https://i.loli.net/2019/04/17/5cb71c327692d.png)

步骤3：交换完成，结点`3`成为了新的尾结点

![TIM截图20190417202850.png](https://i.loli.net/2019/04/17/5cb71c3ce6f47.png)