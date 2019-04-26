---
export_on_save:
  html: true
---

# [160. 相交链表](https://leetcode-cn.com/explore/learn/card/linked-list/194/two-pointer-technique/746/)

## Question

编写一个程序，找到两个单链表相交的起始节点。

如下面的两个链表：

![](https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2018/12/14/160_statement.png)

在节点 c1 开始相交。

示例 1：

![](https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2018/12/14/160_example_1.png)

```java
输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
输出：Reference of the node with value = 8
输入解释：相交节点的值为 8 （注意，如果两个列表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,0,1,8,4,5]。在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。
``` 

示例 2：

![](https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2018/12/14/160_example_2.png)

```java
输入：intersectVal = 2, listA = [0,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
输出：Reference of the node with value = 2
输入解释：相交节点的值为 2 （注意，如果两个列表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [0,9,1,2,4]，链表 B 为 [3,2,4]。在 A 中，相交节点前有 3 个节点；在 B 中，相交节点前有 1 个节点。

``` 

示例 3：

![](https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2018/12/14/160_example_3.png)

```java
输入：intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
输出：null
输入解释：从各自的表头开始算起，链表 A 为 [2,6,4]，链表 B 为 [1,5]。由于这两个链表不相交，所以 intersectVal 必须为 0，而 skipA 和 skipB 可以是任意值。
解释：这两个链表不相交，因此返回 null。
``` 

注意：

- 如果两个链表没有交点，返回 null.
- 在返回结果后，两个链表仍须保持原有的结构。
- 可假定整个链表结构中没有循环。
- 程序尽量满足 O(n) 时间复杂度，且仅用 O(1) 内存。

## Solution

暴力破解法，可以实现但是效率极低：

```java
public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    ListNode curA = headA;
    ListNode curB;

    while (curA != null) {
        curB = headB;
        while (curB != null) {
            if (curA == curB) return curA;
            curB = curB.next;
        }
        curA = curA.next;
    }
    return null;
}
```

参考了高票解答：

>定义两个指针, 第一轮让两个到达末尾的节点指向另一个链表的头部, 最后如果相遇则为交点(在第一轮移动中恰好抹除了长度差)两个指针等于移动了相同的距离, 有交点就返回, 无交点就是各走了两条指针的长度

```java
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;

        ListNode pA = headA, pB = headB;
        // 在这里第一轮体现在pA和pB第一次到达尾部会移向另一链表的表头
        // 而第二轮体现在如果pA或pB相交就返回交点, 不相交最后就是null==null
        while(pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }
}
```

### 双指针

另外还有一种双指针的做法，这种处理方式非常巧妙。先将链表B构成环，即让**链表尾节点指向头结点**。此时，链表B构成了环状链表，而链表的入环点`8`即为两链表的相交点：

![160_example_1.png](https://i.loli.net/2019/04/15/5cb448c42402d.png)

因此找到入环点就可以了，找到入环点的方法可以参考 [环形链表 II](https://github.com/pushyzheng/Algorithms/tree/master/src/site/pushy/algorithms/leetcode/explore/linkedList/detectCycle)，具体代码如下：

```java
public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
    if (headA == null || headB == null) return null;

    ListNode last = headB;
    while (last.next != null) {
        last = last.next;
    }
    last.next = headB;  // 构成环状链表

    ListNode slow = headA, fast = headA;
    while (fast != null && fast.next != null) {
        slow = slow.next;
        fast = fast.next.next;

        if (slow == fast) { // 两指针相遇
            slow = headA;
            while (slow != fast) {
                slow = slow.next;
                fast = fast.next;
            }
            last.next = null;  // 去除环状链表
            return fast;
        }
    }
    last.next = null;
    return null;
}
```