---
export_on_save:
  html: true
---
    
# [34. 在排序数组中查找元素的第一个和最后一个位置](https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/)
    
## Question

给定一个**按照升序排列的整数数组** `nums`，和一个目标值 `target`。找出给定目标值在数组中的开始位置和结束位置。

你的算法时间复杂度必须是 `O(log n)` 级别。

如果数组中不存在目标值，返回 `[-1, -1]`。

示例 1:

```java
输入: nums = [5, 7, 7, 8, 8, 10], target = 8
输出: [3, 4]
```

示例 2:

```java
输入: nums = [5, 7, 7, 8, 8, 10], target = 6
输出: [-1, -1]
```

## Solution

该题的关键是：先通过查找到任意一个等于目标值的元素，并将左右指针都指向该索引；然后再线性查找，找到这些相邻的相同元素中第一个出现和最后一个出现的元素：

```java
public int[] searchRange(int[] nums, int target) {
    if (nums == null || nums.length == 0) return new int[]{-1, -1};
    if (nums.length == 1) {
        if (nums[0] == target) return new int[]{0, 0};
        else return new int[]{-1, -1};
    }

    // 二分查找
    int l = 0, r = nums.length - 1;
    while (l + 1 < r) {
        int mid = l + (r - l) / 2;
        if (nums[mid] < target) l = mid;
        else if (nums[mid] > target) r = mid;
        else {
            l = mid;
            r = mid;
            break;
        }
    }

    // 开始线性查找
    while (l >= 0 && nums[l] == target) l--;
    while (r < nums.length && nums[r] == target) r++;
    l++;
    r--;

    if (nums[l] == target && nums[r] == target) return new int[]{l, r};
    return new int[]{-1, -1};
}
```