---
export_on_save:
html: true
---

# [104. 二叉树的最大深度](https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/)

## Question

给定一个二叉树，找出其最小深度。

最小深度是从根节点到最近叶子节点的最短路径上的节点数量。

说明: 叶子节点是指没有子节点的节点。

示例:

给定二叉树 `[3,9,20,null,null,15,7]`,

```java
    3
   / \
  9  20
    /  \
   15   7
```

返回它的最小深度  2.

## Solution

该题需要注意是题中说的“最小深度”为：从根节点到**最近叶子节点**的最短路径上的节点数量。因此对于子树：

```java
    1
   /
  2
```

最小深度应该为`2`，因为结点`2`才是离根结点最近的叶结点。所以递归调用时则要考虑这种情况：

```java
public int minDepth(TreeNode root) {
    return min(root);
}

public int min(TreeNode root) {
    if (root == null) return 0;
    if (root.left == null && root.right == null) return 1;

    if (root.left == null)
        return min(root.right) + 1;
    if (root.right == null)
        return min(root.left) + 1;

    // 对左子树的最小深度与右子树的最小深度取最小值
    return Math.min(min(root.right), min(root.right)) + 1;
}
```