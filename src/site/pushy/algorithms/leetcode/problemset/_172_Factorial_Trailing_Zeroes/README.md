---
export_on_save:
  html: true
---

# 172. 阶乘后的零

## Question

给定一个整数 n，返回 n! 结果尾数中零的数量。

示例 1:

```
输入: 3
输出: 0
解释: 3! = 6, 尾数中没有零。
```

示例 2:

```
输入: 5
输出: 1
解释: 5! = 120, 尾数中有 1 个零.
```

说明: 你算法的时间复杂度应为 O(log n) 。

## Solution

一开始我先将`n`阶乘求出之后，再通过切割数字的技巧，判断数字的末尾有几个零：

```java
public int trailingZeroes(int n) {
    long fac = 1;
    for (int i = 1; i <= n; i++) {
        fac *= i;
    }
    int res = 0;
    for (; fac > 0; fac /= 10) {
        if (fac % 10 == 0) res++;
        else break;
    }
    return res;
}
```

但是这种算法没有考虑阶乘的结果值溢出的情况，例如当`n = 30`时，`30!`的结果值为：`265252859812191058636308480000000 `，显然这种方法是不可行的。

参考了评论区高票的回答：

![TIM截图20190413185218.png](https://i.loli.net/2019/04/13/5cb1bf75e897f.png)

算法实现为：

```java
public int trailingZeroes(int n) {
    int res = 0, k = n;
    while (k > 1) {
        k /= 5;
        res += k;
    }
    return res;
}
```