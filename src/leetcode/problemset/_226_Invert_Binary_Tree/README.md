---
export_on_save:
  html: true
---

# [226. 翻转二叉树](https://leetcode-cn.com/problems/invert-binary-tree/comments/)

## Question

翻转一棵二叉树。

示例：

输入：

```java
     4
   /   \
  2     7
 / \   / \
1   3 6   9
```

输出：

```java
     4
   /   \
  7     2
 / \   / \
9   6 3   1
```


## Solution

将左子树与右子树相互交换后，递归调用`invertTree`继续左结点与右结点的子树互换：

```java
public TreeNode invertTree(TreeNode root) {
    if (root == null) return null;
    if (root.left == null && root.right == null) return root;

    TreeNode temp = root.left;
    root.left = root.right;
    root.right = temp;

    invertTree(root.left);
    invertTree(root.right);
    return root;
}
```