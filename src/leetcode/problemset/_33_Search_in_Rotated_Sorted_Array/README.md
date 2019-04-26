---
export_on_save:
  html: true
---
    
# [33. 搜索旋转排序数组](https://leetcode-cn.com/problems/search-in-rotated-sorted-array/comments/)
    
## Question

假设按照升序排序的数组在预先未知的某个点上进行了旋转。

( 例如，数组 `[0,1,2,4,5,6,7]` 可能变为 `[4,5,6,7,0,1,2]` )。

搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。

你可以假设数组中不存在重复的元素。

**你的算法时间复杂度必须是 O(log n) 级别。**

示例 1:

```java
输入: nums = [4,5,6,7,0,1,2], target = 0
输出: 4
```

示例 2:

```java
输入: nums = [4,5,6,7,0,1,2], target = 3
输出: -1
```

## Solution

由题中可以知道，因为排序的数组旋转过，所以可能当前元素不一定小于右边元素（以及不一定大于左边元素），导致普通的二分法无法直接缩短区间。所以需要分开情况讨论，通过判断`mid`与`right`指针所指的元素大小，区分两种情况。哪两种情况呢？

- 第一：`mid`右边不是单调递增，如下：

```java
left        mid        right
 ↓           ↓           ↓
 4   5   6   7   0   1   2
```

- 第二：`mid`右边是单调递增，如下：

```java
               left mid right
                 ↓   ↓   ↓
 4   5   6   7   0   1   2
```

```java
public int search(int[] nums, int target) {
    int l = 0, r = nums.length - 1;

    while (l <= r) {
        int mid = l + (r - l) / 2;

        if (nums[mid] == target) return mid;

        if (nums[mid] < nums[r]) { // mid右边区间是单调递增的吗
            if (nums[mid] < target && target <= nums[r]) l = mid + 1;
            else r = mid - 1;
        }

        else {  // 右边区间不是单调的
            if (nums[mid] > target && target >= nums[l]) r = mid - 1;
            else l = mid + 1;
        }
    }
    return -1;
}
```