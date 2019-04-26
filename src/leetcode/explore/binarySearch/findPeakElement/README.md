# [162. 寻找峰值](https://leetcode-cn.com/problems/find-peak-element/)
    
## Question

峰值元素是指其值大于左右相邻值的元素。

给定一个输入数组 `nums`，其中 `nums[i] ≠ nums[i+1]`，找到峰值元素并返回其索引。

数组可能包含多个峰值，在这种情况下，**返回任何一个峰值所在位置即可。**

你可以假设 `nums[-1] = nums[n] = -∞`。

示例 1:

```java
输入: nums = [1,2,3,1]
输出: 2
解释: 3 是峰值元素，你的函数应该返回其索引 2。
```

示例 2:

```java
输入: nums = [1,2,1,3,5,6,4]
输出: 1 或 5 
解释: 你的函数可以返回索引 1，其峰值元素为 2；
     或者返回索引 5， 其峰值元素为 6。
```

说明:

你的解法应该是 `O(logN)` 时间复杂度的。

## Solution

### 1. 线性查找

使用暴力破解法寻找峰值，对于索引`i`，要求满足`nums[i] > nums[i - 1] && nums[i] > nums[i + 1]`条件即可。但是需要注意数组越界的问题：

```java
public int findPeakElement(int[] nums) {
    if (nums.length == 1) return 0;
    if (nums[0] > nums[1]) return 0;

    // 1 ~ nums.length - 1，防止数组越界
    for (int i = 1; i < nums.length - 1; i++) {
        if (nums[i] > nums[i - 1] && nums[i] > nums[i + 1]) {
            return i;
        }
    }
    // 注意题中说一定有峰值，说明如果一趟遍历没有找到峰值元素，那么肯定是最后一个元素
    return nums.length - 1;
}
```

我们可以对暴力破解进行一下优化：**在每次遍历时使用之前得到的结果**，即我们只需要判断前一个元素是否大于当前元素，就可以得出前一个元素是否是峰值元素。

这是因为：`nums[i - 2] < nums[i - 1]`的条件在上一次遍历时就成立了（否则早就返回函数）：

```java
public int findPeakElement(int[] nums) {
    if (nums.length == 1) return 0;
    if (nums[0] > nums[1]) return 0;

    for (int i = 1; i < nums.length; i++) {
        if (nums[i] < nums[i - 1]) return i - 1;
    }
    return nums.length - 1;
}
```

### 2. 二分查找

同样是对 [二分查找模板 II](https://leetcode-cn.com/explore/learn/card/binary-search/210/template-ii/839/) 的应用， 我们可以从实例中仔细观察，发现以下的规律：

- 如果`nums[i] > nums[i+1]`：则在 `i` 之前一定存在峰值元素；

- 如果`nums[i] < nums[i+1]`：则在 `i+1` 之后一定存在峰值元素。

```java
public int findPeakElement(int[] nums) {
    if (nums == null || nums.length == 0) return -1;

    int l = 0, r = nums.length - 1;
    while (l < r) {
        int mid = l + (r - l) / 2;
        if (nums[mid] < nums[mid + 1]) // 比较与mid+1的大小
            l = mid + 1;
        else
            r = mid;
    }
    // left == right
    return l;
}
```