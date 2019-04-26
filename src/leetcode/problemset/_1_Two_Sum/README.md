---
export_on_save:
  html: true
---

# [1. 两数之和](https://leetcode-cn.com/problems/two-sum/)

## Question

给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。

你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。

示例:

```java
给定 nums = [2, 7, 11, 15], target = 9

因为 nums[0] + nums[1] = 2 + 7 = 9
所以返回 [0, 1]
```

## Solution

在该例子中，如果仅仅只是想在有解决方法时返回`true`时，我们可以使用哈希集合来存储迭代数组时所有值，并检查`target - curret_value`是否在哈希集合中。

但是如果我们被要求获取更多信息（如本题中需要返回索引值）。那么我们可以使用哈希映射来存储元素对应的索引值。

除此之外，本题还需要掌握的技巧是，可以通过哈希表还替代双循环。本题最简单的方法是可以通过暴力破解法穷举出可行的元素：

```java
public int[] twoSum(int[] nums, int target) {
    for (int i = 0; i < nums.length; i++) {
        for (int j = i + 1; j < nums.length; j++) {
            if (nums[j] == target - nums[i]) {
                return new int[] { i, j };
            }
        }
    }
    throw new IllegalArgumentException("No two sum solution");
}
```

采用暴力破解法时间的复杂度较高，但是并不是最优解。我们可以**用哈希表来维护数组中每个元素与其索引相互对应的关系**，采用更加高效的检查数组中是否存在目标元素的方法：

```java
public int[] twoSum(int[] nums, int target) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
        int n = target - nums[i];
        if (map.containsKey(n)) { // 检查是否找到了当前元素符合的目标元素
            return new int[] { map.get(n), i };
        }
        map.put(nums[i], i); // 如果没有，则将元素添加到哈希表中
    }
    throw new IllegalArgumentException("No two sum solution");
}
```
