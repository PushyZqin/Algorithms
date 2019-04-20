---
export_on_save:
  html: true
---

# 9. 回文数

## Question

判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。

示例 1:

```java
输入: 121
输出: true
```

示例 2:

```java
输入: -121
输出: false
解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
```

示例 3:

```java
输入: 10
输出: false
解释: 从右向左读, 为 01 。因此它不是一个回文数。
```

进阶:

你能不将整数转为字符串来解决这个问题吗？

## Solution

题中说到能否**不将整数转为字符串来解决**，考点是操作一个整型数字上的每个数，可以让`x`对`10`取余数就可以依次得到个、十、百位上的数字，然后每次循环都除以10：

```java
for (; x != 0; x /= 10) {
    int num = x % 10;
}
```

明白了这种处理技巧，我们就可以先将所有位上的数字添加到列表中，然后遍历`0 ~ n / 2`，将第一位与最后一位比较是否相等，第二位与倒数第二位比较是否相等 ... 直到每个对应的元素都相等则说明是回文数：

```java
public boolean solution(int num) {
    if (x < 0 || (x % 10 == 0 && x != 0)) {
        return false;
    }

    List<Integer> list = new ArrayList<>();
    for (; x != 0; x /= 10) {
        list.add(x % 10);
    }

    int n = list.size();
    for (int i = 0; i < n / 2; i++) {
        if (!list.get(i).equals(list.get(n - 1 - i))) {
            return false;
        }
    }
    return true;
}
```

参考了[LeetCode官方题解](https://leetcode-cn.com/articles/palindrome-number/)，发现我们只要将反转一半数字，并将它与剩余的一半比较是否相等即可。

如何知道**反转数字的位数已经达到原始数字位数的一半**？只需要将原始数字除以 10，然后给反转后的数字乘上 10，所以，当原始数字小于反转后的数字时，就意味着我们已经处理了一半位数的数字。

```java
public boolean isPalindrome(int x) {
    if (x < 0 || (x % 10 == 0 && x != 0)) {
        return false;
    }
    int rn = 0;   // 反转后的数字
    while (x > rn) {
        rn = rn * 10 + x % 10;
        x /= 10;
    }
    // 由于处于中位的数字不影响回文（它总是与自己相等）
    // 所以我们可以简单地将其去除。
    return x == rn || x == rn / 10;
}
```

例如对于`45654`示例来说，输入如下：

```
rn => 456
x  => 45
```