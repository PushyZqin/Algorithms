---
export_on_save:
  html: true
---

# [543. 二叉树的直径](https://leetcode-cn.com/problems/diameter-of-binary-tree/submissions/)

## Question

给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过根结点。

示例 :

给定二叉树

```java
          1
         / \
        2   3
       / \     
      4   5    
```

返回 3, 它的长度是路径 [4,2,1,3] 或者 [5,2,1,3]。

注意：两结点之间的路径长度是以它们之间边的数目表示。

## Solution

因为可能存在最大长度的路径**不经过根结点情况**，有可能存在于某子树当中。所以需要用`max`来记录：

```java
class Solution {

    private int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
        return max;
    }

    private int maxDepth(TreeNode root) {
        if (root == null) return 0;

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        max = Math.max(max, left + right);
        
        return Math.max(left, right) + 1;
    }
}
```