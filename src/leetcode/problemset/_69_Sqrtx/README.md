---
export_on_save:
  html: true
---
    
# [69. x 的平方根](https://leetcode-cn.com/problems/sqrtx/)
    
## Question

实现 int sqrt(int x) 函数。

计算并返回 x 的平方根，其中 x 是非负整数。

由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。

示例 1:

```java
输入: 4
输出: 2
```

示例 2:

```java
输入: 8
输出: 2
说明: 8 的平方根是 2.82842..., 
     由于返回类型是整数，小数部分将被舍去。
```

## Solution

二分法的简单应用，需要注意的是 `mid * mid` 可能会溢出，因此需要将`mid * mid > x`的判断条件修改为`mid > x / mid`：

```java
public int mySqrt(int x) {
    if (x == 0 || x == 1) return x;
    int l = 0, r = x, res = -1;

    while (l <= r) {
        int mid = l + (r - l) / 2;
        if (mid <= x / mid) { // 向后查找，并记录mid
            l = mid + 1;
            res = mid;
        } else {
            r = mid - 1;
        }
    }
    return res;
}
```