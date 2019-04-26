---
export_on_save:
  html: true
---

# 142. 环形链表 II

## Question

给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。

为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。

说明：不允许修改给定的链表。

![](https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2018/12/07/circularlinkedlist.png)

示例 1：

```
输入：head = [3,2,0,-4], pos = 1
输出：tail connects to node index 1
解释：链表中有一个环，其尾部连接到第二个节点。
```

示例 2：

```
输入：head = [1,2], pos = 0
输出：tail connects to node index 0
解释：链表中有一个环，其尾部连接到第一个节点。
```

![](https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2018/12/07/circularlinkedlist_test2.png)

进阶：

- 你是否可以不用额外空间解决此题？

## Solution

参考了 [LeetCode(Python3)——142. 环形链表 II](https://blog.csdn.net/Heitao5200/article/details/84994161) 的解题思路。

![2019-04-14_121627.png](https://i.loli.net/2019/04/14/5cb2b53de26d5.png)

具体的算法代码为如下，

```java
public ListNode detectCycle(ListNode head) {
    if (head == null || head.next == null) return null;

    ListNode slow = head, fast = head; 
    // 找到相遇点，和 hayCycle 题代码相同
    while (fast != null && fast.next != null) {
        slow = slow.next;
        fast = fast.next.next;
        if (slow == fast) {
            break;
        }
    }

    if (fast == null || fast.next == null) {
        return null;
    }

    // fast指针到入口的距离 = head到环入口的距离
    slow = head;
    while (fast != slow) {
        slow = slow.next;
        fast = fast.next;
    }
    // fast == slow，快指针和慢指针在入口点相遇
    return slow;
}
```