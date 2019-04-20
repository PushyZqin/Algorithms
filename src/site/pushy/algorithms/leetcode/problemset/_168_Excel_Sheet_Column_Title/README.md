---
export_on_save:
  html: true
---

# 168. Excel表列名称

## Question

给定一个正整数，返回它在 Excel 表中相对应的列名称。

例如，

```java
1 -> A
2 -> B
3 -> C
...
26 -> Z
27 -> AA
28 -> AB 
...
```

示例 1:

```
输入: 1
输出: "A"
```

示例 2:

```
输入: 28
输出: "AB"
```

示例 3:

```
输入: 701
输出: "ZY"
```

## Solution

很简单的一道十进制转二十六进制的题，对26取得的取数 + `A`即可，需要注意的是每次循环都要减一：

```java
public String convertToTitle(int n) {
    if (n <= 0) return "";

    StringBuilder res = new StringBuilder();
    for (; n > 0; n /= 26) {
        n--;
        int r = n % 26;
        char ch = (char) (r + 'A');
        res.append(ch);
    }
    return res.reverse().toString();
}
```

与该题相对的一题是 [171. Excel表列序号](https://leetcode-cn.com/problems/excel-sheet-column-number/comments/)，将二十六进制转换为十进制。算法和二进制转换成十进制类似：

```java
public int titleToNumber(String s) {
    int res = 0;
    for (int i = s.length() - 1; i >= 0; i--) {
        int n = s.charAt(i) - 64;
        res += n * Math.pow(26, s.length() - i - 1);
    }
    return res;
}
```

或者用一个变量来记录需要每个二十六进制的元素需要乘以的数值，这样性能提升许多：

```java
public int titleToNumber(String s) {
    int res = 0;
    long base = 1;

    for (int i = s.length() - 1; i >= 0; i--) {
        res += (s.charAt(i) - 'A' + 1) * base;
        base *= 26;
    }
    return res;
}
```