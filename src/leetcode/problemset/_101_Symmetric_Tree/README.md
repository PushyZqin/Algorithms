---
export_on_save:
  html: true
---
    
# [101. 对称二叉树](https://leetcode-cn.com/problems/symmetric-tree/submissions/)
    
## Question

给定一个二叉树，检查它是否是镜像对称的。

例如，二叉树 `[1,2,2,3,4,4,3]` 是对称的。

```java
    1
   / \
  2   2
 / \ / \
3  4 4  3
```

但是下面这个 `[1,2,2,null,3,null,3]` 则不是镜像对称的:

```java
    1
   / \
  2   2
   \   \
   3    3
```

说明:

如果你可以运用递归和迭代两种方法解决这个问题，会很加分。

## Solution

### 1. 递归

判断一个树是否镜像，需要判断其左右子树的情况：

- 左右子树都为空：左右子树镜像；

- 左右子树其中一个为空：左右子树不镜像；

- 左右子树都不为空，要求**左子树的右结点与右子树的左结点值相等，左子树的左结点与右子树的右结点值相等**。

递归写法如下：

```java
public boolean isSymmetric(TreeNode root) {
    return isSymmetric(root, root);
}

public boolean isSymmetric(TreeNode left, TreeNode right) {
    if (left == null && right == null) return true;   // 左右子树都为空，为镜像
    if (left == null || right == null) return false;  // 左右子树其中一个为空，不是镜像

    return left.val == right.val
            && isSymmetric(left.left, right.right)
            && isSymmetric(left.right, right.left);
}
```

### 2. 迭代

与递归相同的思路：

```java
public boolean isSymmetric2(TreeNode root) {
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    queue.offer(root);

    while (!queue.isEmpty()) {
        TreeNode t1 = queue.poll();
        TreeNode t2 = queue.poll();

        if (t1 == null && t2 == null) continue;
        if (t1 == null || t2 == null) return false;
        if (t1.val != t2.val) return false;

        // 将左子树的左结点与右子树的右结点比较
        queue.offer(t1.left);
        queue.offer(t2.right);

        // 将左子树的右结点与右子树的左结点比较
        queue.offer(t1.right);
        queue.offer(t2.left);
    }
    return true;
}
```