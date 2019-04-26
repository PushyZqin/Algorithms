# 209. 长度最小的子数组

## Question

给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的连续子数组。如果不存在符合条件的连续子数组，返回 0。

示例: 

```java
输入: s = 7, nums = [2,3,1,2,4,3]
输出: 2
解释: 子数组 [4,3] 是该条件下的长度最小的连续子数组。
```
进阶:

如果你已经完成了O(n) 时间复杂度的解法, 请尝试 O(n log n) 时间复杂度的解法。

## Solution

这题一开始没理解对题目，以为要求是元素位置连续并且值连续。但是实际上只要求位置的连续。

该题的解法依然是使用快慢双指针，慢指针`left`用于连续子数组的头元素，快指针`i`用于迭代数组。在每一次迭代中都会将值累加到`sum`和中，而当`sum`和大于等于`s`时，将会将慢指针向前移动，缩小连续子数组的大小（即元素的个数），从而能得到最小的连续子数组：

```java
public int minSubArrayLen(int s, int[] nums) {
    if (nums == null || nums.length == 0) return 0;

    int res = Integer.MAX_VALUE;
    int left = 0, sum = 0;
    for (int i = 0; i < nums.length; i++) {
        sum += nums[i];
        while (sum >= s) {
            res = Math.min(res, i - left + 1);
            sum -= nums[left];
            left++;
        }
    }
    return res == Integer.MAX_VALUE ? 0 : res;
}
```