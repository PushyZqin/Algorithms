---
export_on_save:
  html: true
---

# [257. 二叉树的所有路径](https://leetcode-cn.com/problems/binary-tree-paths/)

## Question

给定一个二叉树，返回所有**从根节点到叶子节点的路径。**

说明: 叶子节点是指没有子节点的节点。

示例:

```java
输入:

   1
 /   \
2     3
 \
  5

输出: ["1->2->5", "1->3"]

解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3
```

## Solution

题中要求返回的所有路径为：根结点到所有**叶结点**的路径，而不是每条子路径。因此只有在递归调用发现左右子结点都为空时（叶子）才添加到结果列表中：

```java
public List<String> binaryTreePaths(TreeNode root) {
    List<String> res = new ArrayList<>();
    findPath(root, "", res);
    return res;
}

public void findPath(TreeNode root, String path, List<String> res) {
    if (root == null) return;
    if (root.left == null && root.right == null) { // 到达根结点，说明走完一条路径
        res.add(path + root.val);
    }
    String p = path + root.val + "->";  // 拼接从根结点到当前节点的路径
    findPath(root.left, p, res);
    findPath(root.right, p, res);
}
```