---
export_on_save:
  html: true
---

# [206. 反转链表](https://leetcode-cn.com/problems/reverse-linked-list/solution/)

## Question

反转一个单链表。

**示例**:

```java
输入: 1->2->3->4->5->NULL
输出: 5->4->3->2->1->NULL
```

**进阶**:

你可以迭代或递归地反转链表。你能否用两种方法解决这道题？

## Solution

### 迭代

通过迭代遍历每个结点，更改结点的后继引用，就可以很简单地实现链表的反转。例如初始情况下链表的状态如下图：

![TIM截图20190108140107.png](https://i.loli.net/2019/01/08/5c343fabadaef.png)

第一步，我们头结点`a1`后继指向`NULL`，这表示将来它将成为尾结点。并让`a2`成为头结点：

![TIM截图20190108140350.png](https://i.loli.net/2019/01/08/5c3440abcf6c2.png)

第二步，让头结点`a2`的后继指向`a1`，让`a3`成为头结点：

![TIM截图20190108140522.png](https://i.loli.net/2019/01/08/5c34400b01f33.png)

最后，让头结点`a3`的后继指向`a2`。此时，`pre`便成为了新的反转链表的头结点：

![TIM截图20190108140649.png](https://i.loli.net/2019/01/08/5c3441b9ae58d.png)

具体代码实现为：

```java
public ListNode reverseList(ListNode head) {
    if (head == null || head.next == null) return head;

    ListNode cur = head, prev = null;
    while (cur != null) {
        ListNode tempNext = cur.next;
        cur.next = prev;
        prev = cur;
        cur = tempNext;
    }
    return prev;
}
```

### 递归

从尾结点开始，逆向反转各个结点的指针域指向：

![TIM截图20190415174239.png](https://i.loli.net/2019/04/15/5cb452194d8f6.png)

```java
public ListNode reverseList(ListNode head) {
    if (head == null || head.next == null) return head;

    ListNode reHead = reverseList(head.next);

    head.next.next = head;
    head.next = null;

    return reHead;
}
```