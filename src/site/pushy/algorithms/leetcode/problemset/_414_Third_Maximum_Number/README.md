# 414. 第三大的数

## Question

给定一个非空数组，返回此数组中第三大的数。如果不存在，则返回数组中最大的数。要求算法时间复杂度必须是O(n)。

示例 1:

```java
输入: [3, 2, 1]
输出: 1
解释: 第三大的数是 1.
```
示例 2:

```java
输入: [1, 2]
输出: 2
解释: 第三大的数不存在, 所以返回最大的数 2 .
```

示例 3:

```java
输入: [2, 2, 3, 1]
输出: 1
解释: 注意，要求返回第三大的数，是指第三大且唯一出现的数。
存在两个值为2的数，它们都排第二。
```

## Solution

用三个变量来存储第一、二、三大的元素，在每次遍历时都将当前元素和这三个最大元素比较，并作出相应的操作：

```java
public int thirdMax(int[] nums) {
    if (nums.length == 1) return nums[0];
    if (nums.length == 2) return Math.max(nums[0], nums[1]);

    int max1 = Integer.MIN_VALUE;
    int max2 = Integer.MIN_VALUE;
    int max3 = Integer.MIN_VALUE;

    boolean flag = true;
    int ctn = 0;

    for (int i = 0; i < nums.length; i++) {
        if (nums[i] == Integer.MIN_VALUE && flag) {
            ctn++;
            flag = false;
        }
        if (nums[i] > max1) { // 大于最大的元素
            ctn++;
            max3 = max2;
            max2 = max1;
            max1 = nums[i];
        } else if (nums[i] > max2 && nums[i] < max1) { // 大于第二大元素
            ctn++;
            max3 = max2;
            max2 = nums[i];
        } else if (nums[i] > max3 && nums[i] < max2) { // 大于第三大元素
            ctn++;
            max3 = nums[i];
        }
    }
    return ctn >= 3 ? max3 : max1;
}
```