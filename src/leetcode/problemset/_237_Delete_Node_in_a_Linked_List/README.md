---
export_on_save:
  html: true
---

# [237. 删除结点](https://leetcode-cn.com/problems/delete-node-in-a-linked-list/)

## Question

![UTOOLS1556094817648.png](https://i.loli.net/2019/04/24/5cc01f62b98bd.png)

说明:

- 链表至少包含两个节点。
- 链表中所有节点的值都是唯一的。
- 给定的节点为非末尾节点并且一定是链表中的一个有效节点。
- 不要从你的函数中返回任何结果。

## Solution

实现的方式非常巧妙：

```java
public void deleteNode(ListNode node) {
    node.val = node.next.val;      // 将该结点的值设置为后继的值
    node.next = node.next.next;    // 删除后继结点
}
```