---
 export_on_save:
   html: true
---

# [112. 路径总和](https://leetcode-cn.com/problems/path-sum/)

## Question

给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。

说明: 叶子节点是指没有子节点的节点。

示例: 
给定如下二叉树，以及目标和 `sum = 22`，

```java
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \      \
        7    2      1
```

返回 true, 因为存在目标和为 22 的根节点到叶子节点的路径 `5->4->11->2`。

## Solution

### 1. 递归

通过递归调用减去 `sum` 的值，那么到叶结点时，如果该结点的值和 `sum` 值相同，则说明路径上的和与目标和相等：

```java
public boolean hasPathSum(TreeNode root, int sum) {
    if (root == null) return false;
    if (root.left == null && root.right == null && root.val == sum)
        return true;

    return hasPathSum(root.left, sum - root.val)
            || hasPathSum(root.right, sum - root.val);
}
```

### 2. 迭代

迭代实现：通过广度优先遍历（层序），将各子树结点上的值修改为：**父结点的值 + 当前结点的值**：

```java
public boolean hasPathSum(TreeNode root, int sum) {
    if (root == null) return false;

    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);

    while (!queue.isEmpty()) {
        TreeNode cur = queue.poll();
        if (cur.left == null && cur.right == null) { // 叶子
            if (cur.val == sum) return true;
        }
        if (cur.left != null) {  // 修改左结点的值并入队
            cur.left.val += cur.val;
            queue.offer(cur.left);
        }
        if (cur.right != null) {  // 修改右结点的值并入队
            cur.right.val = cur.val;
            queue.offer(cur.right);
        }
    }
    return false;
}
```