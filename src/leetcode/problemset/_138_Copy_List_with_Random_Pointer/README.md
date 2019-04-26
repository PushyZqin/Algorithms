---
export_on_save:
  html: true
---

# [138. 复制带随机指针的链表](https://leetcode-cn.com/problems/copy-list-with-random-pointer/)

## Question

给定一个链表，每个节点包含一个额外增加的随机指针，该指针可以指向链表中的任何节点或空节点。

要求返回这个链表的深拷贝。 

示例：

```
输入：
{"$id":"1","next":{"$id":"2","next":null,"random":{"$ref":"2"},"val":2},"random":{"$ref":"2"},"val":1}

解释：
节点 1 的值是 1，它的下一个指针和随机指针都指向节点 2 。
节点 2 的值是 2，它的下一个指针指向 null，随机指针指向它自己。
```
 
提示：

1. 你必须返回给定头的拷贝作为对克隆列表的引用。

## Solution

该题深拷贝的难点在于如何处理随机指针的问题，我们可以用一个哈希表来存放**旧结点和克隆结点的映射关系**：第一次遍历生成所有的克隆结点，同时通过哈希表建立起原结点和克隆结点的映射；第二次遍历给随机指针赋值时，只需要从哈希表中查找出克隆结点即可：

```java
public Node copyRandomList(Node head) {
    if (head == null) return null;

    Node newHead = new Node(head.val, null, null); // 克隆链表头结点
    Node oldHead = head.next;
    Map<Node, Node> map = new HashMap<>();  // 用来保存旧结点与新结点的映射
    map.put(head, newHead);

    Node cur = newHead;
    while (oldHead != null) { // 克隆新的结点
        Node clone = new Node(oldHead.val, null, null);
        cur.next = clone;
        map.put(oldHead, clone); // 添加映射
        oldHead = oldHead.next;
        cur = cur.next;
    }

    cur = newHead;
    while (head != null) { // 处理random指针
        if (head.random != null) {
            cur.random = map.get(head.random);
        }
        head = head.next;
        cur = cur.next;
    }
    return newHead;
}
```

示意图如下：

步骤1: 初始状态

![](https://i.loli.net/2019/04/16/5cb5d99543bdc.png)

步骤2：创建出新的克隆头结点

![TIM截图20190416212821.png](https://i.loli.net/2019/04/16/5cb5d9b1dc244.png)

步骤3：创建出另一个克隆结点，并将头结点的`next`指向该结点

![TIM截图20190416212949.png](https://i.loli.net/2019/04/16/5cb5d9c998199.png)

步骤4：从哈希表中获取到刚才创建的第二个克隆结点，将克隆的头结点`random`指向它：

![TIM截图20190416213041.png](https://i.loli.net/2019/04/16/5cb5d9d54c17c.png)

步骤5: 获取到第二个结点的`random`指向的结点（即本身）

![TIM截图20190416213134.png](https://i.loli.net/2019/04/16/5cb5d9e342eb5.png)