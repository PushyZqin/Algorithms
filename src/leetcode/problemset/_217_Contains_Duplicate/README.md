---
export_on_save:
  html: true
---

# [217. 存在重复元素](https://leetcode-cn.com/problems/contains-duplicate/)

## Question

给定一个整数数组，判断是否存在重复元素。

如果任何值在数组中出现至少两次，函数返回 true。如果数组中每个元素都不相同，则返回 false。

示例 1:

```java
输入: [1,2,3,1]
输出: true
```

示例 2:

```java
输入: [1,2,3,4]
输出: false
```

## Solution

### 1. 哈希表

借助哈希表（集合）的**不可重复性**，遍历数组在每次放入哈希表中先判断是否已经存在该元素，如果存在则说明具有重复的元素：

```java
public boolean containsDuplicate(int[] nums) {
    if (nums.length < 2) return false;

    Set<Integer> set = new HashSet<>();
    for (int num : nums) {
        if (set.contains(num)) 
            return true;
        else
            set.add(num);
    }
    return false;
}
```

### 2. 数组查找

借助`max`变量来记录遍历到当前元素时前部分数字的最大值，每次遍历都有三种情况：

- 大于：记录当前值到`max`；
- 等于：说明数组有重复元素，返回`true`；
- 小于：说明前部分可能有与当前数组相同点值，从当前位置遍历到`0`查找是否有相同的值。

```java
public boolean containsDuplicate(int[] nums) {
    if (nums.length < 2) return false;

    int max = nums[0];
    for (int i = 1; i < nums.length; i++) {
        if (nums[i] > max) {
            max = nums[i];
        } else if (nums[i] == max) {
            return true;
        } else {
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] == nums[j]) return true;
            }
        }
    }
    return false;
}
```