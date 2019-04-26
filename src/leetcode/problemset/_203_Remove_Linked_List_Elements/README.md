---
export_on_save:
  html: true
---

# [203. 移除链表元素](https://leetcode-cn.com/problems/remove-linked-list-elements/submissions/)

## Question

删除链表中等于给定值 val 的所有节点。

示例:

```java
输入: 1->2->6->3->4->5->6, val = 6
输出: 1->2->3->4->5
```

## Solution

删除操作还是需要通过哑结点来简化操作，遍历链表当发现下一个结点和目标值相同，则删除下一个结点即可：

```java
public ListNode removeElements(ListNode head, int val) {
    if (head == null) return null;

    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode prev = dummy;

    while (prev.next != null) {
        if (prev.next.val == val)
            prev.next = prev.next.next; // 删除下一个结点
        else
            prev = prev.next;
    }
    return dummy.next;
}
```

或者通过递归来实现：

```java
public ListNode removeElements(ListNode head, int val) {
    if (head == null) return null;

    head.next = removeElements(head.next, val);
    return head.val == val ? head.next : head;
}
```