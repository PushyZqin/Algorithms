---
export_on_save:
  html: true
---
    
# [100. 相同的树](https://leetcode-cn.com/problems/same-tree/submissions/)
    
## Question

给定两个二叉树，编写一个函数来检验它们是否相同。

如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。

示例 1:

```
输入:       1         1
          / \       / \
         2   3     2   3

        [1,2,3],   [1,2,3]

输出: true
```

示例 2:

```java
输入:      1          1
          /           \
         2             2

        [1,2],     [1,null,2]

输出: false
```

## Solution

和 [101. 对称二叉树](https://leetcode-cn.com/problems/symmetric-tree/) 类似，递归调用判断`t1`左子树与右子树是否分别于`t2`左子树与右子树相等即可：

```java
public boolean isSameTree(TreeNode p, TreeNode q) {
    return equals(p, q);
}

private boolean equals(TreeNode t1, TreeNode t2) {
    if (t1 == null && t2 == null) return true;
    if (t1 == null || t2 == null) return false;

    return t1.val == t2.val
            && equals(t1.left, t2.left) && equals(t1.right, t2.right);
}
```