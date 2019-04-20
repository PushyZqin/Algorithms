---
export_on_save:
  html: true
---

# 35. 搜索插入位置

## Question

给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。

你可以假设数组中无重复元素。

示例 1:

```java
输入: [1,3,5,6], 5
输出: 2
```

示例 2:

```java
输入: [1,3,5,6], 2
输出: 1
```

示例 3:

```java
输入: [1,3,5,6], 7
输出: 4
```

示例 4:

```java
输入: [1,3,5,6], 0
输出: 0
```

## Solution

首先想到的方法是遍历数组，如果有满足`nums[i] > target`时，说明当前遍历的元素是目标值**最大的元素中最小的那个数**，说明目标值则可以被插入到当前的位置。

如果一趟遍历下来没有满足的条件，则说明数组中没有比目标值大的数，只能放到数组的最后：

```java
public int searchInsert(int[] nums, int target) {
    for (int i = 0; i < nums.length; i++) {
        if (nums[i] >= target) {
            return i;
        }
    }
    // 说明数组中没有比目标值大的数，因此只能放到最后
    return nums.length;
}
```

上面的解法虽然简单，但是效率偏低。我们可以用二分法进行优化：

```java
public int searchInsert(int[] nums, int target) {
    int start = 0;
    int end = nums.length - 1;
    
    while (start <= end) {
        int mid = (start + end) / 2;
        if (nums[mid] == target) return mid;
        else if (nums[mid] > target) end = mid - 1;
        else start = mid + 1;
    }
    return start;
}
```