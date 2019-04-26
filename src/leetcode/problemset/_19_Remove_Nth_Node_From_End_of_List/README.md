---
export_on_save:
  html: true
---

# [19. 删除链表的倒数第N个节点](https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/solution/)

## Question

给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。

示例：

```java
给定一个链表: 1->2->3->4->5, 和 n = 2.

当删除了倒数第二个节点后，链表变为 1->2->3->5.
```
**说明**：

给定的 n 保证是有效的。

**进阶**：

你能尝试使用一趟扫描实现吗？

## Solution

### 两趟扫描

题目要求删除链表的倒数第 n 个节点，假设直到链表的长度为L，则要删除的结点即为：第`L - n + 1`个结点。因此使用两趟扫描：

- 第一趟计算出链表的长度`l`；
- 第二趟删除第`l - n + 1`的目标删除结点。

```java
public ListNode removeNthFromEnd(ListNode head, int n) {
    if (n == 0) return head;

    ListNode cur = head;
    int l = 0; // 链表的长度
    while (cur != null) { // 计算链表的长度
        cur = cur.next;
        l++;
    }

    if (n > l) return head;        // 不合理的删除位置
    if (n == l) return head.next;  // 删除的是头结点

    int i = 0;
    cur = head;
    while (i < l - n - 1) { // 找到第l-n个前驱结点
        cur = cur.next;
        i++;
    }
    cur.next = cur.next.next;  // 删除结点
    return head;
}
```

可以看到，我们对`n == l`做了特殊的操作，因为删除头结点的需要特殊考虑，使用特殊的删除方式。为了简化这种极端的情况，统一删除的操作，我们可以通过一个哑结点来解决。

新建一个哑结点作为链表的头部，而哑结点的后继才是真正的头结点`head`，所以最后返回了`dummy.next`：

```java
public ListNode removeNthFromEnd(ListNode head, int n) {
    ListNode dummy = new ListNode(0);
    dummy.next = head;

    int l = 0;
    ListNode cur = head;
    while (cur != null) {
        l++;
        cur = cur.next;
    }

    l -= n;
    cur = dummy;
    while (l > 0) {
        l--;
        cur = cur.next;
    }
    cur.next = cur.next.next;
    return dummy.next;
}
```

### 双指针

这题我们可以用双指针来实现，先让快指针先移动`n`个单位，然后让快指针和慢指针以**相同的单位**移动。**当快指针指向链表尾结点时，慢指针指向的结点则为目标删除的结点的前驱**：

```java
public ListNode removeNthFromEnd(ListNode head, int n) {
    if (head == null) return null;

    ListNode slow = head, fast = head;
    for (int i = 0; i < n; i++) { // 先让快指针先移动n个单位
        fast = fast.next;
    }
    // 如果删除的是头结点，直接返回头结点的后继
    if (fast == null) return head.next;

    // 快慢指针移动，让slow指向目标结点的前驱
    while (fast.next != null) { 
        fast = fast.next;
        slow = slow.next;
    }
    slow.next = slow.next.next;  // 删除结点
    return head;
}
```

如下：

![TIM截图20190415125018.png](https://i.loli.net/2019/04/15/5cb40d98335f4.png)

可以看到，上面的代码我们又对删除的是头结点做了特殊的判断，同样可以用哑结点来简化操作：

```java
public ListNode removeNthFromEnd2(ListNode head, int n) {
    ListNode dummy = new ListNode(0);
    dummy.next = head;

    ListNode slow = dummy, fast = dummy;
    for (int i = 0; i < n; i++) {
        fast = fast.next;
    }

    while (fast.next != null) {
        slow = slow.next;
        fast = fast.next;
    }
    slow.next = slow.next.next;
    return dummy.next;
}
```