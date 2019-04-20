# 283. 移动零

## Question

给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。

示例:

```java
输入: [0,1,0,3,12]
输出: [1,3,12,0,0]
```

说明:

- 必须在原数组上操作，不能拷贝额外的数组。
- 尽量减少操作次数。

## Solution

和[27. 移除元素](https://github.com/pushyzheng/Algorithms/tree/master/src/site/pushy/algorithms/leetcode/explore/array/removeElement) 与 [26. 删除排序数组中的重复项](https://github.com/pushyzheng/Algorithms/blob/master/src/site/pushy/algorithms/leetcode/explore/array/removeDuplicates/README.md) 类似，我们一样通过快慢双指针来将非零元素移动到靠近数组的左边。

然后，从慢指针所指的位置`left`开始（前面都是不为零的元素）填充零，直到数组的末尾：

```java
public static void moveZeroes(int[] nums) {
    int left = 0;
    // 步骤一，将非零元素移动到靠近数组的左边
    for (int i = 0; i < nums.length; i++) {
        if (nums[i] != 0) nums[left++] = nums[i];
    }
    // 步骤二，填充[left, n]元素为0
    for (int i = left; i < nums.length; i++) {
        nums[i] = 0;
    }
}
```