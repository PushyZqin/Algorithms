---
export_on_save:
  html: true
---

# [328. 奇偶链表](https://leetcode-cn.com/problems/odd-even-linked-list/)

## Question

给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。

请尝试使用原地算法完成。你的算法的空间复杂度应为 O(1)，时间复杂度应为 O(nodes)，nodes 为节点总数。

示例 1:

```java
输入: 1->2->3->4->5->NULL
输出: 1->3->5->2->4->NULL
```

示例 2:

```java
输入: 2->1->3->5->6->4->7->NULL 
输出: 2->3->6->7->1->5->4->NULL
```
说明:

- 应当保持奇数节点和偶数节点的相对顺序。
- 链表的第一个节点视为奇数节点，第二个节点视为偶数节点，以此类推。

## Solution

新建一个偶链表`evenHead`并始终指向偶链表的头部，隔一个取出一个结点偶序数的结点放进去，则原链表剩下的都是奇序数结点的链表，最后将两个链表拼接起来则为结果。

具体做法为用`odd`和`even`分割链表，使得`odd`的后序结点均为奇序数结点，`even`后序结点均为偶序数结点。最后`odd`与`even`分别指向奇偶链表的尾结点。拼接则将奇链表的尾结点指向偶链表的头结点即可：

```java
public ListNode oddEvenList(ListNode head) {
    if (head == null || head.next == null) return head;

    ListNode odd = head, even = head.next;
    ListNode evenHead = even; // 始终指向偶链表的头结点
    while (even != null && even.next != null) {
        odd.next = even.next;
        odd = odd.next;

        even.next = odd.next;
        even = even.next;
    }
    odd.next = evenHead;  // 拼接
    return head;
}
```

示意图如下：

![TIM图片20190416110637.jpg](https://i.loli.net/2019/04/16/5cb5474d3226c.jpg)