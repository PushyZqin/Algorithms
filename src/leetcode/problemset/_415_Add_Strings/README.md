---
export_on_save:
  html: true
---

# [415. 字符串相加](https://leetcode-cn.com/problems/add-strings/)

## Question

给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。

注意：

- num1 和num2 的长度都小于 5100.
- num1 和num2 都只包含数字 0-9.
- num1 和num2 都不包含任何前导零。
- 你不能使用任何內建 BigInteger 库， 也不能直接将输入的字符串转换为整数形式。

示例：

```java
输入：num1 = "199", num2 = 9
输出：res = 208
```

## Solution

该题和 [67. 二进制求和](https://github.com/pushyzheng/Algorithms/tree/master/src/site/pushy/algorithms/leetcode/explore/string/addBinary) 类似，核心部分就是用一个`r`来记录两个数相加的“进数”。

- 当两个数相加的和（包括上一位数字累加的进数）大于等于`10`时，添加到该位上的数字为`和 - 10`，并将进数`r`设置为`1`；

- 当小于`10`时，直接添加到该位上的结果当中，并将进数重新设置为`0`。

```java
public String addStrings(String num1, String num2) {
    int i = num1.length() - 1, j = num2.length() - 1;
    StringBuilder res = new StringBuilder();
    int r = 0;

    while (i >= 0 || j >= 0) {
        int temp = 0;
        if (i >= 0) {
            temp += num1.charAt(i--) - '0';
        }
        if (j >= 0) {
            temp += num2.charAt(j--) - '0';
        }
        temp += r;
        if (temp >= 10) {
            res.append(temp - 10);
            r = 1;
        } else {
            res.append(temp);
            r = 0;
        }
    }
    // 处理特殊情况
    if (r != 0) res.append("1");
    return res.reverse().toString();
}
```