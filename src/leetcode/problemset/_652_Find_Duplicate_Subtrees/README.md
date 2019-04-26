---
export_on_save:
  html: true
---
    
# [652. 寻找重复的子树](https://leetcode-cn.com/problems/find-duplicate-subtrees/comments/)

## Question

给定一棵二叉树，返回所有重复的子树。对于同一类的重复子树，你只需要返回其中任意一棵的根结点即可。

两棵树重复是指**它们具有相同的结构以及相同的结点值。**

示例 1：

```java
        1
       / \
      2   3
     /   / \
    4   2   4
       /
      4
```

下面是两个重复的子树：

```java
      2
     /
    4
```

和

```java
    4
```

因此，你需要以列表的形式返回上述重复子树的根结点。

## Solution

首先理解题意，重复的子树是指**具有相同的结构以及相同的结点值**。以示例来看，`2->4`出现了两次，`4`出现了三次，因此返回的就是这两个子树的列表。

我们通过后序遍历的递归调用，将路径序列化为字符串，并用哈希表来记录某个子树路径与其出现参数的映射关系。当哈希表中已经出现某个序列化路径字符串时，说明之前已经出现过相同的子树，添加到列表中即可：

```java
public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
    Map<String, Integer> map = new HashMap<>();
    List<TreeNode> res = new ArrayList<>();

    postorder(root, res, map);
    return res;
}

/**
 * 后序遍历，将路径作为map的key，路径的出现次数作为value
 */
private String postorder(TreeNode root, List<TreeNode> res, Map<String, Integer> map) {
    if (root == null) return "#";

    String leftPath = postorder(root.left, res, map);
    String rightPath = postorder(root.right, res, map);
    String path = root.val + leftPath + rightPath;

    if (map.getOrDefault(path, 0) == 1)
        res.add(root);  // 之前出现过相同的子树结构
    map.put(path, map.getOrDefault(path, 0) + 1);
    return path;
}
```

我们可以`map`的结果，发现路径`24###=2`与`4##`出现次数刚好与实例中两个重复的子树对应：

```java
{
  4## = 3, 
  124###324###4## = 1, 
  24### = 2, 
  324###4## = 1
}
```