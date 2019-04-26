# [234. 回文链表](https://leetcode-cn.com/problems/palindrome-linked-list/comments/)

## Question

请判断一个链表是否为回文链表。

示例 1:

```java
输入: 1->2
输出: false
```

示例 2:

```java
输入: 1->2->2->1
输出: true
```

进阶：

你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？

## Solution

对于判断是否是回文类型的结构，找到中心非常重要。然而相比于数组，我们不知道链表的长度，也就无法确定链表的中点，但是我们可以**用快慢指针来定位到链表的中点**。

根据双指针的特性，当快指针到达链表的末尾，**慢指针则指向该链表的中心结点**。然后将慢指针向后移动，并将每个结点都入栈。最后遍历栈中的元素，与头结点往后遍历对比，就可以判断出是否是回文结构的链表。具体代码如下：

```java
public static boolean isPalindrome(ListNode head) {
    if (head == null || head.next == null) return true;  

    ListNode slow = head, fast = head;
    while (fast != null && fast.next != null) {
        slow = slow.next;
        fast = fast.next.next;
    }
    // 当前slow指向的结点即中心结点

    Stack<ListNode> stack = new Stack<>();
    while (slow != null) {
        stack.push(slow);
        slow = slow.next;
    }

    while (!stack.isEmpty()) {
        if (stack.pop().val != head.val) return false;
        head = head.next;
    }
    return true;
}
```

但是似乎效率不尽人意，仅击败了20.12% 的用户：

![TIM截图20190415192712.png](https://i.loli.net/2019/04/15/5cb46a9f1b01c.png)

稍微修改一下逻辑，找到中心结点之后，将中间结点到链表末尾的所有结点翻转，然后让头结点和中间结点开始向后移动，对比它们的结点值是否相等：

```java
public boolean isPalindrome(ListNode head) {
    if (head == null) return true;

    ListNode slow = head;
    ListNode fast = head.next;

    while (fast != null && fast.next != null) {
        slow = slow.next;
        fast = fast.next.next;
    }

    slow = reverse(slow.next);

    while (head != null && slow != null && head.val == slow.val) {
        head = head.next;
        slow = slow.next;
    }
    return slow == null;
}

/**
 * 翻转链表
 */
private ListNode reverse(ListNode head) {
    ListNode prev = null;
    while (head != null) {
        ListNode temp = head.next;
        head.next = prev;
        prev = head;
        head = temp;
    }
    return prev;
}
```

似乎提升了许多：

![TIM截图20190415201627.png](https://i.loli.net/2019/04/15/5cb47629b6f75.png)