---
export_on_save:
  html: true
---

# [202. 快乐数](https://leetcode-cn.com/problems/happy-number/)

## Question

编写一个算法来判断一个数是不是“快乐数”。

一个“快乐数”定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，然后重复这个过程直到这个数变为 1，也可能是无限循环但始终变不到 1。如果可以变为 1，那么这个数就是快乐数。

示例: 

```java
输入: 19
输出: true
解释: 
12 + 92 = 82
82 + 22 = 68
62 + 82 = 100
12 + 02 + 02 = 1
```

## Solution

这题并不难，我们每次都求出数字的每个位置上的数字的平方和，并置入哈希集合中。如果`n`不是快乐数则肯定**与之前计算的平方和存在重复**：

```java
public boolean isHappy(int n) {
    Set<Integer> set = new HashSet<>();
    set.add(n);

    while (n != 1) {
        n = getSquare(n);
        if (set.contains(n)) {  // 平方和重复
            return false;
        }
        set.add(n);
    }
    return true;
}

/**
 * 计算一个数的 “它每个位置上的数字的平方和”
 */
private int getSquare(int num) {
    int res = 0;
    while (num > 0) {
        res += Math.pow(num % 10, 2);
        num /= 10;
    }
    return res;
}
```