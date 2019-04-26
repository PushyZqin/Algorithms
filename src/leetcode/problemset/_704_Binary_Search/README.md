---
export_on_save:
  html: true
---
    
# [704. 二分查找](https://leetcode-cn.com/problems/binary-search/)
    
## Question

给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。

示例 1:

```java
输入: nums = [-1,0,3,5,9,12], target = 9
输出: 4
解释: 9 出现在 nums 中并且下标为 4
```

提示：

- 你可以假设 `nums` 中的所有元素是不重复的。
- `n` 将在 `[1, 10000]` 之间。
- `nums` 的每个元素都将在 `[-9999, 9999]` 之间。

## Solution

最经典的二分查找应用：

```java
public int search(int[] nums, int target) {
    if (nums == null || nums.length == 0) return -1;

    int left = 0, right = nums.length - 1;
    while (left <= right) {
        int mid = left + (right - left) / 2;
        if (nums[mid] < target)
            left = mid + 1;
        else if (nums[mid] > target)
            right = mid - 1;
        else
            return mid;
    }
    return -1;
}
```