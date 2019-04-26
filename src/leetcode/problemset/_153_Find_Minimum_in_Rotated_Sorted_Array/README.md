---
export_on_save:
  html: true
---
    
# [153. 寻找旋转排序数组中的最小值](https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/)
    
## Question

假设按照升序排序的数组在预先未知的某个点上进行了旋转。

( 例如，数组 `[0,1,2,4,5,6,7]` 可能变为 `[4,5,6,7,0,1,2]` )。

请找出其中最小的元素。

你可以假设数组中不存在重复元素。

示例 1:

```java
输入: [3,4,5,1,2]
输出: 1
```

示例 2:

```java
输入: [4,5,6,7,0,1,2]
输出: 0
```

## Solution

### 1. 线性查找

最简单的查找一趟遍历即可，毋庸置疑：

```java
public int findMin(int[] nums) {
    int mix = Integer.MAX_VALUE;
    for (int i = 0; i < nums.length; i++) {
        if (nums[i] < mix) mix = nums[i];
    }
    return mix;
}
```

时间复杂度 `O(n)`， 当数组长度不大时的确是最简单也高效的解决，但是长度很大时就需要使用二分查找了。

### 2. 二分法

与 [33. 搜索旋转排序数组](https://github.com/pushyzheng/Algorithms/tree/master/src/site/pushy/algorithms/leetcode/problemset/_33_Search_in_Rotated_Sorted_Array) 所分析的旋转排序数组规律一样，判断 `nums[mid] > nums[r]` 的条件是否成立：

- 如果成立：说明右边不是递增的，并且旋转点出现在右边，继续向右查找；

- 反之，说明右边是递增的，说明旋转点出现在左边，继续向左查找。

```java
public int findMin(int[] nums) {
    int l = 0, r = nums.length - 1;

    while (l < r) {
        int mid = l + (r - l) / 2;
        if (nums[mid] > nums[r]) {
            l = mid + 1;  // 向右查找更小元素
        } else {
            r = mid;  // 向左查找更大元素
        }
    }
    return nums[l];
}
```