---
export_on_save:
  html: true
---
    
# [104. 二叉树的最大深度](https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/solution/)
    
## Question

给定一个二叉树，找出其最大深度。

二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。

说明: 叶子节点是指没有子节点的节点。

示例：

```java
给定二叉树 [3,9,20,null,null,15,7]，

    3
   / \
  9  20
    /  \
   15   7
返回它的最大深度 3 。
```

## Solution

### 1. 递归

```java
public int maxDepth(TreeNode root) {
    if (root == null) return 0;

    int hl = maxDepth(root.left);   // 左子树深度
    int hr = maxDepth(root.right);  // 右子树深度

    // 递归执行到这说明该结点的左右子树都为空，即为叶子

    return Math.max(hl, hr) + 1;    // 取左右子树较大的深度
}
```

### 2. 迭代

通过层序遍历（广度优先搜索）来求出二叉树的最大深度：

```java
public int maxDepth(TreeNode root) {
    if (root == null) return 0;

    Queue<TreeNode> queue = new LinkedList<>();
    int depth = 0;

    queue.offer(root);
    while (!queue.isEmpty()) {
        int size = queue.size();
        while (size-- != 0) {  // 把当前层所有结点的子结点都放入队列中
            TreeNode node = queue.poll();
            if (node.left != null) queue.offer(node.left);
            if (node.right != null) queue.offer(node.right);
        }
        depth++;
    }
    return depth;
}
```