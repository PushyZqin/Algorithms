# 141. 环形链表

## Question

给定一个链表，判断链表中是否有环。

为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。

示例 1：

```java
输入：head = [3,2,0,-4], pos = 1
输出：true
解释：链表中有一个环，其尾部连接到第二个节点。
```

![](https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2018/12/07/circularlinkedlist.png)

示例 2：

```java
输入：head = [1,2], pos = 0
输出：true
解释：链表中有一个环，其尾部连接到第一个节点。
```

![](https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2018/12/07/circularlinkedlist_test2.png)

示例 3：

```java
输入：head = [1], pos = -1
输出：false
解释：链表中没有环。
```

![](https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2018/12/07/circularlinkedlist_test3.png)

进阶：

你能用 O(1)（即，常量）内存解决此问题吗？

## Solution

### 哈希表

最简单的方法是借助哈希表，来通过**检查一个结点此前是否被访问过来判断链表是否为环形链表**，如果当前的结点已存在于哈希表中，则说明之前出现过该结点，也就说明该链表有环：

```java
public boolean hasCycle(ListNode head) {
    if (head == null || head.next == null) return false;

    Set<ListNode> set = new HashSet<>();
    while (head != null) {
        if (set.contains(head)) { // 有环
            return true;
        } else {
            set.add(head);
        }
        head = head.next;
    }
    return false;
}
```

### 双指针

通过双指针技巧，考虑链表中的两种情况：

- 当没有环时，**快指针会优先到达表尾**，即满足`fast == null || fast.next == null`条件；

- 当有环时，快指针到达表尾后会继续通过环回到入环点，因为快指针的速度是慢指针的两倍，因此**两指针总会相遇**，如果相遇（此时快慢指针结点相同）则说明链表有环。

```java
public boolean hasCycle(ListNode head) {
    if (head == null || head.next == null) return false;

    ListNode slow = head, fast = head;
    while (fast != null && fast.next != null) {
        slow = slow.next;
        fast = fast.next.next;
        if (slow == fast) {  
            // 如果存在环，慢指针和快指针刚好相遇，说明是个环形链表
            return true;
        }
    }
    // 如果不存在环，那么最终快指针将会最先到达尾部
    return false;
}
```