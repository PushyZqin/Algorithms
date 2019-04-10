## 747. Largest Number At Least Twice of Others

在一个给定的数组nums中，总是存在一个最大元素 。

查找数组中的最大元素是否至少是数组中每个其他数字的两倍。

如果是，则返回最大元素的索引，否则返回-1。

示例 1:

```java
输入: nums = [3, 6, 1, 0]
输出: 1
解释: 6是最大的整数, 对于数组中的其他整数,
6大于数组中其他元素的两倍。6的索引是1, 所以我们返回1.
```

```java
示例 2:

输入: nums = [1, 2, 3, 4]
输出: -1
解释: 4没有超过3的两倍大, 所以我们返回 -1.
```

提示:

- nums 的长度范围在[1, 50].
- 每个 nums[i] 的整数范围在 [0, 99].


## Solution

简单解法，循环第一次找到数组的最大值，并记录该值和其下标；第二次循环将最大值与数组除了改值的**元素值 * 2** 结果进行比较，如果都满足则返回`idx`：

```java
public static int dominantIndex(int[] nums) {
    int max = 0, idx = 0;
    for (int i = 0; i < nums.length; i++) {
        if (nums[i] > max) {
            idx = i;
            max = nums[i];
        }
    }
    for (int num : nums) {
        if (num != max) {
            if (max < num * 2) return -1;
        }
    }
    return idx;
}
```

仔细想想，为什么我们要将最大值与所有元素进行比较呢？如果我们找到第二大的元素，将它的两倍的值与最大值进行比较，不就能证明最大值是否大于所有元素两倍的值吗？

```java
public int dominantIndex2(int[] nums) {
    if (nums.length == 0) return -1;
    if (nums.length == 1) return 0;

    int max = 0, idx = 0, less = 1;
    // 找到最大值和下标与第二大的的值
    for (int i = 0; i < nums.length; i++) {
        if (nums[i] > max) {
            less = max;
            max = nums[i];
            idx = i;
        } else if (nums[i] > less) {
            less = nums[i];
        }
    }
    // 比较最大值和第二大值的两倍
    return max >= (less * 2) ? idx : -1;
}
```